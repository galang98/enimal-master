package com.enimal.app.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.enimal.app.data.network.RemoteDataSource
import com.enimal.app.data.repositories.BaseRepository
import com.enimal.app.util.Helper.showToastLong
import com.enimal.app.util.Helper.showToastShort
import com.techiness.progressdialoglibrary.ProgressDialog

abstract class BaseFragment<VM : ViewModel, B : ViewBinding, R: BaseRepository> : Fragment(){

    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected val remoteDataSource = RemoteDataSource()
    lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater,container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory)[getViewModel()]
        progressDialog = ProgressDialog(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    fun showMessageShort(message: String) {
        showToastShort(requireContext(), message)
    }

    fun showMessageLong(message: String) {
        showToastLong(requireContext(), message)
    }

    fun showLoader(){
        progressDialog.show()
    }
    fun hideLoader(){
        progressDialog.dismiss()
    }

    abstract fun getViewModel() : Class<VM>
    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) : B
    abstract fun getFragmentRepository() : R
    abstract fun setUp()
}