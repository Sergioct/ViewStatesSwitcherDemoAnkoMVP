package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp

import android.app.Application
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.di.appModule
import org.koin.android.ext.android.startKoin

/**
 * Created by Sergio Crespo Toubes on 01/12/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
class MyApplication : Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin(this, listOf(appModule))
    }

}