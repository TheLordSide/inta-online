package tg.intaonline.intaonline.ApiClient.service

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import tg.intaonline.intaonline.ApiClient.ApiResponse.LoginResponse
import tg.intaonline.intaonline.ApiClient.ApiResponse.OtpVerifyresponse
import tg.intaonline.intaonline.ApiClient.ApiResponse.RegisterResponse


interface ApiInterface {
    @FormUrlEncoded
        @POST("compte/signup.php")
         fun  login(
        @Field("compte_user_mail") username: String?,
        @Field("compte_password") password: String?
        ): Call<LoginResponse>

         @FormUrlEncoded
         @POST("compte/register.php")
         fun register(
             @Field("compte_user_mail") usermail: String?,
             @Field("compte_password") password: String?,
             @Field("compte_nom") nomuser: String?,
             @Field("compte_prenom") prenomuser: String?
         ): Call<RegisterResponse>

        @FormUrlEncoded
        @POST("compte/verify_otp.php")
        fun  otpverify(
            @Field("compte_user_mail") email: String?,
            @Field("otp") otp: String?
        ): Call<OtpVerifyresponse>




}