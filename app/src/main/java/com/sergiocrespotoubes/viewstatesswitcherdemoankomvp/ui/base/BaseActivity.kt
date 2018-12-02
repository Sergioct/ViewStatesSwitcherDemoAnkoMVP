package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    //abstract val layoutId: Int
    abstract val presenter: BaseContract.Presenter
    //abstract val toolbarView: Toolbar
    //abstract val activityModules: Kodein.Module

    override fun onCreate(savedInstanceState: Bundle?) {
        //ItilApplication.instance.addModule(activityModules)
        super.onCreate(savedInstanceState)

        //setSupportActionBar(toolbarView)
        //preparePresenter(intent)
    }

    open fun preparePresenter(intent: Intent?) {}

    override fun finish() {
        finish()
    }

}