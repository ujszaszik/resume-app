package hu.ujszaszik.resumeapp.register

sealed class RegisterStatus {

    class SuccessfulRegistration(val data: UserData) : RegisterStatus()

    object FailedRegistration : RegisterStatus()

    object AlreadyRegistered : RegisterStatus()

    class VerificationSent(val email: String?) : RegisterStatus()

    object VerificationSendFailed : RegisterStatus()

    object LoggedInWithRegisteredUser : RegisterStatus()

    object LoginWithRegisteredUserFailed : RegisterStatus()
}