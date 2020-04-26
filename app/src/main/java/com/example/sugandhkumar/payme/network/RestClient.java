package com.example.sugandhkumar.payme.network;

import com.example.sugandhkumar.payme.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public class RestClient {

    public static final String AUTHORIZATION_HEADER_NAME = "Fk-Affiliate-Id";
    public static final String AUTHORIZATION_TOKEN_PREFIX ="Fk-Affiliate-Token";
    public static final String AUTHORIZATION_HEADER_VALUE = "affliatek";
    public static final String AUTHORIZATION_TOKEN_VALUE = "98ccd7d7aa0c4b59a3f831d1db50f24e";


    public static final String REMOTE_BASE_URL = "https://affiliate-api.flipkart.net/affiliate/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit==null) {
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
//                    .connectTimeout(30, TimeUnit.MINUTES)
//                    .writeTimeout(30, TimeUnit.MINUTES)
//                    .readTimeout(30, TimeUnit.MINUTES);
            okHttpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .addHeader(AUTHORIZATION_HEADER_NAME,AUTHORIZATION_HEADER_VALUE)
                            .addHeader(AUTHORIZATION_TOKEN_PREFIX,AUTHORIZATION_TOKEN_VALUE)
//                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });
            retrofit = new Retrofit.Builder()
                    .baseUrl(REMOTE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getData(){
        retrofit = null;
        if (retrofit==null) {
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
//                    .connectTimeout(30, TimeUnit.MINUTES)
//                    .writeTimeout(30, TimeUnit.MINUTES)
//                    .readTimeout(30, TimeUnit.MINUTES);
            okHttpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .addHeader(AUTHORIZATION_HEADER_NAME,AUTHORIZATION_HEADER_VALUE)
                            .addHeader(AUTHORIZATION_TOKEN_PREFIX,AUTHORIZATION_TOKEN_VALUE)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(REMOTE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build());
            retrofit = builder.build();
        }
        return retrofit;
    }
}
