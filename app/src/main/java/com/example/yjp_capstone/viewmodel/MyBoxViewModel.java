package com.example.yjp_capstone.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yjp_capstone.api.ApiController;
import com.example.yjp_capstone.domain.UseBoxDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyBoxViewModel extends ViewModel {
    MutableLiveData<List<Map<String, Object>>> data = new MutableLiveData<>();


    Gson gson = new GsonBuilder().setLenient().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.30.3.57:9002/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    ApiController apiController = retrofit.create(ApiController.class);

    public List<UseBoxDAO> getUseBox() {
        List<UseBoxDAO> useBox = new ArrayList<>();
        apiController.getUseBoxList("2").enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());

                    for (int i = 0; i < data.getValue().size(); i++) {
                        UseBoxDAO boxDAO = new UseBoxDAO();
                        boxDAO.setBoxName(data.getValue().get(i).get("BOXNAME").toString());
                        boxDAO.setStorageName(data.getValue().get(i).get("STORAGENAME").toString());
                        boxDAO.setUseCode(data.getValue().get(i).get("USECODE").toString());
                        boxDAO.setUseState(data.getValue().get(i).get("USESTATE").toString().substring(0,0));
                        if (boxDAO.getUseState().equals("9") || boxDAO.getUseState().equals("a")){
                            boxDAO.setDel(data.getValue().get(i).get("USESTATE").toString().substring(1));
                        }else{
                            if (boxDAO.getUseState().toString().length()>1){
                                boxDAO.setMoveUseCode(data.getValue().get(i).get("USESTATE").toString().substring(1));
                            }
                        }
                        useBox.add(boxDAO);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {
                t.printStackTrace();
                Log.d("bbb","fail");
            }
        });
        return useBox;
    }




    @Override
    protected void onCleared() {
        super.onCleared();

    }
}