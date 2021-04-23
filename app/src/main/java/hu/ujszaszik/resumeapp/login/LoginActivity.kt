package hu.ujszaszik.resumeapp.login

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ujszaszik.resumeapp.R
import com.ujszaszik.resumeapp.databinding.ActivityLoginBinding
import dagger.android.AndroidInjection
import hu.ujszaszik.resumeapp.auth.UserAuthenticator
import hu.ujszaszik.resumeapp.extensions.*
import hu.ujszaszik.resumeapp.input.message.ErrorMessageCreator
import hu.ujszaszik.resumeapp.login.validator.LoginFieldState
import hu.ujszaszik.resumeapp.login.validator.LoginValidator
import hu.ujszaszik.resumeapp.register.RegisterActivity
import hu.ujszaszik.resumeapp.register.UserData
import hu.ujszaszik.resumeapp.register.balloon.BalloonFactory
import hu.ujszaszik.resumeapp.register.balloon.BalloonType
import hu.ujszaszik.resumeapp.register.balloon.onCancelled
import hu.ujszaszik.resumeapp.resume.ResumeActivity
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var viewModel: LoginViewModel

    @Inject
    lateinit var buttonAnimator: GradientAnimator

    @Inject
    lateinit var validator: LoginValidator

    private val userAuthenticator = UserAuthenticator(
        onLogin = { email, pwd -> viewModel.onAuthenticated(email, pwd) },
        onFailedAuthentication = { viewModel.onFailed() },
        onFailedVerification = { viewModel.onNotValidated() },
        needsToBeVerified = true
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        observeLoginState()

        viewModel.checkIfApplicationIsUnavailable()
        val currentUserData = viewModel.getLoggedInUserData()
        if (currentUserData.isValid()) doOnAlreadyLoggedInUser(currentUserData.email)
        else initScreenForNotLoggedInUser()
    }

    private fun doOnAlreadyLoggedInUser(email: String) {
        binding.loginLayout.visibility = View.GONE
        binding.loginProgressBar.visibility = View.VISIBLE
        viewModel.onAlreadyRegisteredUser(email)
    }

    private fun initScreenForNotLoggedInUser() {
        initFieldsIfJustRegistered()
        setLoginButtonListener()
        setRegisterListener()
    }

    private fun initFieldsIfJustRegistered() {
        val email = getStringExtra(R.string.intent_extra_new_email)
        email?.let {
            binding.editTextEmail.text = SpannableStringBuilder(it)
            showRegistrationSuccessBalloon()
        }
    }

    private fun showRegistrationSuccessBalloon() {
        BalloonFactory(this)
            .create(getString(R.string.register_successful_registration), BalloonType.SUCCESS)
            .onCancelled { }
            .show(binding.bottomPlaceholder)
    }

    private fun showSimpleErrorBalloon(messageId: Int) {
        ErrorMessageCreator.init(binding.bottomPlaceholder).createSimpleMessage(messageId)
    }

    private fun setLoginButtonListener() {
        binding.loginButton.setOnClickListener {
            closeKeyboard()
            buttonAnimator.start(binding.loginButton)
            val email = binding.editTextEmail.value()
            val password = binding.editTextPassword.value()
            if (areFieldsValid(email, password)) doLogin(email, password)
        }
    }

    private fun doLogin(email: String, password: String) {
        binding.progressBar.visibility = View.VISIBLE
        userAuthenticator.login(UserData(email, password))
    }

    private fun areFieldsValid(email: String, password: String): Boolean {
        return validateEmail(email) && validatePassword(password)
    }

    private fun validateEmail(email: String): Boolean {
        return when (val result = validator.validateEmail(email)) {
            is LoginFieldState.Valid -> true
            is LoginFieldState.Invalid -> {
                ErrorMessageCreator.init(binding.bottomPlaceholder)
                    .createMessage(binding.editTextEmail, binding.textInputEmail, result.messageId)
                false
            }
        }
    }

    private fun validatePassword(password: String): Boolean {
        return when (val result = validator.validatePassword(password)) {
            is LoginFieldState.Valid -> {
                binding.textInputPassword.error = null
                true
            }
            is LoginFieldState.Invalid -> {
                ErrorMessageCreator.init(binding.bottomPlaceholder)
                    .createMessage(binding.editTextPassword, binding.textInputPassword, result.messageId)
                false
            }
        }
    }

    private fun observeLoginState() {
        viewModel.loginStatus.observeNotNull(this) { status ->
            binding.progressBar.visibility = View.INVISIBLE
            when (status) {
                is LoginStatus.Success -> startActivity(ResumeActivity::class)
                is LoginStatus.Failed -> onAccessDenied(status.count)
                is LoginStatus.NotValidated -> showSimpleErrorBalloon(R.string.login_error_user_is_not_verified)
                is LoginStatus.DeletedUser -> onDeletedUser(status.email)
                is LoginStatus.Unavailable -> doOnTooManyInvalidAttempts()
            }
        }
    }

    private fun onAccessDenied(count: Int) {
        when (count) {
            1, 2 -> showInvalidLoginMessage(count)
            else -> doOnTooManyInvalidAttempts()
        }
    }

    private fun showInvalidLoginMessage(count: Int) {
        ErrorMessageCreator.init(binding.bottomPlaceholder)
            .createSimpleMessage(getString(R.string.login_error_invalid_credentials, 3 - count))
    }

    private fun onDeletedUser(email: String) {
        binding.loginProgressBar.visibility = View.GONE
        binding.loginLayout.visibility = View.VISIBLE
        binding.editTextEmail.text = SpannableStringBuilder(email)
        setRegisterListener()
        showSimpleErrorBalloon(R.string.login_error_user_is_deleted)
    }

    private fun doOnTooManyInvalidAttempts() {
        showApplicationQuitsMessage()
        startDelayedRemovalOfApplication()
    }

    private fun showApplicationQuitsMessage() {
        ErrorMessageCreator.init(binding.bottomPlaceholder)
            .createSimpleMessage(getString(R.string.login_error_application_closing))
    }

    private fun setRegisterListener() {
        binding.registerText.setOnClickListener { startActivity(RegisterActivity::class) }
    }
}