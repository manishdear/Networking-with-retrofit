package com.mindorks.bootcamp.learndagger.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeneralResponse(

        @Expose
        @SerializedName("statusCode")
        var statusCode: String,

        @Expose
        @SerializedName("messege")
        var messege: String
)