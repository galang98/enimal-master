package com.enimal.app.ui.auth.intro.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.enimal.app.data.model.CarouselIntro
import com.enimal.app.databinding.ListIntroCarouselBinding
import com.enimal.app.ui.base.BaseViewHolder
import io.github.vejei.carouselview.CarouselAdapter

class IntroAdapter(
    val context: Context,
    var list: List<CarouselIntro>
    ) : CarouselAdapter<IntroAdapter.ViewHolder>() {

    override fun onCreatePageViewHolder(parent: ViewGroup, viewType: Int): IntroAdapter.ViewHolder {
        val binding = ListIntroCarouselBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindPageViewHolder(holder: IntroAdapter.ViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getPageCount(): Int {
        return list.size
    }

    inner class ViewHolder(
        private val binding : ListIntroCarouselBinding
    ) : BaseViewHolder(binding.root) {

        lateinit var data: CarouselIntro

        override fun onBind(position: Int) {
            super.onBind(position)
            data = list[position]

            with(binding){
                img.setImageResource(data.resource!!)
                title.text = data.title
                content.text = data.content
            }
        }

        override fun clear() {

        }

    }
}