package com.example.headhunter.data.api;

import com.example.headhunter.data.model.Vacancies;
import com.example.headhunter.data.model.Vacancy;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HeadHunterApi{

    @GET("/vacancies")
    Single<Vacancies> getVacancies(@Query("text") String searchField);

    @GET("/vacancies/{vacancy_id}")
    Single<Vacancy> getVacancy(@Path("vacancy_id") String vacancyId);
}
