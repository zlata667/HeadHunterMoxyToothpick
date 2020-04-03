package com.example.headhunter.ui.vacancies;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.R;
import com.example.headhunter.common.SingleFragmentActivity;
import com.example.headhunter.data.data.model.Vacancy;
import com.example.headhunter.ui.startApp.StartSearchActivity;
import com.example.headhunter.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class VacanciesActivity extends SingleFragmentActivity{

    @Override
    protected Fragment getFragment(){
        return VacanciesFragment.newInstance();
    }
}
