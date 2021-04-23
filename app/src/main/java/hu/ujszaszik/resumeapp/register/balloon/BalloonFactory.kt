package hu.ujszaszik.resumeapp.register.balloon

import android.content.Context
import androidx.core.content.ContextCompat
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.createBalloon
import com.ujszaszik.resumeapp.R

class BalloonFactory(private val context: Context) {

    fun create(message: String, type: BalloonType): Balloon {
        return createBalloon(context) {
            setArrowSizeResource(R.dimen.balloon_arrow_size)
            setBackgroundColorResource(type.colorId)
            setBalloonAnimation(com.skydoves.balloon.BalloonAnimation.ELASTIC)
            setCornerRadiusResource(R.dimen.balloon_corner_radius)
            setHeightResource(R.dimen.balloon_height)
            setIconDrawable(ContextCompat.getDrawable(context, R.drawable.ic_clear))
            setIconGravity(com.skydoves.balloon.IconGravity.END)
            setLifecycleOwner(lifecycleOwner)
            setPaddingRightResource(R.dimen.balloon_padding_right)
            setWidthResource(R.dimen.balloon_width)
            setText(message)
            setTextColorResource(R.color.white)
            setTextIsHtml(true)
            setTextSizeResource(R.dimen.balloon_text_size)
        }
    }

}