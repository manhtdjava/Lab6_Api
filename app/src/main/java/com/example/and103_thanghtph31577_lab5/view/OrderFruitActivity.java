package com.example.and103_thanghtph31577_lab5.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and103_thanghtph31577_lab5.R;
import com.example.and103_thanghtph31577_lab5.adapter.OderFruitAdapter;
import com.example.and103_thanghtph31577_lab5.model.Fruit;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class OrderFruitActivity extends AppCompatActivity implements OderFruitAdapter.FruitClick {
    private ImageView back;
    private ArrayList<Fruit> cartItems;
    private OderFruitAdapter adapter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_fruit);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("CartItems", Context.MODE_PRIVATE);

        // Initialize RecyclerView and adapter
        RecyclerView recyclerView = findViewById(R.id.recycler_view_shopping_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OderFruitAdapter(this, getCartItems(), sharedPreferences);
        recyclerView.setAdapter(adapter);

        // Initialize the "back" button
        back = findViewById(R.id.btn_back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderFruitActivity.this, HomeActivity.class));
            }
        });
    }

    @Override
    public void delete(Fruit fruit) {
        // Empty implementation since deleting from cart might not be applicable
    }

    // Method to retrieve the list of cart items from SharedPreferences
    private ArrayList<Fruit> getCartItems() {
        ArrayList<Fruit> cartItems = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cartItems", null);
        if (json != null) {
            Type type = new TypeToken<ArrayList<Fruit>>() {}.getType();
            cartItems = gson.fromJson(json, type);
            Log.d("CartItems", "Retrieved from SharedPreferences: " + cartItems.size() + " items");
        } else {
            Log.d("CartItems", "No data retrieved from SharedPreferences");
        }
        return cartItems;
    }

}
