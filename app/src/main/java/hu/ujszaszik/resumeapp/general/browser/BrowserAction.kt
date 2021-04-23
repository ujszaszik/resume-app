package hu.ujszaszik.resumeapp.general.browser

import android.app.Activity
import android.content.Intent
import android.net.Uri
import hu.ujszaszik.resumeapp.general.ContactAction

class BrowserAction : ContactAction {

    override fun execute(activity: Activity, parameter: String) {
        Intent(Intent.ACTION_VIEW).run {
            data = Uri.parse("https://$parameter")
            activity.startActivity(this)
        }
    }
}