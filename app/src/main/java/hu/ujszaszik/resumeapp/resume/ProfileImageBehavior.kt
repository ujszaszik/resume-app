package hu.ujszaszik.resumeapp.resume

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.ujszaszik.resumeapp.R
import de.hdodenhof.circleimageview.CircleImageView
import hu.ujszaszik.resumeapp.extensions.*


class ProfileImageBehavior constructor(
    private val context: Context,
    attrs: AttributeSet?
) : CoordinatorLayout.Behavior<CircleImageView>(context, attrs) {

    private var positionXStart = 0
    private var positionXStartCustom = 0f
    private var positionXEnd = 0

    private var positionYStart = 0
    private var positionYEnd = 0
    private var positionYEndCustom = 0f

    private var startHeightCustom = 0f
    private var startHeight = 0
    private var endHeightCustom = 0f

    private var positionToolbarStart = 0f
    private var positionToolbarStartCustom = 0f

    private var profileImageMaxSize = 0f
    private var profileImageEndLeftPadding = 0f
    private var changeBehaviorPoint = 0f

    private var expandedPercentageFactor: Float = 0f

    init {
        initAttributes()
        attrs?.let { initCustomAttributes(it) }
    }

    private fun initAttributes() {
        profileImageMaxSize = context.resources.getDimension(R.dimen.profile_image_width)
        profileImageEndLeftPadding = context.resources.getDimension(R.dimen.padding_extended)
    }

    private fun initCustomAttributes(attrs: AttributeSet) {
        val array = context.obtainStyledAttributes(
            attrs,
            R.styleable.AvatarImageBehavior
        )
        positionYEndCustom = array.getDimen(R.styleable.AvatarImageBehavior_finalYPosition)
        positionXStartCustom = array.getDimen(R.styleable.AvatarImageBehavior_startXPosition)
        positionToolbarStartCustom =
            array.getDimen(R.styleable.AvatarImageBehavior_startToolbarPosition)
        startHeightCustom = array.getDimen(R.styleable.AvatarImageBehavior_startHeight)
        endHeightCustom = array.getDimen(R.styleable.AvatarImageBehavior_finalHeight)
        array.recycle()
    }

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: CircleImageView,
        dependency: View
    ): Boolean = dependency is Toolbar

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: CircleImageView,
        dependency: View
    ): Boolean {

        calculateUnsetProperties(child, dependency)
        val maxScrollDistance = positionToolbarStart.toInt()
        expandedPercentageFactor = dependency.y / maxScrollDistance
        setVisibilityBasedOnExpandedPercentage(parent)
        if (isOverChangeBehaviorPoint()) doImageCornerMove(child)
        else doImageVerticalMove(child)
        return true
    }

    private fun isOverChangeBehaviorPoint(): Boolean {
        return expandedPercentageFactor < changeBehaviorPoint
    }

    private fun doImageCornerMove(child: CircleImageView) {
        val heightFactor =
            (changeBehaviorPoint - expandedPercentageFactor) / changeBehaviorPoint
        val distanceXToSubtract =
            ((positionXStart - positionXEnd) * heightFactor) + child.height / 2
        val distanceYToSubtract =
            ((positionYStart - positionYEnd) * (1f - expandedPercentageFactor)) + child.height / 2

        child.x = positionXStart - distanceXToSubtract
        child.y = positionYStart - distanceYToSubtract
        val heightToSubtract = (startHeight - endHeightCustom) * heightFactor

        val layoutParams = child.coordinatorLayoutParams()
        layoutParams.width = (startHeight - heightToSubtract).toInt()
        layoutParams.height = (startHeight - heightToSubtract).toInt()
        child.layoutParams = layoutParams
    }

    private fun doImageVerticalMove(child: CircleImageView) {
        val distanceYToSubtract =
            ((positionYStart - positionYEnd) * (1f - expandedPercentageFactor)) + startHeight / 2

        child.x = positionXStart - child.width / 2.toFloat()
        child.y = positionYStart - distanceYToSubtract

        val layoutParams = child.coordinatorLayoutParams()
        layoutParams.width = startHeight
        layoutParams.height = startHeight
        child.layoutParams = layoutParams
    }

    private fun calculateUnsetProperties(child: CircleImageView, dependency: View) {
        if (positionYStart == 0) positionYStart = dependency.y.toInt()
        if (positionYEnd == 0) positionYEnd = dependency.height / 2
        if (startHeight == 0) startHeight = child.height
        if (positionXStart == 0) positionXStart = (child.x + child.width / 2).toInt()
        if (positionXEnd == 0) positionXEnd =
            context.getPixelOffset(R.dimen.abc_action_bar_content_inset_material) + endHeightCustom.toInt() / 2
        if (positionToolbarStart == 0f) positionToolbarStart = dependency.y
        if (changeBehaviorPoint == 0f) {
            changeBehaviorPoint =
                (child.height - endHeightCustom) / (2f * (positionYStart - positionYEnd))
        }
    }

    private fun setVisibilityBasedOnExpandedPercentage(parent: CoordinatorLayout) {
        val textView = parent.findTextViewById(R.id.resumeHeaderToolbarText)
        val nameTextView = parent.findTextViewById(R.id.resumeHeaderNameText)
        val jobDescriptionTextView = parent.findTextViewById(R.id.resumeHeaderJobText)
        val toolbar = parent.findViewById<Toolbar>(R.id.resumeHeaderToolbar)
        val collapsingToolbar =
            parent.findViewById<AppBarLayout>(R.id.resumeHeaderAppBar)
        if (isCollapsed()) showViews(textView)
            .also { hideViews(nameTextView, jobDescriptionTextView) }
            .also { enableBgOnViews(toolbar) }
            .also { collapsingToolbar.background = ContextCompat.getDrawable(context, R.drawable.circular_progress_bar) }
        else hideViews(textView)
            .also { showViews(nameTextView, jobDescriptionTextView, collapsingToolbar) }
            .also { enableBgOnViews(collapsingToolbar) }
            .also { disableBgOnViews(toolbar) }
    }

    private fun isCollapsed(): Boolean = expandedPercentageFactor.toDouble() == 0.0

}