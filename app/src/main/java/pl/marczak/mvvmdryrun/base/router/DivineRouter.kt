package pl.marczak.mvvmdryrun.base.router

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import javax.inject.Inject

class DivineRouter @Inject constructor(val activity: FragmentActivity) {


    fun fromActivity(): DivineRouterContext = DivineRouterContext(activity = activity)

    fun fromFragment(tag: String? = null): DivineRouterFragmentContext {

        val fragment = findFragment(tag)

        return DivineRouterFragmentContext(fragment)
    }

    private fun findTopFragment(fragmentManager: FragmentManager): Fragment {
        val backEntry = fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 1)
        val str = backEntry.name
        return fragmentManager.findFragmentByTag(str)
    }

    private fun findFragment(tag: String? = null): Fragment {
        val fragmentManager = activity.supportFragmentManager
        return if (tag == null) {
            findTopFragment(fragmentManager)
        } else {
            return fragmentManager.findFragmentByTag(tag)
        }

    }


    class DivineRouterContext(activity: FragmentActivity) {

        fun routeTo() {

        }
    }

    class DivineRouterFragmentContext(val fragment: Fragment) {


        fun routeToLandingPage() {

        }
    }


}