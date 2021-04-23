package hu.ujszaszik.resumeapp.register.balloon

import android.os.CountDownTimer
import com.skydoves.balloon.Balloon

class BalloonTimer {

    companion object {

        private const val ONE_SECOND = 1000L

        fun init(balloon: Balloon, time: Long): CountDownTimer {
            return object : CountDownTimer(time, ONE_SECOND) {
                override fun onTick(p0: Long) {}

                override fun onFinish() = balloon.dismiss()
            }
        }
    }
}