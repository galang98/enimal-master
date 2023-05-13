package com.enimal.app.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enimal.app.data.repositories.AuthRepository
import com.enimal.app.data.repositories.BaseRepository
import com.enimal.app.data.repositories.MainRepository
import com.enimal.app.ui.auth.AuthViewModel
import com.enimal.app.ui.main.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory (
    private val repository : BaseRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository as MainRepository) as T
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("View Model Classnot found")
        }
    }

}