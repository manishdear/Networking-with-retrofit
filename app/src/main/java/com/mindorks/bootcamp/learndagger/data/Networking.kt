package com.mindorks.bootcamp.learndagger.data

import android.net.Network
import android.os.Build
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mindorks.bootcamp.learndagger.BuildConfig
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object Networking {
    const val HEADER_API_KEY = "x-api-key"
    const val HEADER_ACCESS_TOKEN = "x-access-token"
    const val HEADER_USER_ID = "x-user-id"

    private const val NETWORK_CALL_TIMEOUT = 60

    lateinit var API_KEY: String

    fun create(apikey: String, baseurl: String, cacheDir: File, cacheSize: Long): NetworkService{

        API_KEY = apikey
        return Retrofit.Builder()
                .baseUrl(baseurl)
                .client(
                        OkHttpClient.Builder()
                                .cache(Cache(   cacheDir, cacheSize))
                                .addInterceptor(HttpLoggingInterceptor()

                                        .apply{
                                            level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                                            else   HttpLoggingInterceptor.Level.NONE
                                        })
                                .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                                .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                                .build()
                )

                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(NetworkService::class.java)

    }
}