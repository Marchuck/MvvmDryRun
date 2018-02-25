package pl.marczak.mvvmdryrun.login

import android.content.Context
import android.databinding.Bindable
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import pl.marczak.mvvmdryrun.BR
import pl.marczak.mvvmdryrun.R
import pl.marczak.mvvmdryrun.base.NavigationService
import pl.marczak.mvvmdryrun.base.ValidationContext
import pl.marczak.mvvmdryrun.base.ViewModel
import pl.marczak.mvvmdryrun.databinding.FragmentLoginWithEmailBinding

class LoginViewModel(val navigationService: NavigationService, val context: Context)
    : ViewModel<FragmentLoginWithEmailBinding>() {
    private val validation = ValidationContext()
    private var email: String? = null
    private var password: String? = null
    private var rememberPassword: Boolean = false
    private var rootView: View? = null

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup): FragmentLoginWithEmailBinding {
        val binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_with_email, container, false) as FragmentLoginWithEmailBinding
        binding.vm = LoginViewModel@ this
        rootView = binding.root
        return binding
    }

    @Bindable
    fun getEmail() = email

    fun setEmail(email: String?) {
        this.email = email
        notifyPropertyChanged(BR.email)
    }

    @Bindable
    fun isRememberPassword() = rememberPassword

    fun setRememberPassword(rememberPassword: Boolean) {
        this.rememberPassword = rememberPassword
        notifyPropertyChanged(BR.rememberPassword)
    }


    @Bindable
    fun getPassword() = password

    fun setPassword(password: String?) {
        this.password = password
        notifyPropertyChanged(BR.password)
    }

    @Bindable
    fun getValidation() = validation

    public fun signInWithEmail() {
        context.showToast("SIGN IN: [ $email / $password ]")
    }
}

private fun Context.showToast(s: String) {
    Toast.makeText(this, s, Toast.LENGTH_LONG).show()
}
