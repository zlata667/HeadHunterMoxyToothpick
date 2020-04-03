package com.example.headhunter.ui.vacancy;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.example.headhunter.R;
import com.example.headhunter.common.RefreshOwner;
import com.example.headhunter.common.Refreshable;
import com.example.headhunter.data.model.Vacancy;
import com.example.headhunter.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class VacancyFragment extends Fragment implements Refreshable{

    public static final String VACANCY_ID = "VACANCY_ID";

    private RefreshOwner refreshOwner;
    private Disposable disposable;
    private NestedScrollView vacancyView;
    private View errorView;

    private TextView vacancyName;
    private TextView employerName;
    private TextView salary;
    private TextView vacancyDescription;

    private String vacancyId;

    public static Fragment newInstance(Bundle args){
        VacancyFragment fragment = new VacancyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        refreshOwner = context instanceof RefreshOwner ? (RefreshOwner) context : null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fr_vacancy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        vacancyView = view.findViewById(R.id.view_vacancy);
        errorView = view.findViewById(R.id.errorView);

        vacancyName = view.findViewById(R.id.vacancy_name);
        employerName = view.findViewById(R.id.employer_name);
        salary = view.findViewById(R.id.salary);
        vacancyDescription = view.findViewById(R.id.vacancy_description);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null){
            vacancyId = getArguments().getString(VACANCY_ID);
        }

        if (getActivity() != null){
            getActivity().setTitle("Vacancy");
        }

        vacancyView.setVisibility(View.VISIBLE);

        onRefreshData();
    }

    @Override
    public void onRefreshData(){
        getVacancy();
    }

    private void getVacancy(){
        disposable = ApiUtils.getApiService().getVacancy(vacancyId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> refreshOwner.setRefreshState(true))
                .doFinally(() -> refreshOwner.setRefreshState(false))
                .subscribe(vacancy -> {
                            errorView.setVisibility(View.GONE);
                            vacancyView.setVisibility(View.VISIBLE);
                            bind(vacancy);
                        },
                        throwable -> {
                            errorView.setVisibility(View.VISIBLE);
                            vacancyView.setVisibility(View.GONE);
                        });
    }

    private void bind(Vacancy vacancy){
        vacancyName.setText(vacancy.getName());
        employerName.setText(vacancy.getEmployer().getName());
        salary.setText(String.valueOf(vacancy.getSalary().getFrom()).concat(" ").concat(vacancy.getSalary().getCurrency()));
        vacancyDescription.setText(Html.fromHtml(vacancy.getDescription()));
    }

    @Override
    public void onDetach(){
        refreshOwner = null;
        if (disposable!= null) {
            disposable.dispose();
        }
        super.onDetach();
    }
}
