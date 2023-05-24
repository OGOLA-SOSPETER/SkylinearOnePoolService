package seniordeveloper.peter.skylinearonepoolservice.data_Sets

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import seniordeveloper.peter.skylinearonepoolservice.R
import seniordeveloper.peter.skylinearonepoolservice.models.Screen

class DataList {
    val mutableStringList = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday","Sunday")
//    val mutableLoginData = mutableMapOf("username" to "password")
val mutableLoginData = mutableMapOf<String, String>()

}
data class OverflowData(val name:String, val route: String)

val overflowMenu  = listOf(
    OverflowData("View Profile",Screen.Profile.route),
    OverflowData("View Recents",Screen.Upnext.route),
    OverflowData("Book Appointment",Screen.Upnext.route),
    OverflowData("Transactions",Screen.Upnext.route),
    OverflowData("New Offers",Screen.Upnext.route),
    OverflowData("Log Out",Screen.Upnext.route)
)

@SuppressLint("SupportAnnotationUsage")
data class UserDataInfo(val name:String, val image:Int, @StringRes val description: Int)
val sampleData = listOf(
    UserDataInfo("Doctors", R.drawable.doctor, R.string.doctor_description),
    UserDataInfo("Message Delivery Agents",R.drawable.delivery,R.string.delivery_description),
    UserDataInfo("Teachers", R.drawable.teacher, R.string.teacher_description),
    UserDataInfo("Chefs", R.drawable.chef, R.string.chef_description),
    UserDataInfo("Drivers",R.drawable.driver,R.string.drivers),
    UserDataInfo("Pilots",R.drawable.pilot,R.string.pilot),
    UserDataInfo("Engineers",R.drawable.engineer,R.string.engineer)

)

data class UseCases(val name:String)

val useCase = listOf<UseCases>(
    UseCases("Teacher"),
    UseCases("Doctor"),
    UseCases("Lawyer"),
    UseCases("Mechanic"),
    UseCases("Programmer")


)