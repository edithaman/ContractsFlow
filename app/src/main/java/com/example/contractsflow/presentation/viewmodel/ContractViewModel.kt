package com.example.contractsflow.presentation.viewmodel

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contractsflow.data.models.Contract
import com.example.contractsflow.data.models.ContractSignature
import com.example.contractsflow.data.models.ContractStatus
import com.example.contractsflow.domain.repository.AuthRepository
import com.example.contractsflow.domain.repository.ContractRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ContractViewModel @Inject constructor(
    private val contractRepository: ContractRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableLiveData<ContractUiState>()
    val uiState: LiveData<ContractUiState> = _uiState

    private val _contracts = MutableLiveData<List<Contract>>()
    val contracts: LiveData<List<Contract>> = _contracts

    private val _selectedContract = MutableLiveData<Contract?>()
    val selectedContract: LiveData<Contract?> = _selectedContract

    fun loadContracts() {
        viewModelScope.launch {
            val currentUser = authRepository.getCurrentUser()
            if (currentUser == null) {
                _uiState.value = ContractUiState(errorMessage = "User not authenticated")
                return@launch
            }

            _uiState.value = ContractUiState(isLoading = true)

            contractRepository.getContracts(currentUser.uid).fold(
                onSuccess = { contracts ->
                    _contracts.value = contracts
                    _uiState.value = ContractUiState()
                },
                onFailure = { exception ->
                    _uiState.value = ContractUiState(
                        errorMessage = exception.message ?: "Failed to load contracts"
                    )
                }
            )
        }
    }

    fun createContract(contract: Contract) {
        viewModelScope.launch {
            _uiState.value = ContractUiState(isLoading = true)

            contractRepository.createContract(contract).fold(
                onSuccess = { contractId ->
                    _uiState.value = ContractUiState(isSuccess = true)
                    loadContracts() // Refresh the list
                },
                onFailure = { exception ->
                    _uiState.value = ContractUiState(
                        errorMessage = exception.message ?: "Failed to create contract"
                    )
                }
            )
        }
    }

    fun signContract(contractId: String) {
        viewModelScope.launch {
            _uiState.value = ContractUiState(isLoading = true)

            val currentUser = authRepository.getCurrentUser()
            if (currentUser == null) {
                _uiState.value = ContractUiState(errorMessage = "User not authenticated")
                return@launch
            }

            // Fetch public IP address asynchronously
            val ipAddress = getPublicIpAddress() ?: "Unknown"

            val signature = ContractSignature(
                userId = currentUser.uid,
                signedAt = System.currentTimeMillis(),
                ipAddress = ipAddress,
                deviceInfo = android.os.Build.MODEL
            )

            contractRepository.signContract(contractId, signature).fold(
                onSuccess = {
                    loadContractDetails(contractId) // Refresh contract details after signing
                    loadContracts()
                    _uiState.value = ContractUiState(isSuccess = true)
                },
                onFailure = { exception ->
                    _uiState.value = ContractUiState(errorMessage = exception.message ?: "Failed to sign contract")
                }
            )
        }
    }

    fun loadContractDetails(contractId: String) {
        viewModelScope.launch {
            contractRepository.getContract(contractId).fold(
                onSuccess = { contract ->
                    _selectedContract.value = contract
                },
                onFailure = { exception ->
                    _uiState.value = ContractUiState(
                        errorMessage = exception.message ?: "Failed to load contract"
                    )
                }
            )
        }
    }

    fun updateContractStatus(contractId: String, status: ContractStatus) {
        viewModelScope.launch {
            _uiState.value = ContractUiState(isLoading = true)

            contractRepository.updateContractStatus(contractId, status).fold(
                onSuccess = {
                    _uiState.value = ContractUiState(isSuccess = true)
                    loadContractDetails(contractId) // Refresh details
                },
                onFailure = { exception ->
                    _uiState.value = ContractUiState(
                        errorMessage = exception.message ?: "Failed to update contract status"
                    )
                }
            )
        }
    }


    fun clearError() {
        _uiState.value = _uiState.value?.copy(errorMessage = null)
    }
}

data class ContractUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)
