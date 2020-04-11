package com.example.headhunter.di;

import com.example.headhunter.BuildConfig;
import com.example.headhunter.data.api.HeadHunterApi;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import toothpick.config.Module;

public class NetworkModule extends Module{

    private final Gson mGson = provideGson();
    private final OkHttpClient mClient = provideClient();
    private final Retrofit mRetrofit = provideRetrofit();

    public NetworkModule(){
        bind(Gson.class).toInstance(mGson);
        bind(OkHttpClient.class).toInstance(mClient);
        bind(Retrofit.class).toInstance(mRetrofit);
        bind(HeadHunterApi.class).toInstance(getApiService());
    }

    OkHttpClient provideClient(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        return builder.build();
    }

    Gson provideGson(){
        return new Gson();
    }

    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(mClient)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    HeadHunterApi getApiService(){
        return mRetrofit.create(HeadHunterApi.class);
    }
}
