package com.example.aerospace6a_6a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aerospace6a_6a.databinding.ItemListBinding;

import java.util.ArrayList;

public class VtornikAdapter extends RecyclerView.Adapter<VtornikAdapter.ViewHolder> {
   ItemListBinding binding;
    private NavController navController;
    private ArrayList<Model> list = new ArrayList<>();

    public VtornikAdapter(VtornikFragment vtornikFragment) {
    }
    public void setList(ArrayList<Model> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VtornikAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new VtornikAdapter.ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull VtornikAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
        binding.btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController((Activity) view.getContext(),
                        R.id.nav_host_fragment_activity_main);
                navController
                        .navigate(R.id.action_vtornikFragment_to_blankFragment);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(Model model) {
            Glide.with(binding.getRoot())
                    .load(model.getImage())
                    .centerCrop()
                    .into(binding.image);
            binding.name.setText(model.getName());
        }
    }
}
