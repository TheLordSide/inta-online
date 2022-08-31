package tg.intaonline.intaonline.ApiClient.ApiResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoursRes(

    @SerializedName("liste")
    @Expose
    val liste: ArrayList<Liste>,

    @SerializedName("message")
    @Expose
    val message: String ? = null,

    @SerializedName("success")
    @Expose
    val success: String ? = null,

    @SerializedName("total")
    @Expose
    val total: Int ? = null
)