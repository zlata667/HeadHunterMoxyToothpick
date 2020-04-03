package com.example.headhunter.ui.vacancies;

import androidx.fragment.app.Fragment;
import com.example.headhunter.common.SingleFragmentActivity;

public class VacanciesActivity extends SingleFragmentActivity{

    @Override
    protected Fragment getFragment(){
        return VacanciesFragment.newInstance();
    }
}
