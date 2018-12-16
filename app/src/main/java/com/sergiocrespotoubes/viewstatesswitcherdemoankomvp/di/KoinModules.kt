package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.NetworkConfig
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.PostsApi
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.repository.DefaultPostsRepository
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.repository.PostsRepository
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainContract
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainModel
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainPresenter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Sergio Crespo Toubes on 01/12/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */

val appModule = module {
    single { createOkHttpClient() }
    single { createWebService(get()) as PostsApi }
    single { DefaultPostsRepository(get()) as PostsRepository }
    factory { MainModel(get()) as MainContract.Model }
    factory { (contract: MainContract.View) -> MainPresenter(contract, get()) as MainContract.Presenter }

    /*single {
        OkHttpClient.Builder()
            //.addInterceptor(get<ChuckInterceptor>())
            //.addInterceptor(get<HeadersInterceptor>())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }*/
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .apply {
            addCallAdapterFactory(CoroutineCallAdapterFactory())
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(NetworkConfig.API_URL)
            client(okHttpClient)
        }
        .build()
    return retrofit.create(T::class.java)
}