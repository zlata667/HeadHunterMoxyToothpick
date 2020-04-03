package com.example.headhunter.ui.startApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.headhunter.R;
import com.example.headhunter.ui.vacancies.VacanciesActivity;

public class StartSearchActivity extends AppCompatActivity{

    private EditText editTextSearch;
    private Button buttonSearch;
    public static String searchText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        editTextSearch = findViewById(R.id.et_search);
        buttonSearch = findViewById(R.id.btn_search);

        buttonSearch.setOnClickListener(v -> {
            searchText = editTextSearch.getText().toString();
            startActivity(new Intent(getApplicationContext(), VacanciesActivity.class));
        });
    }
}
