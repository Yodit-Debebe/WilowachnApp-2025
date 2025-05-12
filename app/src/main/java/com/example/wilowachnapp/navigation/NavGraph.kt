package com.example.wilowachnapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wilowachnapp.presentation.screens.FirstScreen
import com.example.wilowachnapp.presentation.screens.LoginScreen
import com.example.wilowachnapp.presentation.screens.SignUpScreen
import com.example.wilowachnapp.presentation.screens.WelcomeScreen
import com.example.wilowachnapp.presentation.screens.Myjournals
import com.example.wilowachnapp.presentation.screens.JournalEditorScreen
import com.example.wilowachnapp.presentation.screens.ShareJournalScreen
import com.example.wilowachnapp.presentation.screens.SharedJournalPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "firstScreen") {

        composable("firstScreen") {
            FirstScreen(
                onLoginClick = { navController.navigate("loginScreen") },
                onSignUpClick = { navController.navigate("signUpScreen") })
        }
        composable("loginScreen") {
            LoginScreen(
                navController = navController,
                onForgotPasswordClick = {  },
                onLoginClick = { navController.navigate("welcome") })
        }
        composable("signUpScreen") {
            SignUpScreen(
                navController = navController,
                onSignUpClick = { navController.navigate("loginScreen") })
        }

        composable("welcome"){ WelcomeScreen(navController) }

        composable("myjournals") { Myjournals(navController) }
        composable("SharedJournalPage") { SharedJournalPage(navController) }
        composable("editor"){JournalEditorScreen(
            navController = navController,
            onSave = {navController.navigate("myjournals")},
            onDelete ={ },
            onBack = {navController.navigate("myjournals")}
        )}
        composable("sharing"){ShareJournalScreen(navController)}
    }
}

