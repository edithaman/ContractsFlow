package com.example.contractsflow.di;

import com.example.contractsflow.domain.repository.ContractRepository;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideContractRepositoryFactory implements Factory<ContractRepository> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<FirebaseStorage> storageProvider;

  private AppModule_ProvideContractRepositoryFactory(Provider<FirebaseFirestore> firestoreProvider,
      Provider<FirebaseStorage> storageProvider) {
    this.firestoreProvider = firestoreProvider;
    this.storageProvider = storageProvider;
  }

  @Override
  public ContractRepository get() {
    return provideContractRepository(firestoreProvider.get(), storageProvider.get());
  }

  public static AppModule_ProvideContractRepositoryFactory create(
      Provider<FirebaseFirestore> firestoreProvider, Provider<FirebaseStorage> storageProvider) {
    return new AppModule_ProvideContractRepositoryFactory(firestoreProvider, storageProvider);
  }

  public static ContractRepository provideContractRepository(FirebaseFirestore firestore,
      FirebaseStorage storage) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideContractRepository(firestore, storage));
  }
}
