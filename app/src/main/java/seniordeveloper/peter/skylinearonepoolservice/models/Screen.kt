package seniordeveloper.peter.skylinearonepoolservice.models

sealed class Screen(val route: String){
    object Login:Screen(route = "loginPage")
    object Main:Screen(route = "mainPage")
    object Profile:Screen(route = "profilePage")
    object Settings:Screen(route = "settings")
    object Registration:Screen(route = "register")
    object About:Screen(route = "about_dev")
    object Reset:Screen(route = "reset_pass")
    object Upnext:Screen(route = "next")



}
