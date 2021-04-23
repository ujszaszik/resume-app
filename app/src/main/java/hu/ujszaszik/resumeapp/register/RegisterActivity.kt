package hu.ujszaszik.resumeapp.register

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ujszaszik.resumeapp.R
import com.ujszaszik.resumeapp.databinding.ActivityRegisterBinding
import dagger.android.AndroidInjection
import hu.ujszaszik.resumeapp.auth.UserAuthenticator
import hu.ujszaszik.resumeapp.auth.UserRegistrator
import hu.ujszaszik.resumeapp.auth.UserVerificator
import hu.ujszaszik.resumeapp.extensions.observeNotNull
import hu.ujszaszik.resumeapp.extensions.startActivity
import hu.ujszaszik.resumeapp.extensions.startActivityWithEmailExtra
import hu.ujszaszik.resumeapp.extensions.value
import hu.ujszaszik.resumeapp.input.message.ErrorMessageCreator
import hu.ujszaszik.resumeapp.login.LoginActivity
import hu.ujszaszik.resumeapp.register.adapter.RoleAdapter
import hu.ujszaszik.resumeapp.register.adapter.RoleType
import hu.ujszaszik.resumeapp.register.mail.MailSender
import hu.ujszaszik.resumeapp.register.validator.ErrorWithMessage
import hu.ujszaszik.resumeapp.register.validator.RegistryFieldState
import hu.ujszaszik.resumeapp.register.validator.RegistryValidator
import hu.ujszaszik.resumeapp.verification.VerificationActivity
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var adapter: RoleAdapter

    @Inject
    lateinit var validator: RegistryValidator

    @Inject
    lateinit var mailSender: MailSender

    @Inject
    lateinit var viewModel: RegisterViewModel

    private val userRegistrator = UserRegistrator(
        onSuccess = { email, pwd -> viewModel.onSuccessfulRegistration(UserData(email, pwd)) },
        onAlreadyRegistered = { viewModel.onAlreadyRegistered() },
        onFail = { viewModel.onFailedRegistration() }
    )

    private val userVerificator = UserVerificator(
        onSuccess = { viewModel.onVerificationSent(it) },
        onFailed = { viewModel.onVerificationSendFailed() }
    )

    private val userAuthenticator = UserAuthenticator(
        onLogin = { _, _ -> viewModel.onLoggedInWithRegisteredUser() },
        onFailedAuthentication = { viewModel.onLoginWithRegisteredUserFailed() },
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        adapter = RoleAdapter(this).also { binding.roleSpinner.adapter = it }
        setRegisterListener()
        observeRegisterStatus()
    }

    private fun setRegisterListener() {
        binding.registerButton.setOnClickListener {
            val username = binding.editTextEmail.text?.toString() ?: ""
            val password = binding.editTextPassword.text?.toString() ?: ""
            if (areFieldsValid()) {
                binding.progressBar.visibility = View.VISIBLE
                userRegistrator.create(username, password)
            }
        }
    }

    private fun areFieldsValid(): Boolean {
        return isValidEmail() && isValidPassword()
                && isValidPasswordAgain() && arePasswordsMatched()
                && isValidRole()
    }

    private fun isValidEmail(): Boolean {
        return when (val result = validator.validateEmail(binding.editTextEmail.text.toString())) {
            is RegistryFieldState.Valid -> true
            else -> falseWithMessage(binding.editTextEmail, binding.textInputEmail, result)
        }
    }

    private fun isValidPassword(): Boolean {
        return when (val result =
            validator.validatePassword(binding.editTextPassword.text.toString())) {
            is RegistryFieldState.Valid -> true
            else -> falseWithMessage(binding.editTextPassword, binding.textInputPassword, result)
        }
    }

    private fun isValidPasswordAgain(): Boolean {
        return when (val result =
            validator.validatePassword(binding.editTextPasswordAgain.text.toString(), true)) {
            is RegistryFieldState.Valid -> true
            else -> with(binding) {
                falseWithMessage(editTextPasswordAgain, textInputPasswordAgain, result)
            }
        }
    }

    private fun arePasswordsMatched(): Boolean {
        return when (val result = validator.validatePasswordMatch(
            binding.editTextPassword.value(),
            binding.editTextPasswordAgain.value()
        )) {
            is RegistryFieldState.Valid -> true
            else -> with(binding) {
                falseWithMessage(editTextPasswordAgain, textInputPasswordAgain, result)
            }
        }
    }

    private fun isValidRole(): Boolean {
        return when (val result =
            validator.validateRole(binding.roleSpinner.selectedItemPosition)) {
            is RegistryFieldState.Valid -> true
            else -> falseSpinnerWithMessage(binding.roleSpinner, result)
        }
    }

    private fun falseSpinnerWithMessage(
        view: View,
        result: RegistryFieldState
    ): Boolean {
        return false.also {
            val errorWithMessage = result as ErrorWithMessage
            ErrorMessageCreator.initForSpinner(binding.errorTextView)
                .createMessage(view, binding.registerLayout, errorWithMessage.messageId)
        }
    }

    private fun falseWithMessage(
        view: View,
        layout: View,
        result: RegistryFieldState
    ): Boolean {
        return false.also {
            val errorMessage = result as ErrorWithMessage
            ErrorMessageCreator.init(binding.errorTextView)
                .createMessage(view, layout, errorMessage.messageId)
        }
    }

    private fun observeRegisterStatus() {
        viewModel.registerStatus.observeNotNull(this) { status ->
            binding.progressBar.visibility = View.INVISIBLE
            when (status) {
                is RegisterStatus.SuccessfulRegistration -> doOnSuccessfulRegistration(status.data)
                is RegisterStatus.FailedRegistration -> showSimpleErrorMessage(R.string.login_error_failed_to_register)
                is RegisterStatus.AlreadyRegistered -> doOnAlreadyRegistered()
                is RegisterStatus.VerificationSent -> startActivityWithEmailExtra(VerificationActivity::class, status.email)
                is RegisterStatus.VerificationSendFailed -> showSimpleErrorMessage(R.string.verification_error_verification_failed)
                is RegisterStatus.LoggedInWithRegisteredUser -> userVerificator.verify()
                is RegisterStatus.LoginWithRegisteredUserFailed -> showSimpleErrorMessage(R.string.login_error_registered_login_failed)
            }
        }
    }

    private fun doOnSuccessfulRegistration(data: UserData) {
        mailSender.send(data.email, getSelectedRoleType())
        userAuthenticator.login(data)
    }

    private fun doOnAlreadyRegistered() {
        ErrorMessageCreator.init(binding.errorTextView)
            .createMessage(
                binding.editTextEmail, binding.textInputEmail, R.string.register_error_already_registered
            )
    }

    private fun showSimpleErrorMessage(resId: Int) {
        ErrorMessageCreator.init(binding.errorTextView).createSimpleMessage(resId)
    }

    private fun getSelectedRoleType(): RoleType {
        return RoleType.values()[binding.roleSpinner.selectedItemPosition]
    }

    override fun onBackPressed() {
        super.onBackPressed().also { startActivity(LoginActivity::class) }
    }

}