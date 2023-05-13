package com.enimal.app.ui.auth.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enimal.app.R
import com.enimal.app.data.model.CarouselIntro
import com.enimal.app.data.network.ApiEndPoint
import com.enimal.app.data.repositories.AuthRepository
import com.enimal.app.databinding.FragmentIntroBinding
import com.enimal.app.databinding.FragmentLoginBinding
import com.enimal.app.ui.auth.AuthActivity
import com.enimal.app.ui.auth.AuthViewModel
import com.enimal.app.ui.auth.intro.adapter.IntroAdapter
import com.enimal.app.ui.base.BaseFragment
import io.github.vejei.viewpagerindicator.indicator.CircleIndicator

class IntroFragment : BaseFragment<AuthViewModel, FragmentIntroBinding, AuthRepository>() {

    private lateinit var activity : AuthActivity
    private lateinit var carouselAdapter: IntroAdapter

    override fun setUp() {
        activity = requireActivity() as AuthActivity

        initAdapter()
    }

    private fun initAdapter() {
        val listCarousel = ArrayList<CarouselIntro>()
        listCarousel.add(CarouselIntro(R.drawable.art_intro, "Another Happy Customer with Enimal", "Easy to use application and complete feature only for your pet shop"))
        listCarousel.add(CarouselIntro(R.drawable.art_intro, "Another Happy Customer with Enimal 2", "Easy to use application and complete feature only for your pet shop 2"))
        listCarousel.add(CarouselIntro(R.drawable.art_intro, "Another Happy Customer with Enimal 3", "Easy to use application and complete feature only for your pet shop 3"))
        carouselAdapter = IntroAdapter(requireContext(), listCarousel)

        with(binding){
            carouselIntro.apply {
                adapter = carouselAdapter
            }
            indicator.apply {
                setWithViewPager2(binding.carouselIntro.viewPager2, false)
                setAnimationMode(CircleIndicator.AnimationMode.SLIDE)
                itemCount = listCarousel.size
            }
            btnStarted.setOnClickListener {
                activity.openLogin()
            }
        }
    }

    override fun getViewModel() = AuthViewModel::class.java
    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentIntroBinding.inflate(inflater, container, false)
    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(requireContext(), ApiEndPoint::class.java))

    companion object {

        const val TAG: String = "IntroFragment"
        @JvmStatic
        fun newInstance() =
            IntroFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}