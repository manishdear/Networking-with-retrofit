package com.mindorks.bootcamp.learndagger.data.remote

import android.content.Context
import com.mindorks.bootcamp.learndagger.data.Networking
import com.mindorks.bootcamp.learndagger.data.model.Dummy
import com.mindorks.bootcamp.learndagger.data.remote.request.DummyRequest
import com.mindorks.bootcamp.learndagger.data.remote.response.DummyResponse
import com.mindorks.bootcamp.learndagger.data.remote.response.GeneralResponse
import com.mindorks.bootcamp.learndagger.data.remote.response.PostListResponse

import com.mindorks.bootcamp.learndagger.di.ApplicationContext
import com.mindorks.bootcamp.learndagger.di.NetworkInfo
import io.reactivex.Single
import retrofit2.http.*

import javax.inject.Inject
import javax.inject.Singleton


interface NetworkService {

    @POST(Endpoints.DUMMY)
    fun doDummyCall(
            @Body request: DummyRequest,
            @Header(Networking.HEADER_API_KEY) apikey: String = Networking.API_KEY
    ): Single<DummyResponse>

    @GET(Endpoints.DUMMY)
    fun doDummyCallget(
            @Header(Networking.HEADER_API_KEY) apikey: String = Networking.API_KEY
    ): Single<DummyResponse>

    @GET(Endpoints.HOME_POST_LIST)
    fun doHomePostListCall(
            @Query("firstPostId") firstPostId:  String?,
            @Query("lastPostId") lastPostId: String?,
            @Header(Networking.HEADER_USER_ID) userId: String,
            @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String,
            @Header(Networking.HEADER_API_KEY) apikey: String = Networking.API_KEY
    ): Single<PostListResponse>

    @DELETE(Endpoints.POST_DELETE)
    fun doPostDelete(
            @Path("postId") postId: String,
            @Header(Networking.HEADER_USER_ID) userId: String,
            @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String,
            @Header(Networking.HEADER_API_KEY) apikey: String = Networking.API_KEY
    ): Single<GeneralResponse>
}
