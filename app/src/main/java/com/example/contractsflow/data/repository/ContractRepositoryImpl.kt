package com.example.contractsflow.data.repository

import com.example.contractsflow.data.models.Contract
import com.example.contractsflow.data.models.ContractSignature
import com.example.contractsflow.data.models.ContractStatus
import com.example.contractsflow.data.models.SettlementProof
import com.example.contractsflow.domain.repository.ContractRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.tasks.await

@Singleton
class ContractRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage
) : ContractRepository {

    private val contractsCollection = firestore.collection("contracts")

    override suspend fun createContract(contract: Contract): Result<String> = try {
        val docRef = contractsCollection.document()
        val contractWithId = contract.copy(id = docRef.id)
        docRef.set(contractWithId).await()
        Result.success(docRef.id)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun getContracts(userId: String): Result<List<Contract>> = try {
        val query = contractsCollection
            .whereArrayContains("participantIds", userId)
            .orderBy("updatedAt", Query.Direction.DESCENDING)

        val snapshot = query.get().await()
        val contracts = snapshot.documents.mapNotNull {
            it.toObject(Contract::class.java)
        }
        Result.success(contracts)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun getContract(contractId: String): Result<Contract> = try {
        val document = contractsCollection.document(contractId).get().await()
        val contract = document.toObject(Contract::class.java)
        if (contract != null) {
            Result.success(contract)
        } else {
            Result.failure(Exception("Contract not found"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun updateContract(contract: Contract): Result<Unit> = try {
        contractsCollection.document(contract.id)
            .set(contract.copy(updatedAt = System.currentTimeMillis()))
            .await()
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun signContract(contractId: String, signature: ContractSignature): Result<Unit> {
        val contractRef = firestore.collection("contracts").document(contractId)
        return try {
            firestore.runTransaction { transaction ->
                // Optionally: Check contract exists
                val snapshot = transaction.get(contractRef)
                if (!snapshot.exists()) throw Exception("Contract not found")

                // This line updates ONLY the map entry signatures.userId and the updatedAt field
                val updateData = mapOf(
                    "signatures.${signature.userId}" to signature,
                    "updatedAt" to System.currentTimeMillis()
                )
                transaction.update(contractRef, updateData)
            }.await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun addSettlementProof(contractId: String, proof: SettlementProof): Result<Unit> = try {
        val contractRef = contractsCollection.document(contractId)
        firestore.runTransaction { transaction ->
            val contract = transaction.get(contractRef).toObject(Contract::class.java)
                ?: throw Exception("Contract not found")

            val updatedProofs = contract.settlementProofs.toMutableList()
            updatedProofs.add(proof)

            val updatedContract = contract.copy(
                settlementProofs = updatedProofs,
                updatedAt = System.currentTimeMillis()
            )

            transaction.set(contractRef, updatedContract)
        }.await()
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun updateContractStatus(contractId: String, status: ContractStatus): Result<Unit> = try {
        contractsCollection.document(contractId)
            .update(
                mapOf(
                    "status" to status,
                    "updatedAt" to System.currentTimeMillis()
                )
            ).await()
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }
}
