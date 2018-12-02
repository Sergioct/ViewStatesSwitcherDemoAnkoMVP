package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.datasource

import arrow.core.Either
import arrow.core.Failure
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.PostsApi
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.dto.PostsResponseDto

class PostsService(private val itemsApi: PostsApi) {

    suspend fun getPosts(): Either<Failure, List<PostsResponseDto>> = Either.Right(itemsApi.getPosts().await())
}