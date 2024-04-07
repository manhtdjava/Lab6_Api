package com.example.and103_thanghtph31577_lab5.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.and103_thanghtph31577_lab5.R;
import com.example.and103_thanghtph31577_lab5.databinding.ItemFruitBinding;
import com.example.and103_thanghtph31577_lab5.databinding.ItemOderBinding;
import com.example.and103_thanghtph31577_lab5.model.Fruit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class OderFruitAdapter extends RecyclerView.Adapter<OderFruitAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Fruit> list;
    private SharedPreferences sharedPreferences;

    public OderFruitAdapter(Context context, ArrayList<Fruit> list, SharedPreferences sharedPreferences) {
        this.context = context;
        this.list = list;
        this.sharedPreferences = sharedPreferences;
    }

    public interface FruitClick {
        void delete(Fruit fruit);

    }

    @NonNull
    @Override
    public OderFruitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOderBinding binding = ItemOderBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OderFruitAdapter.ViewHolder holder, int position) {
        Fruit fruit = list.get(position);
        holder.binding.tvName.setText(fruit.getName());
        holder.binding.tvPriceQuantity.setText("price :" +fruit.getPrice()+" - quantity:" +fruit.getQuantity());
        holder.binding.tvDes.setText(fruit.getDescription());
        String url  = fruit.getImage().get(0);
        String newUrl = url.replace("localhost", "10.0.2.2");
        Glide.with(context)
                .load(newUrl)
                .thumbnail(Glide.with(context).load(R.drawable.baseline_broken_image_24))
                .into(holder.binding.img);



        Log.d("321321", "onBindViewHolder: "+list.get(position).getImage().get(0));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOderBinding binding;
        public ViewHolder(ItemOderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}