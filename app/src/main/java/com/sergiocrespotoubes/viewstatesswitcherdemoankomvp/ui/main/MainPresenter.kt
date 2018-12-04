package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

import arrow.core.Either
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.repository.PostsRepository
import kotlinx.coroutines.*

class MainPresenter(private val mView: MainContract.View,
                    val postsRepository: PostsRepository) : MainContract.Presenter  {

    val uiDispatcher: CoroutineDispatcher = Dispatchers.Main

    override fun dropView() {

    }

    override fun loadData() {
        mView.showLoading()
        /*GlobalScope.launch(uiDispatcher) {
            val posts = async { postsRepository.getPosts() }.await()

            when(posts){
                is Either.Left -> handleError()
                is Either.Right -> {
                    val posts = posts.b
                    val postItems = posts.map { PostItem(it) }
                    handleSuccess(postItems)
                }
            }
        }*/
    }

    override fun loadError() {
        mView.showLoading()
        GlobalScope.launch(uiDispatcher) {
            delay(2000)
            handleError()
        }
    }

    override fun loadEmpty() {
        mView.showLoading()
        GlobalScope.launch(uiDispatcher) {
            delay(2000)
            handleSuccess(listOf())
        }
    }


    private fun handleError(){
        mView.showError()
    }

    private fun handleSuccess(posts: List<PostItem>){
        if(posts.isNotEmpty()){
            mView.showData(posts)
        }else{
            mView.showEmpty()
        }
    }

}