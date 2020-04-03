package com.example.headhunter.ui.vacancies;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.R;
import com.example.headhunter.data.data.model.Vacancy;

class VacanciesHolder extends RecyclerView.ViewHolder{

    private TextView textViewTitle;
    private TextView textViewDescription;

    VacanciesHolder(View itemView){
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.tv_title);
        textViewDescription = itemView.findViewById(R.id.tv_description);
    }


    void bind(Vacancy.ItemsBean vacancy){
        textViewTitle.setText(vacancy.getName());
        textViewDescription.setText(vacancy.getSnippet().getResponsibility());
    }
}
