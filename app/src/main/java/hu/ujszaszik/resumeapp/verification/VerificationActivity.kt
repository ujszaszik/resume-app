package hu.ujszaszik.resumeapp.verification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ujszaszik.resumeapp.R
import com.ujszaszik.resumeapp.databinding.ActivityVerificationBinding
import hu.ujszaszik.resumeapp.extensions.getStringExtra
import hu.ujszaszik.resumeapp.extensions.startActivityWithEmailExtra
import hu.ujszaszik.resumeapp.login.LoginActivity

class VerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verification)
        val emailToVerify = getStringExtra(R.string.intent_extra_new_email)
        setBackToMainPageButtonListener(emailToVerify)
    }

    private fun setBackToMainPageButtonListener(emailToVerify: String?) {
        binding.backToMainPageButton.setOnClickListener {
            startActivityWithEmailExtra(LoginActivity::class, emailToVerify)
        }
    }
}