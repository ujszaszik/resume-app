package hu.ujszaszik.resumeapp.general.phone

import android.app.Activity
import android.content.Intent
import android.net.Uri
import hu.ujszaszik.resumeapp.general.ContactAction

class PhoneCallAction : ContactAction {

    override fun execute(activity: Activity, parameter: String) {
        Intent(Intent.ACTION_DIAL).run {
            data = Uri.parse("tel:$parameter")
            activity.startActivity(this)
        }
    }
}