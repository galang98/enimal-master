package com.enimal.app.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.enimal.app.data.network.ApiEndPoint
import com.enimal.app.data.repositories.AuthRepository
import com.enimal.app.databinding.FragmentRegisterBinding
import com.enimal.app.ui.auth.AuthViewModel
import com.enimal.app.ui.auth.login.LoginFragment
import com.enimal.app.ui.base.BaseFragment

class RegisterFragment : BaseFragment<AuthViewModel, FragmentRegisterBinding, AuthRepository>() {

    override fun setUp() {

    }

    override fun getViewModel() = AuthViewModel::class.java
    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentRegisterBinding.inflate(inflater, container, false)
    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(requireContext(), ApiEndPoint::class.java))

    companion object {
        const val TAG: String = "RegisterFragment"
        @JvmStatic
        fun newInstance() =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}