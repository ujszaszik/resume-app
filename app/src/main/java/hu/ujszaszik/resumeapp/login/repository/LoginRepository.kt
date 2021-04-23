package hu.ujszaszik.resumeapp.login.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import hu.ujszaszik.resumeapp.extensions.*
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    companion object {
        private const val LOGGED_IN_KEY = "loggedInState"
        private const val FAILED_COUNT_KEY = "failedCount"
        private const val USER_EMAIL_KEY = "userEmail"
        private const val USER_PASSWORD_KEY = "userPassword"
        private const val TOO_MANY_WRONG_ATTEMPTS_KEY = "areTooManyWrongAttempts"
    }

    suspend fun isLoggedIn(): Boolean = dataStore.getBoolean(LOGGED_IN_KEY)

    suspend fun saveLoginState(value: Boolean) = dataStore.saveBoolean(LOGGED_IN_KEY, value)

    suspend fun incrementFailedLoginCount() = dataStore.increment(FAILED_COUNT_KEY)

    suspend fun getFailedLoginCount(): Int = dataStore.getInt(FAILED_COUNT_KEY)

    suspend fun saveUserEmail(email: String) = dataStore.saveString(USER_EMAIL_KEY, email)

    suspend fun getUserMail(): String = dataStore.getString(USER_EMAIL_KEY)

    suspend fun saveUserPassword(password: String) =
        dataStore.saveString(USER_PASSWORD_KEY, password)

    suspend fun getUserPassword(): String = dataStore.getString(USER_PASSWORD_KEY)

    suspend fun deleteUser() {
        dataStore.saveString(USER_EMAIL_KEY, "")
        dataStore.saveString(USER_PASSWORD_KEY, "")
    }

    suspend fun markApplicationUnavailableForUser() =
        dataStore.saveBoolean(TOO_MANY_WRONG_ATTEMPTS_KEY, true)

    suspend fun isApplicationUnavailableForUser(): Boolean =
        dataStore.getBoolean(TOO_MANY_WRONG_ATTEMPTS_KEY)

}