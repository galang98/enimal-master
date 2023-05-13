package com.enimal.app.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.enimal.app.data.network.ApiEndPoint
import com.enimal.app.data.repositories.AuthRepository
import com.enimal.app.databinding.FragmentLoginBinding
import com.enimal.app.ui.auth.AuthViewModel
import com.enimal.app.ui.auth.intro.IntroFragment
import com.enimal.app.ui.base.BaseFragment

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun setUp() {

    }

    override fun getViewModel() = AuthViewModel::class.java
    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentLoginBinding.inflate(inflater, container, false)
    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(requireContext(), ApiEndPoint::class.java))

    companion object {
        const val TAG: String = "LoginFragment"
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}