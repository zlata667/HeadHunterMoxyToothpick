package com.example.headhunter.di;

import android.content.Context;

import toothpick.config.Module;


public class ContextModule extends Module{

    private final Context mContext;

    public ContextModule(Context context) {
        mContext = context;
        bind(Context.class).toInstance(mContext);
    }

    public Context provideContext() {
        return mContext;
    }
}
