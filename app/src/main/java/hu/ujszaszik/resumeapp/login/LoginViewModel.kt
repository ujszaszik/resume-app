package hu.ujszaszik.resumeapp.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import hu.ujszaszik.resumeapp.login.repository.LoginRepository
import hu.ujszaszik.resumeapp.register.UserData
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {

    private val _loginStatus = MutableLiveData<LoginStatus>()
    val loginStatus: LiveData<LoginStatus> get() = _loginStatus

    fun onAuthenticated(email: String, password: String) {
        viewModelScope.launch {
            repository.saveLoginState(true)
            repository.saveUserEmail(email)
            repository.saveUserPassword(password)
            _loginStatus.postValue(LoginStatus.Success)
        }
    }

    fun onAlreadyRegisteredUser(email: String) {
        FirebaseAuth.getInstance().currentUser
            ?.let { _loginStatus.postValue(LoginStatus.Success) }
            ?: onUserAlreadyDeleted(email)
    }

    private fun onUserAlreadyDeleted(email: String) {
        _loginStatus.postValue(LoginStatus.DeletedUser(email))
        viewModelScope.launch {
            repository.deleteUser()
        }
    }

    fun onNotValidated() {
        _loginStatus.postValue(LoginStatus.NotValidated)
    }

    fun onFailed() {
        viewModelScope.launch {
            repository.incrementFailedLoginCount()
            val failedCount = repository.getFailedLoginCount()
            _loginStatus.postValue(LoginStatus.Failed(failedCount))
        }
    }

    fun getLoggedInUserData(): UserData {
        return runBlocking {
            UserData(repository.getUserMail(), repository.getUserPassword())
        }
    }

    fun checkIfApplicationIsUnavailable() {
        runBlocking {
            if (repository.isApplicationUnavailableForUser()) {
                _loginStatus.postValue(LoginStatus.Unavailable)
            }
        }
    }

}