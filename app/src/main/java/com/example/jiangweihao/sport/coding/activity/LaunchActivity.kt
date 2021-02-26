package com.example.jiangweihao.sport.coding.activity

import android.content.Intent
import android.os.CountDownTimer

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.jiangweihao.sport.R

import com.example.jiangweihao.sport.coding.utils.GlideUtils
import kotlinx.android.synthetic.main.activity_launch.*

/**
 * app开屏页
 */

class LaunchActivity : BaseActivity() {

    private lateinit var tickTv: TextView
    private lateinit var tvJump: TextView
    private lateinit var ivPicture: ImageView
    private lateinit var rlView: View
    private var count = 3

    private val timer = object : CountDownTimer(3000L, 1000L) {
        override fun onFinish() {
            goHome()
        }

        override fun onTick(millisUntilFinished: Long) {
            tickTv.text = "${(millisUntilFinished / 1000) + 1}"
//            tickTv.text = count.toString()
            //count--

        }

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_launch

    }

    override fun initView() {
        super.initView()

        val mainIntent = intent
        val action = mainIntent.action
        if (!isTaskRoot
                && mainIntent.hasCategory(Intent.CATEGORY_LAUNCHER)
                && action != null && action == Intent.ACTION_MAIN) {
            finish()
            return
        }
        timer.start()
        val view = splash_stub.inflate()
        tickTv = view.findViewById(R.id.tv_time_text) as TextView
        tvJump = view.findViewById(R.id.tv_jump) as TextView
        rlView = view.findViewById(R.id.rl_jump)
        ivPicture = view.findViewById(R.id.iv_picture) as ImageView

        rlView.setOnClickListener {
            timer.cancel()

            goHome()
        }
    }




    private fun start() {


        timer.start()

        GlideUtils.loadImage(this@LaunchActivity, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552297291152&di=c539a27494fea0b65d2dc30894ca33b9&imgtype=0&src=http%3A%2F%2Fwx3.sinaimg.cn%2Fbmiddle%2F6eb5e3b6gy1fjkf6o4b2jj20qo1bek0y.jpg", ivPicture, GlideUtils.GlideEnum.LaunchImg)

    }







private fun goHome() {
    startActivity(Intent(this, LoginActivity::class.java))
    finish()
}

override fun onDestroy() {
    super.onDestroy()

    timer.cancel()
}


}

