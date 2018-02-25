package pl.marczak.mvvmdryrun.base

import android.os.Bundle
import pl.marczak.mvvmdryrun.R
import pl.marczak.mvvmdryrun.di.PerActivity

@PerActivity
open class NavigationService(var fragmentManager: android.support.v4.app.FragmentManager) {

    internal var _overlayClass: Class<*>? = null

    fun showViewModel(containerId: Int, model: ViewModel<*>, params: Bundle?) {

        val transaction = fragmentManager.beginTransaction()

        val tag = model.javaClass.name

        val fragment = model.createFragment(params)
        transaction.replace(containerId, fragment)
        transaction.addToBackStack(tag)
        transaction.commit()
    }

    fun goingBack(): Boolean {
        val topFragment = findTopFragment()
        return topFragment == null || topFragment.goingBack()
    }

    private fun findTopFragment(): BoundFragment? {
        val backEntry = fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 1)
        val str = backEntry.name
        return fragmentManager.findFragmentByTag(str) as BoundFragment
    }

    fun showViewModel(model: ViewModel<*>, param: Bundle?) {
        showViewModel(containerId = R.id.fragments_container, model = model, params = param)
    }

    fun goBack() {
        _overlayClass = null
        fragmentManager.popBackStack()
    }

    fun goBackTo(modelClass: Class<*>) {
        fragmentManager.popBackStack(modelClass.name, 0)
    }

    fun clearOverlay() {
        _overlayClass = null
        val overlayFragment = fragmentManager.findFragmentById(R.id.overlays_container)
        if (overlayFragment != null) {
            fragmentManager.popBackStack()
        }
    }
}