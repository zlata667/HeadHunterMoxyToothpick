package com.example.headhunter.ui.vacancy;

import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.example.headhunter.common.BasePresenter;
import com.example.headhunter.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class VacancyPresenter extends BasePresenter<VacancyView>{

    private final VacancyView mView;

    public VacancyPresenter(VacancyView vacancyView){
        mView = vacancyView;
    }

    public void getVacancy(String vacancyId){
        compositeDisposable.add(ApiUtils.getApiService().getVacancy(vacancyId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> mView.showRefresh())
                .doFinally(() -> mView.hideRefresh())
                .subscribe(vacancy -> mView.showVacancy(vacancy),
                        throwable -> mView.showError()));
    }
}
