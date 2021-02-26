package com.example.jiangweihao.sport.coding.utils


import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.support.annotation.RequiresApi
import com.alibaba.fastjson.JSON

import java.util.*


object SPUtils {

    private const val SP_NAME = "sp58che"
    val HAS_COME_APP = "has_come_app"

    val launch_pictrue = "launch_pictrue"//开屏广告


    private var instance: SharedPreferences? = null

    /** 使用前请先初始化 */
    fun init(context: Context) {
        if (instance != null) return
        instance = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun clearAll() {
        checkInstance()
        instance!!.edit().clear().apply()
    }

    private fun checkInstance() {
        if (instance == null) throw InstantiationException("not init SharedPreferences ")
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun putString(key: String, value: String) {
        checkInstance()
        instance!!.edit().putString(key, value).apply()
    }


    fun getString(key: String): String {
        checkInstance()
        return instance!!.getString(key, "")
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun putBoolean(key: String, value: Boolean) {
        checkInstance()
        instance!!.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return instance!!.getBoolean(key, false)
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun putLong(key: String, value: Long) {
        checkInstance()
        instance!!.edit().putLong(key, value).apply()
    }

    fun getLong(key: String): Long {
        checkInstance()
        return instance!!.getLong(key, 0L)
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun putInt(key: String, value: Int) {
        checkInstance()
        instance!!.edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        checkInstance()
        return instance!!.getInt(key, 0)
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun putFloat(key: String, value: Float) {
        checkInstance()
        instance!!.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String): Float {
        checkInstance()
        return instance!!.getFloat(key, 0f)
    }

    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    fun putStringSet(key: String, setValue: Set<String>) {
        checkInstance()
        instance!!.edit().putStringSet(key, setValue).apply()
    }

    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    fun getStringSet(key: String): Set<String> {
        checkInstance()
        return instance!!.getStringSet(key, null)
    }



    fun getLaunchPictrue(): ArrayList<String> {
        val json = getString(launch_pictrue)
        var recentList: List<String> = ArrayList()
        val recentListArray = ArrayList<String>()
        if (json != null) {
            recentList = JSON.parseArray(json, String::class.java)
        }
        Collections.reverse(recentList)
        recentListArray.addAll(recentList)
        return recentListArray
    }

}
