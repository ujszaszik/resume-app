package hu.ujszaszik.resumeapp.general

import android.content.Context
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.general.browser.BrowserAction
import hu.ujszaszik.resumeapp.general.mail.MailAction
import hu.ujszaszik.resumeapp.general.phone.PhoneCallAction

enum class ContactActionType(val nameId: Int, val action: ContactAction) {
    PHONE_CALL(R.string.action_phone_call, PhoneCallAction()),
    SEND_EMAIL(R.string.action_send_email, MailAction()),
    OPEN_GITHUB(R.string.action_github_open, BrowserAction()),
    OPEN_LINKED_IN(R.string.action_linked_in_open, BrowserAction());

    companion object {

        fun getByName(context: Context, name: String): ContactAction {
            return values().first { context.getString(it.nameId) == name }.action
        }

    }
}