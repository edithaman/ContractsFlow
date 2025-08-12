package com.example.contractsflow.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\""}, d2 = {"Lcom/example/contractsflow/presentation/viewmodel/ContractViewModel;", "Landroidx/lifecycle/ViewModel;", "contractRepository", "Lcom/example/contractsflow/domain/repository/ContractRepository;", "authRepository", "Lcom/example/contractsflow/domain/repository/AuthRepository;", "(Lcom/example/contractsflow/domain/repository/ContractRepository;Lcom/example/contractsflow/domain/repository/AuthRepository;)V", "_contracts", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/contractsflow/data/models/Contract;", "_selectedContract", "_uiState", "Lcom/example/contractsflow/presentation/viewmodel/ContractUiState;", "contracts", "Landroidx/lifecycle/LiveData;", "getContracts", "()Landroidx/lifecycle/LiveData;", "selectedContract", "getSelectedContract", "uiState", "getUiState", "clearError", "", "createContract", "contract", "loadContractDetails", "contractId", "", "loadContracts", "signContract", "updateContractStatus", "status", "Lcom/example/contractsflow/data/models/ContractStatus;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ContractViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.contractsflow.domain.repository.ContractRepository contractRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.contractsflow.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.contractsflow.presentation.viewmodel.ContractUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.contractsflow.presentation.viewmodel.ContractUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.contractsflow.data.models.Contract>> _contracts = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.contractsflow.data.models.Contract>> contracts = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.contractsflow.data.models.Contract> _selectedContract = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.contractsflow.data.models.Contract> selectedContract = null;
    
    @jakarta.inject.Inject()
    public ContractViewModel(@org.jetbrains.annotations.NotNull()
    com.example.contractsflow.domain.repository.ContractRepository contractRepository, @org.jetbrains.annotations.NotNull()
    com.example.contractsflow.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.contractsflow.presentation.viewmodel.ContractUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.contractsflow.data.models.Contract>> getContracts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.contractsflow.data.models.Contract> getSelectedContract() {
        return null;
    }
    
    public final void loadContracts() {
    }
    
    public final void createContract(@org.jetbrains.annotations.NotNull()
    com.example.contractsflow.data.models.Contract contract) {
    }
    
    public final void signContract(@org.jetbrains.annotations.NotNull()
    java.lang.String contractId) {
    }
    
    public final void loadContractDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String contractId) {
    }
    
    public final void updateContractStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String contractId, @org.jetbrains.annotations.NotNull()
    com.example.contractsflow.data.models.ContractStatus status) {
    }
    
    public final void clearError() {
    }
}