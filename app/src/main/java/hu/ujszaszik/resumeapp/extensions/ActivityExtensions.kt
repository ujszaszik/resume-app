package hu.ujszaszik.resumeapp.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.inputmethod.InputMethodManager
import com.ujszaszik.resumeapp.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

fun Activity.getStringExtra(resId: Int): String? {
    return intent.getStringExtra(applicationContext.getString(resId))
}

fun Activity.startDelayedRemovalOfApplication() {
    GlobalScope.launch {
        delayOneSecond()
        finishAndRemoveTask()
        uninstallApp()
    }
}

fun Activity.uninstallApp() {
    val intent = Intent(Intent.ACTION_DELETE)
    intent.data = Uri.parse(getString(R.string.package_declaration))
    startActivity(intent)
}

fun <T : Activity> Activity.startActivity(activityClass: KClass<T>, block: (Intent) -> Unit = {}) {
    Intent(this, activityClass.java)
        .apply { block.invoke(this) }
        .run { startActivity(this) }
}

fun <T : Activity> Activity.startActivityWithEmailExtra(activityClass: KClass<T>, email: String?) {
    startActivity(activityClass) { it.putExtra(getString(R.string.intent_extra_new_email), email) }
}

fun Activity.closeKeyboard() {
    currentFocus?.let {
        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        manager?.hideSoftInputFromWindow(it.windowToken, 0)
    }
}