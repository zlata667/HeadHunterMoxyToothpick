package com.example.headhunter.ui.startApp;

import com.example.headhunter.common.BaseView;
import com.example.headhunter.data.model.Country;

import java.util.List;

public interface StartSearchView extends BaseView{

    void loadRegions(List<Country> countries);

    void openVacanciesFragment();
}
