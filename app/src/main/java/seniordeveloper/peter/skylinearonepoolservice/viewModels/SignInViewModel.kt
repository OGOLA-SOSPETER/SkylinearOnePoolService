package seniordeveloper.peter.skylinearonepoolservice.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import seniordeveloper.peter.skylinearonepoolservice.Resource
import seniordeveloper.peter.skylinearonepoolservice.data.AuthRepository
import seniordeveloper.peter.skylinearonepoolservice.data_Sets.SignInState
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: AuthRepository
):ViewModel() {

    val _signInState = Channel<SignInState>()
    val signInState = _signInState.receiveAsFlow()

    fun loginUser(email:String, password:String) = viewModelScope.launch {
        repository.loginUser(email, password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _signInState.send(SignInState(isSuccess = "Sign In Success."))
                }
                is Resource.Loading -> {
                    _signInState.send(SignInState(isLoading = true))
                }
                is Resource.Error ->{
                    _signInState.send(SignInState(isError = result.message))
                }
            }
        }
    }

}