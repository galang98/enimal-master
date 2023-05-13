package com.enimal.app.ui.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.enimal.app.databinding.ActivityLoginBinding
import com.enimal.app.databinding.ActivitySplashScreenBinding
import com.enimal.app.ui.auth.AuthActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(1000)
            startActivity(AuthActivity.getStartIntent(this@SplashScreenActivity))
        }
    }

}