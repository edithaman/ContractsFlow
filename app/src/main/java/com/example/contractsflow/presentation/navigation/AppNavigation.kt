package com.example.contractsflow.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contractsflow.presentation.ui.ContractDetailScreen
import com.example.contractsflow.presentation.ui.CreateContractScreen
import com.example.contractsflow.presentation.ui.DashboardScreen
import com.example.contractsflow.presentation.ui.LoginScreen
import com.example.contractsflow.presentation.ui.ProfileScreen
import com.example.contractsflow.presentation.ui.SignUpScreen
import com.example.contractsflow.presentation.viewmodel.AuthViewModel

@Composable
fun AppNavigation(
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val currentUser by authViewModel.currentUser.observeAsState()

    NavHost(
        navController = navController,
        startDestination = if (currentUser != null) "home" else "login"
    ) {
        // Auth Flow
        composable("login") {
            LoginScreen(
                onNavigateToSignUp = {
                    navController.navigate("signup") {
                        popUpTo("login") { inclusive = false }
                    }
                },
                onNavigateToHome = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("signup") {
            SignUpScreen(
                onNavigateToLogin = {
                    navController.navigate("login") {
                        popUpTo("signup") { inclusive = true }
                    }
                },
                onNavigateToHome = {
                    navController.navigate("home") {
                        popUpTo("signup") { inclusive = true }
                    }
                }
            )
        }

        // Main App Flow
        composable("home") {
            DashboardScreen(
                onNavigateToCreateContract = {
                    navController.navigate("create_contract")
                },
                onNavigateToContractDetail = { contractId ->
                    navController.navigate("contract_detail/$contractId")
                },
                onNavigateToProfile = {
                    navController.navigate("profile")
                }
            )
        }

        composable("create_contract") {
            CreateContractScreen(
                onNavigateBack = { navController.popBackStack() },
                onContractCreated = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            "contract_detail/{contractId}",
            arguments = listOf(navArgument("contractId") { type = NavType.StringType })
        ) { backStackEntry ->
            val contractId = backStackEntry.arguments?.getString("contractId") ?: ""
            ContractDetailScreen(
                contractId = contractId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable("profile") {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() },
                onSignOut = {
                    authViewModel.signOut()
                    navController.navigate("login") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}
