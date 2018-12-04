package com.sergiocrespotoubes.gasolineordiesel.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.datasource.PostsService
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.NetworkConfig
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.PostsApi
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.repository.DefaultPostsRepository
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.repository.PostsRepository
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainActivity
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainContract
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainModel
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainPresenter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sergio Crespo Toubes on 01/12/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
val appModule = module {

    //factory <PostsService>{ PostsService(get()) }
    //factory <PostsRepository>{ DefaultPostsRepository(get()) }
    factory<MainContract.Presenter> { (activity: MainActivity) -> MainPresenter(activity, get()) }
    factory<MainContract.Model> { MainModel(get()) }
    single<PostsApi> { get<Retrofit>().create(PostsApi::class.java) }

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
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

}