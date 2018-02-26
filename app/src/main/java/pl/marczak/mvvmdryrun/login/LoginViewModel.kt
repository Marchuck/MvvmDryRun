package pl.marczak.mvvmdryrun.login

import android.content.Context
import android.databinding.Bindable
import android.databinding.DataBindingUtil
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import pl.marczak.mvvmdryrun.BR
import pl.marczak.mvvmdryrun.R
import pl.marczak.mvvmdryrun.base.NavigationService
import pl.marczak.mvvmdryrun.base.ViewModel
import pl.marczak.mvvmdryrun.base.validators.ValidationContext
import pl.marczak.mvvmdryrun.databinding.FragmentLoginWithEmailBinding
import pl.marczak.mvvmdryrun.main.MainActivity

class LoginViewModel(val navigationService: NavigationService, val context: Context)
    : ViewModel<FragmentLoginWithEmailBinding>() {

    private val validation = ValidationContext()
    private var email: String? = null
    private var password: String? = null
    private var rememberPassword: Boolean = false
    private var rootView: View? = null

    private var progressPresented: Boolean = false

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

    @Bindable
    fun getProgressPresented() = progressPresented

    fun setProgressPresented(present: Boolean) {
        this.progressPresented = present
        notifyPropertyChanged(BR.progressPresented)
    }

    fun signInWithEmail() {

        if (validation.validate()) {

            setProgressPresented(true)

            val handler = android.os.Handler(Looper.getMainLooper())
            handler.postDelayed({
                setProgressPresented(false)
                navigationService.startActivity(MainActivity::class.java, null)

            }, 1000)

        }

        //context.showToast("SIGN IN: [ $email / $password / ${validation.validate()} ]")
    }
}

private fun Context.showToast(s: String) {

    Toast.makeText(this, s, Toast.LENGTH_LONG).show()
}
