package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.R
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.dto.PostsResponseDto
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_post.*

class PostItem(val post: PostsResponseDto) : Item (){

    override fun getLayout() = R.layout.item_post

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.userId.text = post.title
        viewHolder.title.text = post.body
        //viewHolder.completed.artist = post.body
    }

}