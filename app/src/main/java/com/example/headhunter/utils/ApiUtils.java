package com.example.headhunter.utils;

import com.example.headhunter.BuildConfig;
import com.example.headhunter.data.data.api.HeadHunterApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils{
    public static final List<Class<? extends IOException>> NETWORK_EXCEPTIONS = Arrays.asList(
            UnknownHostException.class,
            SocketTimeoutException.class,
            ConnectException.class
    );

    private static OkHttpClient sClient;
    private static Retrofit sRetrofit;
    private static Gson sGson;
    private static HeadHunterApi sApi;

    private static OkHttpClient getClient() {
        if (sClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

            sClient = builder.build();
        }
        return sClient;
    }

    private static Retrofit getRetrofit() {
        if (sGson == null) {
            sGson = new Gson();
        }
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    // need for interceptors
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(sGson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static HeadHunterApi getApiService() {
        if (sApi == null) {
            sApi = getRetrofit().create(HeadHunterApi.class);
        }
        return sApi;
    }
}
