package pl.marczak.mvvmdryrun.main

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pl.marczak.mvvmdryrun.R
import pl.marczak.mvvmdryrun.base.NavigationService
import pl.marczak.mvvmdryrun.login.LoginViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasActivityInjector {

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_home -> {
//                message.setText(R.string.title_home)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_dashboard -> {
//                message.setText(R.string.title_dashboard)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_notifications -> {
//                message.setText(R.string.title_notifications)
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

    @Inject
    lateinit var navigationService: NavigationService

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack)


        val loginScreen = LoginViewModel(navigationService!!, this)
        navigationService .showViewModel(loginScreen, null)

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finishAffinity()
            return
        }

        if (supportFragmentManager.backStackEntryCount > 1) {
            if (navigationService?.goingBack()!!) {
                supportFragmentManager.popBackStack()
            }
        } else {
            super.onBackPressed()
        }
    }
}
