package seniordeveloper.peter.skylinearonepoolservice.userFlows

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylinearonepoolservice.data.AuthRepositoryImpl_Factory
import seniordeveloper.peter.skylinearonepoolservice.models.Screen
import seniordeveloper.peter.skylinearonepoolservice.technicals.AboutApp
import seniordeveloper.peter.skylinearonepoolservice.technicals.PasswordReset
import seniordeveloper.peter.skylinearonepoolservice.technicals.RegistrationScreen
import seniordeveloper.peter.skylinearonepoolservice.technicals.SettingsPage
import seniordeveloper.peter.skylinearonepoolservice.technicals.SignUpUser
import seniordeveloper.peter.skylinearonepoolservice.viewModels.SignUpViewModel


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
        composable(Screen.SignUp.route){ SignUpUser().apply {  } }

        composable(Screen.About.route){ AboutApp(navController) }
        composable(Screen.Reset.route){ PasswordReset(navController) }




    }

    }
