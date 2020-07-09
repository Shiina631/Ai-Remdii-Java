package com.example.arjava11.api;

import com.example.arjava11.model.DefaultResponse;
import com.example.arjava11.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    //implementing the Retrofit code man
    @FormUrlEncoded
    @POST("createuser")//from the url of the retro
    Call<DefaultResponse> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("age") Integer age,
            @Field("password") String password,
            @Field("status") String status
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );
}
