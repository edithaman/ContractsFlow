package com.example.contractsflow.data.models

data class Contract(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val amount: Double = 0.0,
    val currency: String = "USD",
    val creatorId: String = "",
    val participantIds: List<String> = emptyList(),
    val status: ContractStatus = ContractStatus.DRAFT,
    val terms: List<ContractTerm> = emptyList(),
    val attachments: List<String> = emptyList(),
    val signatures: Map<String, ContractSignature> = emptyMap(),
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val expiryDate: Long? = null,
    val settlementProofs: List<SettlementProof> = emptyList()
)

enum class ContractStatus {
    DRAFT, PENDING, ACTIVE, COMPLETED, CANCELLED, DISPUTED
}

data class ContractTerm(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val isRequired: Boolean = true,
    val order: Int = 0
)

data class ContractSignature(
    val userId: String = "",
    val signedAt: Long = 0L,
    val ipAddress: String = "",
    val deviceInfo: String = ""
)

