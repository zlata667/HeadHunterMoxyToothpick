package com.example.headhunter.ui.startApp;

import android.view.View;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.example.headhunter.common.BasePresenter;
import com.example.headhunter.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class StartSearchPresenter extends BasePresenter<StartSearchView>{

    private final StartSearchView mView;

    public StartSearchPresenter(StartSearchView startSearchView){
        mView = startSearchView;
    }

    public void loadRegions(){
        compositeDisposable.add(ApiUtils.getApiService().getCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> mView.showRefresh())
                .doFinally(() -> mView.hideRefresh())
                .subscribe(
                        countries -> mView.loadRegions(countries),
                        throwable -> mView.showError()
                ));
    }

    public void openVacanciesFragment(){
        mView.openVacanciesFragment();
    }
}
