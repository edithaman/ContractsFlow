package com.example.contractsflow.presentation.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a2\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00010\u0010H\u0007\u001a\"\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00a8\u0006\u0018"}, d2 = {"ContractDetailScreen", "", "contractId", "", "viewModel", "Lcom/example/contractsflow/presentation/viewmodel/ContractViewModel;", "authViewModel", "Lcom/example/contractsflow/presentation/viewmodel/AuthViewModel;", "onNavigateBack", "Lkotlin/Function0;", "SettlementProofItem", "proof", "Lcom/example/contractsflow/data/models/SettlementProof;", "SettlementProofUploadDialog", "onDismiss", "onUpload", "Lkotlin/Function2;", "Landroid/net/Uri;", "SignatureItem", "participantId", "signature", "Lcom/example/contractsflow/data/models/ContractSignature;", "isCurrentUser", "", "app_debug"})
public final class ContractDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ContractDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String contractId, @org.jetbrains.annotations.NotNull()
    com.example.contractsflow.presentation.viewmodel.ContractViewModel viewModel, @org.jetbrains.annotations.NotNull()
    com.example.contractsflow.presentation.viewmodel.AuthViewModel authViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SignatureItem(@org.jetbrains.annotations.NotNull()
    java.lang.String participantId, @org.jetbrains.annotations.Nullable()
    com.example.contractsflow.data.models.ContractSignature signature, boolean isCurrentUser) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SettlementProofItem(@org.jetbrains.annotations.NotNull()
    com.example.contractsflow.data.models.SettlementProof proof) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SettlementProofUploadDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super android.net.Uri, kotlin.Unit> onUpload) {
    }
}