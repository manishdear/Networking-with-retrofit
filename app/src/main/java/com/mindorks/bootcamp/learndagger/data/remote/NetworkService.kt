package com.mindorks.bootcamp.learndagger.data.remote

import android.content.Context
import com.mindorks.bootcamp.learndagger.data.Networking
import com.mindorks.bootcamp.learndagger.data.model.Dummy
import com.mindorks.bootcamp.learndagger.data.remote.request.DummyRequest
import com.mindorks.bootcamp.learndagger.data.remote.response.DummyResponse

import com.mindorks.bootcamp.learndagger.di.ApplicationContext
import com.mindorks.bootcamp.learndagger.di.NetworkInfo
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

import javax.inject.Inject
import javax.inject.Singleton


interface NetworkService {

    @POST(Endpoints.DUMMY)
    fun doDummyCall(
            @Body request: DummyRequest,
            @Header(Networking.HEADER_API_KEY) apikey: String = Networking.API_KEY
    ): Single<DummyResponse>
}
