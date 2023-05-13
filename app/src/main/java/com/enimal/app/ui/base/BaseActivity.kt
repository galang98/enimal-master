package com.enimal.app.ui.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.enimal.app.data.network.RemoteDataSource
import com.enimal.app.data.network.Resource
import com.enimal.app.data.repositories.BaseRepository
import com.enimal.app.util.Helper
import com.techiness.progressdialoglibrary.ProgressDialog

abstract class BaseActivity<VM : ViewModel, B : ViewBinding, R: BaseRepository> : AppCompatActivity() {

    lateinit var binding: B
    protected lateinit var viewModel: VM
    lateinit var progressDialog: ProgressDialog
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getActivityBinding()
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        val factory = ViewModelFactory(getActivityRepository())
        viewModel = ViewModelProvider(this, factory)[getViewModel()]

        setUp()
    }

    fun showLoader(){
        progressDialog.show()
    }
    fun hideLoader(){
        progressDialog.dismiss()
    }

    fun showMessageShort(message: String) {
        Helper.showToastShort(this, message)
    }

    fun showMessageLong(message: String) {
        Helper.showToastLong(this, message)
    }

    abstract fun getViewModel() : Class<VM>
    abstract fun getActivityBinding() : B
    abstract fun getActivityRepository() : R
    abstract fun setUp()
}