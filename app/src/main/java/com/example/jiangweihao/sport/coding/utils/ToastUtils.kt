package com.wuba.guchejia.kt.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast

/**
 */
object ToastUtils{

    fun showCenToast(context: Context,msg: String){
        if (context != null) {
            var toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }

    }

    fun showCenToast(context: Context,resId: Int){
        if (context != null) {
            var toast = Toast.makeText(context,context.resources.getString(resId),Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
    }

    fun showToast(context: Context,msg: String){
        var toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT)
        toast.show()
    }


    fun showCenToastLong(context: Context,msg: String){
        var toast = Toast.makeText(context,msg,Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }

}