package com.example.yjp_capstone.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiController {

    @GET("/")
    Call<List<Long>> getaaa();
}
