package seniordeveloper.peter.skylinearonepoolservice.data

import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import seniordeveloper.peter.skylinearonepoolservice.Resource

interface AuthRepository {
    fun loginUser(email:String,password:String): Flow<Resource<AuthResult>>
    fun registerUser(email: String,password: String):Flow<Resource<AuthResult>>

}