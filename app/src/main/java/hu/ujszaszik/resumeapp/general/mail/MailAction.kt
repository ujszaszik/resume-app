package hu.ujszaszik.resumeapp.general.mail

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.general.ContactAction


class MailAction : ContactAction {

    override fun execute(activity: Activity, parameter: String) {
        Intent(Intent.ACTION_SENDTO).run {
            data = Uri.parse("mailto:$parameter")
            putExtra(Intent.EXTRA_SUBJECT, activity.getString(R.string.contact_mail_subject))
            putExtra(Intent.EXTRA_TEXT, activity.getString(R.string.contact_mail_greeting))
            activity.startActivity(this)
        }
    }
}