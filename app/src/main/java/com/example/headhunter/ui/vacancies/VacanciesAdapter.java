package com.example.headhunter.ui.vacancies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.R;
import com.example.headhunter.data.data.model.Vacancy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VacanciesAdapter extends RecyclerView.Adapter<VacanciesHolder>{

    private final OnItemClickListener mOnItemClickListener;

    public VacanciesAdapter(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    private final List<Vacancy.ItemsBean> vacancyList = new ArrayList<>();

    @NonNull
    @Override
    public VacanciesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_vacancies, parent, false);
        return new VacanciesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VacanciesHolder holder, int position){
        holder.bind(vacancyList.get(position));
    }

    @Override
    public int getItemCount(){
        return vacancyList.size();
    }

    void setItems(Collection<Vacancy.ItemsBean> vacancies){
       vacancyList.addAll(vacancies);
       notifyDataSetChanged();
    }

   public void clearItems(){
       vacancyList.clear();
       notifyDataSetChanged();
   }

    public interface OnItemClickListener {
        void onItemClick(Vacancy.ItemsBean vacancy);
    }
}
