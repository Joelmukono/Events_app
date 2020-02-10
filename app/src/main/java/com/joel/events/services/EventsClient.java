package com.joel.events.services;

import com.joel.events.interfaces.EventsApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.joel.events.BuildConfig.EVENT_API_KEY;
import static com.joel.events.Constants.EVENT_BASE_URL;

public class EventsClient {
    private static Retrofit retrofit = null;

    public static EventsApi getClient(){
        if(retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder().addHeader("Authorization",EVENT_API_KEY).build();
                    return chain.proceed(newRequest);
                }
            }).build();

            retrofit = new Retrofit.Builder().baseUrl(EVENT_BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(EventsApi.class);
    }


}
