package com.example.contractsflow.domain.repository

import com.example.contractsflow.data.models.Contract
import com.example.contractsflow.data.models.ContractSignature
import com.example.contractsflow.data.models.ContractStatus
import com.example.contractsflow.data.models.SettlementProof
import com.example.contractsflow.data.models.User

interface ContractRepository {
    suspend fun createContract(contract: Contract): Result<String>
    suspend fun getContracts(userId: String): Result<List<Contract>>
    suspend fun getContract(contractId: String): Result<Contract>
    suspend fun updateContract(contract: Contract): Result<Unit>
    suspend fun signContract(contractId: String, signature: ContractSignature): Result<Unit>
    suspend fun addSettlementProof(contractId: String, proof: SettlementProof): Result<Unit>
    suspend fun updateContractStatus(contractId: String, status: ContractStatus): Result<Unit>
}

