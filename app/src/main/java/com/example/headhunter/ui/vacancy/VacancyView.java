package com.example.headhunter.ui.vacancy;

import androidx.annotation.NonNull;

import com.example.headhunter.common.BaseView;
import com.example.headhunter.data.model.Vacancy;

public interface VacancyView extends BaseView{

    void showVacancy(@NonNull Vacancy vacancy);

}
