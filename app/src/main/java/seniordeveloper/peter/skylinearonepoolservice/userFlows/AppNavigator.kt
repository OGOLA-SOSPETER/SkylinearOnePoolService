package seniordeveloper.peter.skylinearonepoolservice.userFlows

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import seniordeveloper.peter.skylinearonepoolservice.models.Screen
import seniordeveloper.peter.skylinearonepoolservice.technicals.AboutApp
import seniordeveloper.peter.skylinearonepoolservice.technicals.PasswordReset
import seniordeveloper.peter.skylinearonepoolservice.technicals.RegistrationScreen
import seniordeveloper.peter.skylinearonepoolservice.technicals.SettingsPage


@Composable
fun AppNavigation(
    navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route)
    {
        composable(route = Screen.Login.route){ UserLoginPage(navController)}
        composable(Screen.Main.route){ AppDashboard(navController)}
        composable(Screen.Profile.route){ Profile(navController) }
        composable(Screen.Settings.route){ SettingsPage(navController) }
        composable(Screen.Registration.route){ RegistrationScreen(navController) }
        composable(Screen.About.route){ AboutApp(navController) }
        composable(Screen.Reset.route){ PasswordReset(navController) }

    }

    }
