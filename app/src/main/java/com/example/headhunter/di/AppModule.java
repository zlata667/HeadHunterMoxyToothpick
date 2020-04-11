package com.example.headhunter.di;

import com.example.headhunter.AppDelegate;

import toothpick.config.Module;

public class AppModule extends Module{

    private final AppDelegate mApp;

    public AppModule(AppDelegate mApp){
        this.mApp = mApp;
        bind(AppDelegate.class).toInstance(mApp);
    }

    AppDelegate provideApp(){
        return mApp;
    }
}
