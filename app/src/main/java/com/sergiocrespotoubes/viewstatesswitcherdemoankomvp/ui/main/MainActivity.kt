package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

import android.os.Bundle
import com.jakewharton.rxbinding3.view.clicks
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.R
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.base.BaseActivity
import com.sergiocrespotoubes.viewstatesswitcherlib.ViewStatesSwitcher2
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity(), MainContract.View {

    override val presenter : MainContract.Presenter by inject { parametersOf(this) }

    lateinit var adapter: GroupAdapter<ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadViews()
        presenter.loadData()
    }

    private fun loadViews() {

        viewStatesSwitcher.setStatus(ViewStatesSwitcher2.Status.LOADING)
        adapter = GroupAdapter()
        dataRecyclerView.adapter = adapter

        normalButton.clicks().subscribe{ presenter.loadData() }
        errorButton.clicks().subscribe{ presenter.loadError() }
        emptyButton.clicks().subscribe{ presenter.loadEmpty() }
    }

    override fun showError() {
        viewStatesSwitcher.setStatus(ViewStatesSwitcher2.Status.ERROR)
    }

    override fun showLoading() {
        viewStatesSwitcher.setStatus(ViewStatesSwitcher2.Status.LOADING)
    }

    override fun showEmpty() {
        viewStatesSwitcher.setStatus(ViewStatesSwitcher2.Status.EMPTY)
    }

    override fun showData(posts: List<PostItem>) {
        viewStatesSwitcher.setStatus(ViewStatesSwitcher2.Status.NORMAL)
        adapter.apply {
            add(Section(posts))
        }
    }

}
