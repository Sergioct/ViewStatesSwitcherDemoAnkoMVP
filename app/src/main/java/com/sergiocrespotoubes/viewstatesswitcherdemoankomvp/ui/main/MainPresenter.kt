package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

import arrow.core.Either
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.repository.PostsRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MainPresenter(private val mView: MainContract.View,
                    private val postsRepository: PostsRepository
    ) : MainContract.Presenter  {

    override fun dropView() {

    }

    override fun loadData() {
        mView.showLoading()
        GlobalScope.launch {
            val posts = async { postsRepository.getPosts() }.await()

            when(posts){
                is Either.Left -> handleError()
                is Either.Right -> {
                    val postItems = posts.b.map { PostItem(it) }

                    GlobalScope.launch {
                        handleSuccess(postItems)
                    }
                }
            }
        }
    }

    override fun loadError() {
        mView.showLoading()
        GlobalScope.launch {
            delay(2000)
            handleError()
        }
    }

    override fun loadEmpty() {
        mView.showLoading()
        GlobalScope.launch {
            delay(2000)
            handleSuccess(listOf())
        }
    }


    private fun handleError(){
        GlobalScope.launch{
            withContext(Main){
                mView.showError()
            }
        }
    }

    private fun handleSuccess(posts: List<PostItem>){
        GlobalScope.launch{
            withContext(Main){
                if(posts.isNotEmpty()){
                    mView.showData(posts)
                }else{
                    mView.showEmpty()
                }
            }
        }
    }

}