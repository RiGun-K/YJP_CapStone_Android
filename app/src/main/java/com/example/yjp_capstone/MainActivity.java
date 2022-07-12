package com.example.yjp_capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.yjp_capstone.api.ApiController;
import com.example.yjp_capstone.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:9002/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        retrofit.create(ApiController.class);

    }
}