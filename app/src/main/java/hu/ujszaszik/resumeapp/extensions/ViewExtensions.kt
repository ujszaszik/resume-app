package hu.ujszaszik.resumeapp.extensions

import android.content.Context
import android.content.res.TypedArray
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.ScrollView
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.ujszaszik.resumeapp.R
import de.hdodenhof.circleimageview.CircleImageView
import hu.ujszaszik.resumeapp.resume.ResumeActivity
import hu.ujszaszik.resumeapp.resume.ResumeViewModel

fun TypedArray.getDimen(dimenId: Int): Float = getDimension(dimenId, zero().toFloat())

fun TypedArray.getInt(intId: Int): Int = getInt(intId, zero())

fun Context.getPixelOffset(id: Int): Int = resources.getDimensionPixelOffset(id)

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun showViews(vararg views: View) {
    views.forEach { it.makeVisible() }
}

fun hideViews(vararg views: View) {
    views.forEach { it.makeGone() }
}

fun View.findTextViewById(id: Int): TextView = findViewById<TextView>(id)

fun View.findImageViewById(id: Int): ImageView = findViewById<ImageView>(id)

fun View.findRatingBarById(id: Int): RatingBar = findViewById<RatingBar>(id)

fun CircleImageView.coordinatorLayoutParams() = layoutParams as CoordinatorLayout.LayoutParams

fun Fragment.resetScrollView() {
    val activity = activity as ResumeActivity
    val appBar = activity.findViewById<AppBarLayout>(R.id.resumeHeaderAppBar)
    appBar.setExpanded(true)
    val scrollView = activity.findViewById<NestedScrollView>(R.id.resumeHeaderNestedScrollView)
    scrollView.fullScroll(ScrollView.FOCUS_UP)
}

fun Fragment.getSharedViewModel(): ResumeViewModel {
    val activity = activity as ResumeActivity
    return activity.viewModel
}

fun ImageView.setImageDrawableByName(imageName: String) {
    val resources = context.resources
    val resId = resources.getIdentifier(
        imageName, "drawable",
        context.packageName
    )
    setImageDrawable(ContextCompat.getDrawable(context, resId))
}

fun RatingBar.initForValue(value: Double) {
    numStars = 5
    rating = value.toFloat()
    setIsIndicator(true)
}

fun TextView.value() = text.toString()

fun enableBgOnViews(vararg views: View) {
    views.forEach { it.background = ContextCompat.getDrawable(it.context, R.drawable.grad) }
}

fun disableBgOnViews(vararg views: View) {
    views.forEach { it.background = null }
}