package hu.ujszaszik.resumeapp.register.mail

import android.content.Context
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.attempt
import hu.ujszaszik.resumeapp.register.adapter.RoleType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import kotlin.coroutines.CoroutineContext

class MailSender @Inject constructor(private val context: Context) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    fun send(to: String, type: RoleType) {
        launch {
            attempt {
                val props = getProps()
                val session = Session.getDefaultInstance(props, getAuthenticator())
                Transport.send(getNewUserMessage(session, to, type))
                Transport.send(getDeclarationMessage(session, to, type))
            }
        }
    }

    private fun getProps(): Properties {
        return Properties().apply {
            this[MailProps.hostKey()] = MailProps.hostValue()
            this[MailProps.socketPortKey()] = MailProps.socketPortValue()
            this[MailProps.socketClassKey()] = MailProps.socketClassValue()
            this[MailProps.authKey()] = MailProps.authValue()
            this[MailProps.portKey()] = MailProps.portValue()
        }
    }

    private fun getAuthenticator(): Authenticator {
        return object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(MailProps.mailAddress(), MailProps.mailPassword())
            }
        }
    }

    private fun getNewUserMessage(session: Session, to: String, type: RoleType): Message {
        return MimeMessage(session).apply {
            setRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
            subject = context.getString(R.string.welcome_mail_subject)
            setText(
                context.getString(R.string.welcome_mail_body, context.getString(type.textId))
            )
        }
    }

    private fun getDeclarationMessage(session: Session, to: String, type: RoleType): Message {
        return MimeMessage(session).apply {
            setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailProps.mailAddress()))
            subject = context.getString(R.string.mail_to_me_subject)
            setText(
                context.getString(
                    R.string.mail_to_me_body,
                    to,
                    context.getString(type.textId),
                    Date().toString()
                )
            )
        }
    }
}