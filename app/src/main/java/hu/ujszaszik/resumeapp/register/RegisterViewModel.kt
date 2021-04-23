package hu.ujszaszik.resumeapp.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _registerStatus = MutableLiveData<RegisterStatus>()
    val registerStatus: LiveData<RegisterStatus> get() = _registerStatus

    fun onSuccessfulRegistration(data: UserData) =
        postRegisterStatus(RegisterStatus.SuccessfulRegistration(data))

    fun onFailedRegistration() = postRegisterStatus(RegisterStatus.FailedRegistration)

    fun onAlreadyRegistered() = postRegisterStatus(RegisterStatus.AlreadyRegistered)

    fun onVerificationSent(email: String?) =
        postRegisterStatus(RegisterStatus.VerificationSent(email))

    fun onVerificationSendFailed() = postRegisterStatus(RegisterStatus.VerificationSendFailed)

    fun onLoggedInWithRegisteredUser() =
        postRegisterStatus(RegisterStatus.LoggedInWithRegisteredUser)

    fun onLoginWithRegisteredUserFailed() =
        postRegisterStatus(RegisterStatus.LoginWithRegisteredUserFailed)

    private fun postRegisterStatus(status: RegisterStatus) = _registerStatus.postValue(status)

}