package com.sergiocrespotoubes.gasolineordiesel.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainActivity
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainContract
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainPresenter
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.NetworkConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sergio Crespo Toubes on 01/12/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
val appModule = module {

    val mainModule = module {
        single<MainContract.View> { MainActivity() }
        factory<MainContract.Presenter> { MainPresenter(get()) }
    }

    single {
        Retrofit.Builder()
            .apply {
                addCallAdapterFactory(CoroutineCallAdapterFactory())
                addConverterFactory(GsonConverterFactory.create())
                baseUrl(NetworkConfig.API_URL)
                client(get())
            }
            .build()
    }

    single {
        OkHttpClient.Builder()
            //.addInterceptor(get<ChuckInterceptor>())
            //.addInterceptor(get<HeadersInterceptor>())
            //.addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

}