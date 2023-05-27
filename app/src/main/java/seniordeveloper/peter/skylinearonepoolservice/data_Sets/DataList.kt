package seniordeveloper.peter.skylinearonepoolservice.data_Sets

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import seniordeveloper.peter.skylinearonepoolservice.R
import seniordeveloper.peter.skylinearonepoolservice.models.Screen

class DataList {
    val mutableStringList = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday","Sunday")
//    val mutableLoginData = mutableMapOf("username" to "password")
val mutableLoginData = mutableMapOf<String, String>()

}
data class OverflowData(val name:String,val route:String )

val overflowMenu  = listOf(
    OverflowData("View Profile",Screen.Profile.route),
    OverflowData("View Recents",Screen.Upnext.route),
    OverflowData("Book Appointment",Screen.Upnext.route),
    OverflowData("Transactions",Screen.Upnext.route),
    OverflowData("New Offers",Screen.Upnext.route),
    OverflowData("Log Out",Screen.Login.route),
    OverflowData("Bottom Sheet",Screen.Bottomsheet.route),
    OverflowData("FireBaseData",Screen.Fire.route)
)

@SuppressLint("SupportAnnotationUsage")
data class UserDataInfo(var name:String, val image:Int, @StringRes val description: Int)
val sampleData = listOf(
    UserDataInfo("Doctors", R.drawable.doctor, R.string.doctor_description),
    UserDataInfo("Message Delivery Agents",R.drawable.delivery,R.string.delivery_description),
    UserDataInfo("Teachers", R.drawable.teacher, R.string.teacher_description),
    UserDataInfo("Chefs", R.drawable.chef, R.string.chef_description),
    UserDataInfo("Drivers",R.drawable.driver,R.string.drivers),
    UserDataInfo("Pilots",R.drawable.pilot,R.string.pilot),
    UserDataInfo("Engineers",R.drawable.engineer,R.string.engineer),
    UserDataInfo("Architects",R.drawable.artist,R.string.artist)

)

data class UseCases(val name:String,val route:String)

val useCase = listOf<UseCases>(
    UseCases("Teacher",Screen.User.route),
    UseCases("Doctor",Screen.User.route),
    UseCases("Lawyer",Screen.User.route),
    UseCases("Mechanic",Screen.User.route),
    UseCases("Programmer",Screen.User.route)
)

data class UserData(val id:String, val useName:String, val image: Int, val rate: Float)

val sampleUsers = listOf<UserData>(
    UserData("Optician","John Maina Njenga",R.drawable.doctor,4.5F),
    UserData("Doctor","Lucy Njeri",R.drawable.doctor,8.5F),
    UserData("Plumber","Naomi Wachira",R.drawable.doctor,4.5F),
    UserData("Doctor","Thomas Njahi",R.drawable.doctor,8.0F),
    UserData("Teacher","Paul Kosgei",R.drawable.doctor,4.5F),
    UserData("Doctor","Nancy Mutua",R.drawable.doctor,5.5F),
    UserData("Teacher","Naomi Nahimi",R.drawable.doctor,4.5F),
    UserData("Doctor","Jeff Jeptony",R.drawable.doctor,5.0F),
    UserData("BusinessMan","Caroline Khaemba",R.drawable.doctor,6.5F),
    UserData("Doctor","Vincent Rembo",R.drawable.doctor,7.0F),
    UserData("Teacher","Calvince Otieno",R.drawable.doctor,4.5F)


)