package com.example.headhunter;

import android.app.Application;
import com.example.headhunter.di.AppModule;
import com.example.headhunter.di.ContextModule;
import com.example.headhunter.di.NetworkModule;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;
import toothpick.registries.FactoryRegistryLocator;
import toothpick.registries.MemberInjectorRegistryLocator;
import toothpick.smoothie.module.SmoothieApplicationModule;

public class AppDelegate extends Application{

    private static Scope sAppScope;

    @Override
    public void onCreate(){
        super.onCreate();

        Toothpick.setConfiguration(Configuration.forProduction().disableReflection());
        MemberInjectorRegistryLocator.setRootRegistry(new com.example.headhunter.MemberInjectorRegistry());
        FactoryRegistryLocator.setRootRegistry(new com.example.headhunter.FactoryRegistry());

        sAppScope = Toothpick.openScope(AppDelegate.class);
        sAppScope.installModules(new SmoothieApplicationModule(this), new NetworkModule(), new ContextModule(this), new AppModule(this));
    }

    public static Scope getAppScope(){
        return sAppScope;
    }
}
