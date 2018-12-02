package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

import arrow.core.Either
import arrow.core.Failure
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.dto.PostsResponseDto
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.base.BaseContract

/**
 * Created by Sergio Crespo Toubes on 08/04/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
interface MainContract {

    interface View : BaseContract.View{
        fun showError()
        fun showLoading()
        fun showEmpty()
        fun showData(posts: List<PostItem>)
    }

    interface Presenter : BaseContract.Presenter {
        fun loadData()
        fun loadError()
        fun loadEmpty()
    }

    interface Model : BaseContract.Model{
        suspend fun getPosts(): Either<Failure, List<PostsResponseDto>>
    }

}