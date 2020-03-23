package com.example.headhunter.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.R;
import com.example.headhunter.data.model.Vacancy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VacancyAdapter extends RecyclerView.Adapter<VacancyHolder>{

    @NonNull
    private final List<Vacancy> vacancyList = new ArrayList<>();

    @NonNull
    @Override
    public VacancyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_vacancy, parent, false);
        return new VacancyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VacancyHolder holder, int position){
        holder.bind(vacancyList.get(position));
    }

    @Override
    public int getItemCount(){
        return vacancyList.size();
    }

    void setItems(Collection<Vacancy> vacancies){
       vacancyList.addAll(vacancies);
       notifyDataSetChanged();
    }

   public void clearItems(){
       vacancyList.clear();
       notifyDataSetChanged();
   }
}
