package com.example.contractsflow.presentation.viewmodel;

import com.example.contractsflow.domain.repository.AuthRepository;
import com.example.contractsflow.domain.repository.ContractRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class ContractViewModel_Factory implements Factory<ContractViewModel> {
  private final Provider<ContractRepository> contractRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  private ContractViewModel_Factory(Provider<ContractRepository> contractRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.contractRepositoryProvider = contractRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public ContractViewModel get() {
    return newInstance(contractRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static ContractViewModel_Factory create(
      Provider<ContractRepository> contractRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new ContractViewModel_Factory(contractRepositoryProvider, authRepositoryProvider);
  }

  public static ContractViewModel newInstance(ContractRepository contractRepository,
      AuthRepository authRepository) {
    return new ContractViewModel(contractRepository, authRepository);
  }
}
