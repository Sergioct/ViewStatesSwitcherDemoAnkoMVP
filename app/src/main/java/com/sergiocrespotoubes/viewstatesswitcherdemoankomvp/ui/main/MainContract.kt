package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main

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
        fun showData()
    }

    interface Presenter : BaseContract.Presenter {
        fun loadData()
        fun loadError()
        fun loadEmpty()
    }

    interface Model : BaseContract.Model{

    }

}