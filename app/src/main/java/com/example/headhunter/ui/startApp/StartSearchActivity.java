package com.example.headhunter.ui.startApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.headhunter.R;
import com.example.headhunter.ui.vacancies.VacanciesActivity;
import com.example.headhunter.ui.vacancies.VacanciesFragment;

public class StartSearchActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        EditText editTextSearch = findViewById(R.id.et_search);

        findViewById(R.id.btn_search).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), VacanciesActivity.class);
            Bundle args = new Bundle();
            args.putString(VacanciesFragment.SEARCH_TEXT, editTextSearch.getText().toString());
            intent.putExtra(VacanciesActivity.SEARCH_KEY, args);
            startActivity(intent);
        });
    }
}
