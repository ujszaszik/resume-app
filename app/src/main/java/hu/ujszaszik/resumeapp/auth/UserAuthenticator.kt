package hu.ujszaszik.resumeapp.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import hu.ujszaszik.resumeapp.register.UserData

class UserAuthenticator(
    private val onLogin: (String, String) -> Unit,
    private val onFailedAuthentication: () -> Unit,
    private val onFailedVerification: () -> Unit = {},
    private val needsToBeVerified: Boolean = false
) {

    fun login(data: UserData) {
        Firebase.auth
            .signInWithEmailAndPassword(data.email, data.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (needsToBeVerified && !isVerified()) onFailedVerification.invoke()
                    else onLogin.invoke(data.email, data.password)
                } else onFailedAuthentication.invoke()
            }
    }

    private fun isVerified(): Boolean {
        return true == FirebaseAuth.getInstance().currentUser?.isEmailVerified
    }
}