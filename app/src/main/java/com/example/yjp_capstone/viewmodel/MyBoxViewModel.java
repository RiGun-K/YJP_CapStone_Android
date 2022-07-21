package com.example.yjp_capstone.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yjp_capstone.MainActivity;
import com.example.yjp_capstone.api.ApiController;
import com.example.yjp_capstone.domain.Storage;
import com.example.yjp_capstone.domain.UseStorageBox;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyBoxViewModel extends ViewModel {
    MutableLiveData<String> error = new MutableLiveData<>();
    MutableLiveData<Object[]> data = new MutableLiveData<>();
    MutableLiveData<String> result = new MutableLiveData<>();

//    Call<Object[]> request = new Call<Object[]>

    Gson gson = new GsonBuilder().setLenient().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.30.3.57:9002/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    ApiController apiController = retrofit.create(ApiController.class);

    public void getUseBox() {
//        apiController.getUseBoxList("2").enqueue(new Callback<Object[]>() {
//            @Override
//            public void onResponse(Call<Object[]> call, Response<Object[]> response) {
//                if (response.isSuccessful()) {
//                    Log.d("bbb", response.body().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Object[]> call, Throwable t) {
//                t.printStackTrace();
//                Log.d("bbb","fail");
//            }
//        });
        apiController.getSt().enqueue(new Callback<List<Storage>>() {
            @Override
            public void onResponse(@NonNull Call<List<Storage>> call,@NonNull Response<List<Storage>> response) {
                if (response.isSuccessful()) {
                    Log.d("bbb", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Storage>> call, Throwable t) {
                t.printStackTrace();
                Log.d("bbb","fail");
            }
        });
    }



    @Override
    protected void onCleared() {
        super.onCleared();

    }
}