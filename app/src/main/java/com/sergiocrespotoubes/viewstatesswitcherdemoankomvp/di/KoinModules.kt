package com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.NetworkConfig
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.components.network.PostsApi
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainActivity
import com.sergiocrespotoubes.viewstatesswitcherdemoankomvp.ui.main.MainContract
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

    //object Params {
    //    const val MAIN_VIEW = "MAIN_VIEW"
    //}

    //factory <PostsService>{ PostsService(get()) }
    //factory <PostsService>{ PostsService(get()) }
    //factory <PostsRepository>{ DefaultPostsRepository(get()) }

    //single { MainActivity()) as MainContract.View }
    //factory<MainPresenter> { (contract: MainContract.View) -> MainPresenter(contract) }
    factory { (contract: MainContract.View) -> MainPresenter(contract) as MainContract.Presenter }

    //factory<MainModel> { MainModel(get()) }
    //single<PostsApi> { get<Retrofit>().create(PostsApi::class.java) }

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