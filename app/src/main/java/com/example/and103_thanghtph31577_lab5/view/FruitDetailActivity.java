package com.example.and103_thanghtph31577_lab5.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.and103_thanghtph31577_lab5.R;
import com.example.and103_thanghtph31577_lab5.adapter.ImageAdapter;
import com.example.and103_thanghtph31577_lab5.databinding.ActivityFruitDetailBinding;
import com.example.and103_thanghtph31577_lab5.model.Fruit;

public class FruitDetailActivity extends AppCompatActivity {
    ActivityFruitDetailBinding binding;
    Fruit fruit;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFruitDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showData();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showData() {
        fruit = (Fruit) getIntent().getSerializableExtra("fruit");

        if (fruit != null) {
            binding.tvName.setText("Name: " + fruit.getName());
            binding.tvPrice.setText("Price: " + fruit.getPrice());
            binding.tvDescription.setText("Description: " + fruit.getDescription());
            binding.tvQuantity.setText("Quantity: " + fruit.getQuantity());
            binding.tvStatus.setText("Status: " + fruit.getStatus());

            adapter = new ImageAdapter(this, fruit.getImage());
            binding.rcvImg.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No fruit data found", Toast.LENGTH_SHORT).show();
        }
    }
}
