package com.example.jiangweihao.sport.coding.fragment


import android.view.View
import android.widget.Button
import com.example.jiangweihao.sport.R


class SellCarFragment : BaseFragment(), View.OnClickListener {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_sell_car
    }

    override fun onClick(v: View?) {
    }

    private var mrun: Int = 60
    private var hasChacked: Boolean = true

    private lateinit var bn_send_verify: Button


}
