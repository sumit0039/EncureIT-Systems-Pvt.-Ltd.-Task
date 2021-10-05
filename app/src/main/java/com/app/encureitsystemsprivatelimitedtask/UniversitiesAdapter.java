package com.app.encureitsystemsprivatelimitedtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.encureitsystemsprivatelimitedtask.databinding.UniversitiesRowBinding;

import java.util.List;

public class UniversitiesAdapter extends RecyclerView.Adapter<UniversitiesAdapter.ViewHolder> {
    private Context context;
    private List<TaskResponse> taskResponsesList;
    private LayoutInflater layoutInflater;
    private GetName getName;

    public UniversitiesAdapter(Context context, List<TaskResponse> taskResponsesList,GetName getName) {
        this.context = context;
        this.taskResponsesList = taskResponsesList;
        this.getName = getName;
    }
    public interface GetName{
        void getName(String name,String country,String alpha_two_code, Object state_province);
    }

    @NonNull
    @Override
    public UniversitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UniversitiesRowBinding binding;
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.universities_row,parent,false);
        return new UniversitiesAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversitiesAdapter.ViewHolder holder, int position) {
        holder.binding.universityName.setText(taskResponsesList.get(position).getName());
        holder.binding.root.setOnClickListener(v -> {
            getName.getName(taskResponsesList.get(position).getName(),taskResponsesList.get(position).getCountry(),
                    taskResponsesList.get(position).getAlphaTwoCode(),taskResponsesList.get(position).getStateProvince());
        });

    }

    @Override
    public int getItemCount() {
        return taskResponsesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        UniversitiesRowBinding binding;
        public ViewHolder(@NonNull UniversitiesRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
