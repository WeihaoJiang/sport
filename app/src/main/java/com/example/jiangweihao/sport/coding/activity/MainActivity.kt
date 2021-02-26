package com.example.jiangweihao.sport.coding.activity

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.widget.Toast
import com.example.jiangweihao.sport.R
import com.example.jiangweihao.sport.coding.fragment.*

import com.example.jiangweihao.sport.coding.view.ViewPagerSlide
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/**
 * app主页
 */
class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {


    var mListTitle = ArrayList<String>()
    var mListIcon = ArrayList<Int>()
    var mListSelectIcon = ArrayList<Int>()
    private lateinit var status: String
    private lateinit var main_viewpager: ViewPagerSlide
    lateinit var mPagerAdapter: MyFragmentPagerAdapter

    private val fgs = mutableListOf<Fragment>(

            FindCheFragment(),
            HomeFragment(),
            AboutMeFragment()
    )
    private val fgsm = mutableListOf<Fragment>(
            HomeFragment(),//首页
            XiaoXiFragment(),
//            PublishFragment(),//消息
            AboutMeFragment()//我的

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        status = intent.getStringExtra("status")
        status = "niufeitingting@126.com"
//        if (status.indexOf("@") == -1) {
//            mPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager, fgs,status)
//
//        } else {
//            mPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager, fgsm,status)
//
//        }
        mPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager, fgsm,status)
        init()
        main_viewpager.adapter = mPagerAdapter
        main_tab.setupWithViewPager(main_viewpager)
        for (i in 0 until main_tab.tabCount) {
            main_tab.getTabAt(i)!!.setIcon(mListIcon.get(i))
            main_tab.getTabAt(i)!!.setText(mListTitle.get(i))
        }
        main_tab.getTabAt(0)!!.setIcon(mListSelectIcon.get(0))
        //设置标签选中页面时标签字体颜色
//        main_tab.setTabTextColors(Color.GRAY, Color.parseColor("#DBAC62"))
        main_tab.setOnTabSelectedListener(this)
        main_viewpager.offscreenPageLimit = 4


    }


    private fun init() {
        main_viewpager = findViewById(R.id.main_viewpager)

        mListTitle.add("首页")
        mListTitle.add("消息")
        mListTitle.add("关于")

        mListIcon.add(R.drawable.ic_find_black)
        mListIcon.add(R.drawable.ic_look_black)
        mListIcon.add(R.drawable.ic_about_black)

        mListSelectIcon.add(R.drawable.ic_find_yellow)
        mListSelectIcon.add(R.drawable.ic_look_yellow)
        mListSelectIcon.add(R.drawable.ic_about_yellow)
    }


    override fun onTabReselected(tab: TabLayout.Tab) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab) {
        //未选中时
        main_tab.getTabAt(tab.position)!!.setIcon(mListIcon.get(tab.position))
    }

    override fun onTabSelected(tab: TabLayout.Tab) {
        //选中时
        main_tab.getTabAt(tab.position)?.setIcon(mListSelectIcon.get(tab.position))
        //设置标签选中页面时标签字体颜色
//        main_tab.setTabTextColors(Color.GRAY, Color.parseColor("#DBAC62"))
        main_viewpager.currentItem = tab.position
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click()
        }
        return false
    }

    /**
     * 双击退出函数
     */
    private var isExit: Boolean? = false

    private fun exitBy2Click() {
        val index = main_tab.selectedTabPosition

        var tExit: Timer? = null
        if (isExit == false) {
            isExit = true // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show()
            tExit = Timer()
            tExit.schedule(object : TimerTask() {
                override fun run() {
                    isExit = false // 取消退出
                }

            }, 3000) // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            finish()
            System.exit(0)
        }
    }


    class MyFragmentPagerAdapter(val fm: FragmentManager, val list: MutableList<Fragment>, val string: String) : android.support.v4.app.FragmentPagerAdapter(fm) {


        override fun getCount(): Int {
            return list.size
        }


        override fun getItem(position: Int): Fragment {

            val fragment = list[position]
            val bundle = Bundle()
            bundle.putInt("index", position)
            bundle.putString("status",string)
            fragment.arguments = bundle
            return fragment

        }

    }

}
