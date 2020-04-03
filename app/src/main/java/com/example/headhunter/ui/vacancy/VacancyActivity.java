package com.example.headhunter.ui.vacancy;

import androidx.fragment.app.Fragment;

import com.example.headhunter.common.SingleFragmentActivity;

public class VacancyActivity extends SingleFragmentActivity{

    public static final String VACANCY_KEY = "VACANCY_KEY";

    @Override
    protected Fragment getFragment(){
        if (getIntent() != null){
            return VacancyFragment.newInstance(getIntent().getBundleExtra(VACANCY_KEY));
        }
        throw new IllegalStateException("getIntent cannot be null");
    }
}
