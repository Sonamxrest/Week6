package com.xrest.weeksoft

import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.xrest.week6.Class.add
import com.xrest.weeksoft.ui.dashboard.DashboardFragment
import com.xrest.weeksoft.ui.home.HomeFragment
import com.xrest.weeksoft.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val home =HomeFragment()
        val notification =NotificationsFragment()
        val dash =DashboardFragment()
add()
makeCurrentFrag(home)
navView.setOnNavigationItemSelectedListener(){

    when(it.itemId)
    {
        R.id.navigation_home->{
            makeCurrentFrag(home)
        }

        R.id.navigation_dashboard->{
            makeCurrentFrag(dash)
        }
        R.id.navigation_notifications->{
            makeCurrentFrag(notification)
        }


    }

true
}





    }



    fun makeCurrentFrag(frag: Fragment)
    {
        supportFragmentManager.beginTransaction().apply{

            replace(R.id.nav_host_fragment,frag)
            addToBackStack(null)
            commit()

        }

    }

}