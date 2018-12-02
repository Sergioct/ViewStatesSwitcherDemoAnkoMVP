package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

import arrow.core.Either
import arrow.core.Failure
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.dto.PostsResponseDto
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.repository.PostsRepository

class MainModel(private val postsRepository: PostsRepository): MainContract.Model {

    override suspend fun getPosts(): Either<Failure, List<PostsResponseDto>> {
        return postsRepository.getPosts()
    }

}