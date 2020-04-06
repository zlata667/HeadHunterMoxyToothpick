package com.example.headhunter.ui.vacancies;

import com.arellomobile.mvp.InjectViewState;
import com.example.headhunter.common.BasePresenter;
import com.example.headhunter.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class VacanciesPresenter extends BasePresenter<VacanciesView>{

    private final VacanciesView mView;

    public VacanciesPresenter(VacanciesView vacanciesView){
        mView = vacanciesView;
    }

    public void getVacancies(String searchText, String searchRegion){

        compositeDisposable.add(ApiUtils.getApiService().getVacancies(searchText, searchRegion)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> mView.showRefresh())
                .doFinally(mView::hideRefresh)
                .subscribe(
                        vacancies -> mView.showVacancies(vacancies.getItems()),
                        throwable -> mView.showError()
                ));
    }

    public void openVacancyFragment(String vacancyId){
        mView.openVacancyFragment(vacancyId);
    }
}
