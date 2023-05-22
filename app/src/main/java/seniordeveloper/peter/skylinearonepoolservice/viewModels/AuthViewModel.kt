//package seniordeveloper.peter.skylinearonepoolservice.viewModels
//
//
//import android.content.Context
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.lifecycle.ViewModel
//import androidx.security.crypto.EncryptedSharedPreferences
//import androidx.security.crypto.MasterKeys
//import seniordeveloper.peter.skylinearonepoolservice.models.UserCredentials
//
//class AuthViewModel( private val context: Context) : ViewModel() {
//    private val registeredUsers = mutableListOf<UserCredentials>()
//    private val sharedPreferences = getEncryptedSharedPreferences()
//
//    init {
//        retrieveRegisteredUsers()
//    }
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    private fun getEncryptedSharedPreferences() =
//        EncryptedSharedPreferences.create(
//            "registered_users",
//            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
//            context,
//            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//        )
//
//    private fun retrieveRegisteredUsers() {
//        val usernames = sharedPreferences.getStringSet("usernames", setOf()) ?: setOf()
//        val passwords = sharedPreferences.getStringSet("passwords", setOf()) ?: setOf()
//
//        registeredUsers.clear()
//
//        for ((username, password) in usernames.zip(passwords)) {
//            registeredUsers.add(UserCredentials(username, password))
//        }
//    }
//
//    private fun persistRegisteredUsers() {
//        val usernames = registeredUsers.map { it.username }.toSet()
//        val passwords = registeredUsers.map { it.password }.toSet()
//
//        sharedPreferences.edit()
//            .putStringSet("usernames", usernames)
//            .putStringSet("passwords", passwords)
//            .apply()
//    }
//
//    fun register(username: String, password: String) {
//        val newUser = UserCredentials(username, password)
//        registeredUsers.add(newUser)
//        persistRegisteredUsers()
//    }
//
//    fun login(username: String, password: String): Boolean {
//        val matchedUser = registeredUsers.find { it.username == username && it.password == password }
//        return matchedUser != null
//    }
//}
//
//
//
//
//////
//////import androidx.lifecycle.ViewModel
//////import seniordeveloper.peter.skylinearonepoolservice.models.UserCredentials
//////
//////class AuthViewModel: ViewModel() {
//////    private val registeredUsers = mutableListOf<UserCredentials>()
//////
//////    fun register(username:String, password:String){
//////        val newUser = UserCredentials(username,password)
//////        registeredUsers.add(newUser)
//////    }
//////
//////    fun login(username: String,password: String):Boolean{
//////        val matchedUser = registeredUsers.find { it.username == username && it.password == password }
//////        return matchedUser != null
//////    }
//////}