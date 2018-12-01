package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import com.jakewharton.rxbinding3.view.clicks
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.R
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.base.BaseActivity
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainContract
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainPresenter
import com.sergiocrespotoubes.viewstatesswitcherlib.ViewStatesSwitcher2
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.setContentView
import org.koin.android.ext.android.inject
import org.koin.dsl.module.module

class MainActivity : BaseActivity(), MainContract.View {

    override val presenter : MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadViews()
    }

    override fun finish() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun loadViews() {
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

    override fun showData() {
        viewStatesSwitcher.setStatus(ViewStatesSwitcher2.Status.NORMAL)
    }

}
