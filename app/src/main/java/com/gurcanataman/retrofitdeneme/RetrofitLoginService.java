package com.gurcanataman.retrofitdeneme;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by gurcanataman on 27.11.2017.
 */

public interface RetrofitLoginService {

    @POST("j_security_check")
    @FormUrlEncoded
    Call<UserResponse> login(@Field("j_username") String username,
                             @Field("j_password") String password,
                             @Field("j_character_encoding") String charencodin);

}
