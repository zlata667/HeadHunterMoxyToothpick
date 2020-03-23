package com.example.headhunter.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.R;
import com.example.headhunter.data.model.Vacancy;

class VacancyHolder extends RecyclerView.ViewHolder{

    private TextView textViewTitle;
    private TextView textViewDescription;

    VacancyHolder(View itemView){
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.tv_title);
        textViewDescription = itemView.findViewById(R.id.tv_description);
    }


    void bind(Vacancy vacancy){
        textViewTitle.setText(vacancy.getTitle());
        textViewDescription.setText(vacancy.getDescription());
    }
}
