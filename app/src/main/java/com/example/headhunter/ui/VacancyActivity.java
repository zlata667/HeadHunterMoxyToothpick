package com.example.headhunter.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.R;
import com.example.headhunter.data.model.Vacancy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class VacancyActivity extends AppCompatActivity{

    private VacancyAdapter vacancyAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacancies_activity);
        initRecyclerView();
        loadVacancies();
    }

    private void loadVacancies(){
        Collection<Vacancy> vacancies = getVacancies();
        vacancyAdapter.setItems(vacancies);
    }

    private Collection<Vacancy> getVacancies(){
        return Arrays.asList(
                new Vacancy("title 1", "description 1"),
                new Vacancy("title 2", "description 2"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3"),
                new Vacancy("title 3", "description 3")
        );
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        vacancyAdapter = new VacancyAdapter();
        recyclerView.setAdapter(vacancyAdapter);
    }
}
