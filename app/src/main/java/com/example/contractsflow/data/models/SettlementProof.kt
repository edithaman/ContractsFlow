package com.example.contractsflow.data.models

data class SettlementProof(
    val id: String = "",
    val uploadedBy: String = "",
    val fileUrl: String = "",
    val fileName: String = "",
    val description: String = "",
    val uploadedAt: Long = System.currentTimeMillis(),
    val verifiedBy: List<String> = emptyList()
)