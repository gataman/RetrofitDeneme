package com.gurcanataman.retrofitdeneme;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gurcanataman on 27.11.2017.
 */

public class ApiClient {

    public static final String BASE_URL="http://carelink.minimed.eu/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient(){

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
