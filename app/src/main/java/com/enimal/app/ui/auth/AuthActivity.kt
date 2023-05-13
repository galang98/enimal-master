package com.enimal.app.ui.auth

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.enimal.app.R
import com.enimal.app.data.network.ApiEndPoint
import com.enimal.app.data.repositories.AuthRepository
import com.enimal.app.databinding.ActivityAuthBinding
import com.enimal.app.ui.auth.intro.IntroFragment
import com.enimal.app.ui.auth.login.LoginFragment
import com.enimal.app.ui.auth.register.RegisterFragment
import com.enimal.app.ui.base.BaseActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthActivity : BaseActivity<AuthViewModel, ActivityAuthBinding, AuthRepository>()  {

    override fun setUp() {
        openIntro()
    }

    private fun pushFragments(tag: String, fragment: Fragment?) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        if (manager.findFragmentByTag(tag) == null) {
            ft.add(R.id.auth_container, fragment!!, tag)
        }

        val fragmentIntro = manager.findFragmentByTag(IntroFragment.TAG)
        val fragmentLogin = manager.findFragmentByTag(LoginFragment.TAG)
        val fragmentRegister = manager.findFragmentByTag(RegisterFragment.TAG)

        if (fragmentIntro != null) ft.hide(fragmentIntro)
        if (fragmentLogin != null) ft.hide(fragmentLogin)
        if (fragmentRegister != null) ft.hide(fragmentRegister)

        if (tag === IntroFragment.TAG) if (fragmentIntro != null) ft.show(fragmentIntro)
        if (tag === LoginFragment.TAG) if (fragmentLogin != null) ft.show(fragmentLogin)
        if (tag === RegisterFragment.TAG) if (fragmentRegister != null) ft.show(fragmentRegister)

        ft.commitAllowingStateLoss()
    }

    fun openIntro() {
        pushFragments(IntroFragment.TAG,IntroFragment.newInstance())
    }

    fun openLogin() {
        pushFragments(LoginFragment.TAG,LoginFragment.newInstance())
    }

    fun openRegister() {
        pushFragments(RegisterFragment.TAG,RegisterFragment.newInstance())
    }

    override fun getViewModel() = AuthViewModel::class.java
    override fun getActivityBinding() = ActivityAuthBinding.inflate(layoutInflater)
    override fun getActivityRepository() = AuthRepository(remoteDataSource.buildApi(this,
        ApiEndPoint::class.java))

    companion object {
        @JvmStatic
        fun getStartIntent(
            context: Context
        ): Intent {
            val intent = Intent(context, AuthActivity::class.java)
            return intent
        }
    }
}