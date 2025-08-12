package com.example.contractsflow.presentation.viewmodel

import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getPublicIpAddress(): String? = withContext(Dispatchers.IO) {
    try {
        URL("https://api.ipify.org").readText()
    } catch (e: Exception) {
        null
    }
}