package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainPresenter(private val mView: MainContract.View) : MainContract.Presenter  {

    //private val view: MainContract.View? by weak(view)
    //
    //var incidentFilter: IncidentFilter? = null

    override fun dropView() {

    }

    //private fun onIncidentsSuccess(incidents: List<Incident>) {
    //    view?.updateRecyclerView(incidents)
    //}

    override fun loadData() {
        mView.showLoading()
        GlobalScope.launch {
            //val  = getItemsListUseCase.execute()
            //comments.either(::handleError, ::handleSuccess(comments))
            //mView?.hideProgress()
            delay(2000)
            handleError()
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

    }

    private fun handleSuccess(posts: List<PostItem>){
        if(posts.isNotEmpty()){
            mView.showData(posts)
        }else{
            mView.showEmpty()
        }
    }

}