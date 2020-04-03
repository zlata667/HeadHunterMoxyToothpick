package com.example.headhunter.ui.vacancies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.R;
import com.example.headhunter.common.RefreshOwner;
import com.example.headhunter.common.Refreshable;

import com.example.headhunter.ui.startApp.StartSearchActivity;
import com.example.headhunter.ui.vacancy.VacancyActivity;
import com.example.headhunter.ui.vacancy.VacancyFragment;
import com.example.headhunter.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VacanciesFragment extends Fragment implements Refreshable,
        VacanciesAdapter.OnItemClickListener{

    public static final String SEARCH_TEXT = "SEARCH_TEXT";

    private VacanciesAdapter vacancyAdapter;
    private RecyclerView recyclerView;
    private RefreshOwner refreshOwner;
    private View errorView;
    private Disposable disposable;
    private String searchText;

    static Fragment newInstance(Bundle args){
        VacanciesFragment fragment = new VacanciesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof RefreshOwner) {
            refreshOwner = ((RefreshOwner) context);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fr_vacancies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        recyclerView = view.findViewById(R.id.recycler);
        errorView = view.findViewById(R.id.errorView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null){
            getActivity().setTitle("Vacancies");
        }

        if (getArguments() != null){
            searchText = getArguments().getString(SEARCH_TEXT);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        vacancyAdapter = new VacanciesAdapter(this);
        recyclerView.setAdapter(vacancyAdapter);

        onRefreshData();
    }

    @Override
    public void onDetach() {
        refreshOwner = null;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDetach();
    }

    @Override
    public void onRefreshData(){
        getVacancies();
    }

    private void getVacancies(){
        disposable = ApiUtils.getApiService().getVacancies(searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> refreshOwner.setRefreshState(true))
                .doFinally(() -> refreshOwner.setRefreshState(false))
                .subscribe(
                        vacancies -> {
                            errorView.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);
                            vacancyAdapter.setItems(vacancies.getItems());
                        },
                        throwable -> {
                            recyclerView.setVisibility(View.GONE);
                            errorView.setVisibility(View.VISIBLE);
                        }
                );
    }

    @Override
    public void onItemClick(String id){
        Intent intent = new Intent(getActivity(), VacancyActivity.class);
        Bundle args = new Bundle();
        args.putString(VacancyFragment.VACANCY_ID, id);
        intent.putExtra(VacancyActivity.VACANCY_KEY, args);
        startActivity(intent);
    }
}
