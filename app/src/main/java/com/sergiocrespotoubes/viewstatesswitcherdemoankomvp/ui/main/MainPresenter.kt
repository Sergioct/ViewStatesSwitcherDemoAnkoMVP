package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

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
    }

    override fun loadError() {
        mView.showLoading()
    }

    override fun loadEmpty() {
        mView.showLoading()
    }

}