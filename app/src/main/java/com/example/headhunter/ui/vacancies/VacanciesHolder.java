package com.example.headhunter.ui.vacancies;

import android.text.Html;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.R;
import com.example.headhunter.data.model.Vacancies;

class VacanciesHolder extends RecyclerView.ViewHolder{

    private TextView textViewTitle;
    private TextView textViewDescription;
    private TextView textViewCity;

    VacanciesHolder(View itemView){
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.tv_title);
        textViewDescription = itemView.findViewById(R.id.tv_description);
        textViewCity = itemView.findViewById(R.id.tv_city);
    }

    void bind(Vacancies.ItemsBean vacancy, VacanciesAdapter.OnItemClickListener onItemClickListener){
        textViewTitle.setText(vacancy.getName());
        if (vacancy.getSnippet().getResponsibility() != null){
            textViewDescription.setText(Html.fromHtml(vacancy.getSnippet().getResponsibility()));
        }
        if (vacancy.getArea().getName() != null){
            textViewCity.setText(vacancy.getArea().getName());
        }
        if (onItemClickListener != null){
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(vacancy.getId()));
        }
    }
}
