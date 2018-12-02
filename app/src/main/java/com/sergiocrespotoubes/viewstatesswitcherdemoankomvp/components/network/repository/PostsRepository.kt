package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.repository

import arrow.core.Either
import arrow.core.Failure
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.datasource.PostsService
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.dto.PostsResponseDto

/**
 * Created by Sergio Crespo Toubes on 02/12/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
interface PostsRepository {

    suspend fun getPosts(): Either<Failure, List<PostsResponseDto>>

    class DefaultPostsRepository(private val network: PostsService) : PostsRepository {

        override suspend fun getPosts(): Either<Failure, List<PostsResponseDto>> = network.getPosts()

    }

}