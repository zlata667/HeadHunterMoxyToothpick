package com.example.headhunter.common;

import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends BaseView> extends MvpPresenter<V>{

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void disposeAll(){
        compositeDisposable.clear();
    }
}
