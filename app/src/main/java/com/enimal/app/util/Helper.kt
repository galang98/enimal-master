package com.enimal.app.util

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.enimal.app.R

object Helper {
    fun showToastShort(context: Context, message: String) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.view?.background?.setTintList(
            ContextCompat.getColorStateList(
                context,
                R.color.black70
            )
        )
        toast.show()
    }

    fun showToastLong(context: Context, message: String) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        toast.view?.background?.setTintList(
            ContextCompat.getColorStateList(
                context,
                R.color.black70
            )
        )
        toast.show()
    }
}