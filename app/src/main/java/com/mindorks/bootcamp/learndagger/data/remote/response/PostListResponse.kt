package com.mindorks.bootcamp.learndagger.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mindorks.bootcamp.learndagger.data.model.Dummy
import com.mindorks.bootcamp.learndagger.data.model.Post

data class PostListResponse(

        @Expose
        @SerializedName("statusCode")
        var statusCode: String,

        @Expose
        @SerializedName("messege")
        var messege: String,

        @Expose
        @SerializedName("data")
        var data: List<Post>
)