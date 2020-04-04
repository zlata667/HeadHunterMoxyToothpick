package com.example.headhunter.ui.startApp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.headhunter.R;
import com.example.headhunter.data.model.Country;
import com.example.headhunter.ui.vacancies.VacanciesActivity;
import com.example.headhunter.ui.vacancies.VacanciesFragment;
import com.example.headhunter.utils.ApiUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StartSearchActivity extends AppCompatActivity{

    private Disposable disposable;
    private Map<String, String> regionMap = new HashMap<>();
    private List<String> regionNamesList;

    private AutoCompleteTextView autoCompleteTextView;
    private EditText editTextSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getCities();
        setContentView(R.layout.search_activity);

        editTextSearch = findViewById(R.id.et_search);
        findViewById(R.id.btn_search).setOnClickListener(v -> {
            onButtonClick();
        });
    }

    private void getCities(){
        disposable = ApiUtils.getApiService().getCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        countries -> {
                            for (Country country : countries){
                                for (Country.Region region : country.getAreas()){
                                    regionMap.put(region.getName(), region.getId());
                                }
                            }

                            regionNamesList = new ArrayList<>(regionMap.keySet());
                            autoCompleteTextView = findViewById(R.id.et_city);
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                    R.layout.support_simple_spinner_dropdown_item, regionNamesList);
                            autoCompleteTextView.setAdapter(adapter);
                        },
                        throwable -> {
                            Toast.makeText(this, "Не удалось загрузить список регионов", Toast.LENGTH_SHORT).show();
                        }
                );
    }

    private void onButtonClick(){
        Intent intent = new Intent(getApplicationContext(), VacanciesActivity.class);
        Bundle args = new Bundle();

        String region = autoCompleteTextView.getText().toString();
        if (regionMap.containsKey(region)){
            args.putString(VacanciesFragment.SEARCH_REGION, regionMap.get(region));
        }

        args.putString(VacanciesFragment.SEARCH_TEXT, editTextSearch.getText().toString());
        intent.putExtra(VacanciesActivity.SEARCH_KEY, args);
        startActivity(intent);
    }

}
