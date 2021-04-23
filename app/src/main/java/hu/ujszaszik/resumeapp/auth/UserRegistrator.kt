package hu.ujszaszik.resumeapp.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserRegistrator(
    private val onSuccess: (String, String) -> Unit,
    private val onAlreadyRegistered: () -> Unit,
    private val onFail: () -> Unit
) {

    fun create(email: String, password: String) {
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) onSuccess.invoke(email, password)
                else {
                    if (task.isAlreadyRegistered()) onAlreadyRegistered.invoke()
                    else onFail.invoke()
                }
            }
    }

}

private fun Task<AuthResult>.isAlreadyRegistered(): Boolean {
    return exception is FirebaseAuthUserCollisionException
}