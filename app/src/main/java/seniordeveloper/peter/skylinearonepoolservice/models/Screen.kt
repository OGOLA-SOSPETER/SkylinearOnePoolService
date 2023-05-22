package seniordeveloper.peter.skylinearonepoolservice.models

sealed class Screen(val route: String){
    object Login:Screen(route = "loginPage")
    object Main:Screen(route = "mainPage")
    object Profile:Screen(route = "profilePage")
    object Settings:Screen(route = "settings")
    object Registration:Screen(route = "register")
    object SignUp:Screen(route = "signup")
}
