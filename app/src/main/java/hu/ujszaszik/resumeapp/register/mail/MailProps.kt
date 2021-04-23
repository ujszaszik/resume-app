package hu.ujszaszik.resumeapp.register.mail

object MailProps {

    private const val NATIVE_LIBRARY = "native-lib"

    init {
        System.loadLibrary(NATIVE_LIBRARY)
    }

    external fun hostKey(): String

    external fun hostValue(): String

    external fun socketPortKey(): String

    external fun socketPortValue(): String

    external fun socketClassKey(): String

    external fun socketClassValue(): String

    external fun authKey(): String

    external fun authValue(): String

    external fun portKey(): String

    external fun portValue(): String

    external fun mailAddress(): String

    external fun mailPassword(): String

}