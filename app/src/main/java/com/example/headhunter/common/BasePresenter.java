package com.example.headhunter.common;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter{

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void disposeAll(){
        compositeDisposable.clear();
    }
}
