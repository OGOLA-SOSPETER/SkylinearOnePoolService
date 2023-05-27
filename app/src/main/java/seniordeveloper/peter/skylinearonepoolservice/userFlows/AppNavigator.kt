package seniordeveloper.peter.skylinearonepoolservice.userFlows

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.firebase.database.core.Context
import seniordeveloper.peter.skylinearonepoolservice.data.FirebaseDatas
import seniordeveloper.peter.skylinearonepoolservice.data_Sets.sampleData
import seniordeveloper.peter.skylinearonepoolservice.models.Screen
import seniordeveloper.peter.skylinearonepoolservice.technicals.AboutApp
import seniordeveloper.peter.skylinearonepoolservice.technicals.PasswordReset
import seniordeveloper.peter.skylinearonepoolservice.technicals.RegistrationScreen
import seniordeveloper.peter.skylinearonepoolservice.technicals.SettingsPage
import seniordeveloper.peter.skylinearonepoolservice.technicals.UpNext


@Composable
fun AppNavigation(
    navController: NavHostController) {
    val userData = sampleData
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    )
    {
        composable(route = Screen.Login.route) { UserLoginPage(navController) }
        composable(Screen.Main.route) { AppDashboard(navController) }
        composable(Screen.Profile.route) { Profile(navController) }
        composable(Screen.Settings.route) { SettingsPage(navController) }
        composable(Screen.Registration.route) { RegistrationScreen(navController) }
        composable(Screen.About.route) { AboutApp(navController) }
        composable(Screen.Reset.route) { PasswordReset(navController) }
        composable(Screen.Upnext.route) { UpNext(navController) }
        composable(Screen.Reset.route) { ItemDetailsScreen(navController) }
        composable(Screen.Bottomsheet.route){ ExtraSheet(navController)}
        composable(Screen.Fire.route){ FirebaseDatas(navController, context = LocalContext.current)}
    }
}
