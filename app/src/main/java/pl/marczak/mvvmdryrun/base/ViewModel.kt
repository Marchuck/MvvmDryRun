package pl.marczak.mvvmdryrun.base

import android.databinding.BaseObservable
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class ViewModel<T : ViewDataBinding> : BaseObservable() {

    var binding: T? = null

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup): T?

    fun createFragment(bundle: Bundle?): BoundFragment {
        val fragment = BoundFragment()
        fragment.setModel(this)
        fragment.setViewParams(bundle)
        return fragment
    }

    fun setTheBinding(b: Any){
        this.binding = b as T
    }

    fun onResume() {}

    fun onPause() {}

    fun goingBack(): Boolean {
        return true
    }
}