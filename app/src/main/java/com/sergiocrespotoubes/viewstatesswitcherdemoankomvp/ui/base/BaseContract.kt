package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.base

interface BaseContract {

    interface View {
        fun finish()
    }

    interface Presenter {
        /**
         * Drops the reference to the view when destroyed
         */
        fun dropView()
    }

    interface Model

}