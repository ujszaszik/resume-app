package hu.ujszaszik.resumeapp.auth

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserVerificator(
    private val onSuccess: (String?) -> Unit,
    private val onFailed: () -> Unit
) {

    fun verify() {
        Firebase.auth.currentUser?.let { user ->
            user.sendEmailVerification().addOnCompleteListener {
                if (it.isSuccessful) onSuccess.invoke(user.email)
                else onFailed.invoke()
            }
        } ?: onFailed.invoke()
    }
}