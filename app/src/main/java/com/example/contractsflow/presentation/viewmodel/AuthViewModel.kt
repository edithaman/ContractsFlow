package com.example.contractsflow.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contractsflow.data.models.User
import com.example.contractsflow.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableLiveData<AuthUiState>()
    val uiState: LiveData<AuthUiState> = _uiState

    private val _currentUser = MutableLiveData<User?>()
    val currentUser: LiveData<User?> = _currentUser

    init {
        checkCurrentUser()
    }

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState(isLoading = true)

            authRepository.signIn(email, password).fold(
                onSuccess = { user ->
                    _currentUser.value = user
                    _uiState.value = AuthUiState(isSuccess = true)
                },
                onFailure = { exception ->
                    _uiState.value = AuthUiState(
                        isError = true,
                        errorMessage = exception.message ?: "Sign in failed"
                    )
                }
            )
        }
    }

    fun signUp(email: String, password: String, displayName: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState(isLoading = true)

            authRepository.signUp(email, password, displayName).fold(
                onSuccess = { user ->
                    _currentUser.value = user
                    _uiState.value = AuthUiState(isSuccess = true)
                },
                onFailure = { exception ->
                    _uiState.value = AuthUiState(
                        isError = true,
                        errorMessage = exception.message ?: "Sign up failed"
                    )
                }
            )
        }
    }

    fun signOut() {
        viewModelScope.launch {
            authRepository.signOut()
            _currentUser.value = null
            _uiState.value = AuthUiState()
        }
    }

    private fun checkCurrentUser() {
        viewModelScope.launch {
            _currentUser.value = authRepository.getCurrentUser()
        }
    }

    fun updateUserProfile(user: User) {
        viewModelScope.launch {
            _uiState.value = AuthUiState(isLoading = true)

            authRepository.updateUserProfile(user).fold(
                onSuccess = {
                    _currentUser.value = user
                    _uiState.value = AuthUiState(isSuccess = true)
                },
                onFailure = { exception ->
                    _uiState.value = AuthUiState(
                        isError = true,
                        errorMessage = exception.message ?: "Failed to update profile"
                    )
                }
            )
        }
    }


    fun clearError() {
        _uiState.value = _uiState.value?.copy(isError = false, errorMessage = null)
    }
}

data class AuthUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)
