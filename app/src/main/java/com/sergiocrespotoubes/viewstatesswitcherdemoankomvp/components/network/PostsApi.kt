package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network

import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.dto.PostsResponseDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PostsApi {

    @GET("/posts")
    fun getPosts(): Deferred<List<PostsResponseDto>>

}

