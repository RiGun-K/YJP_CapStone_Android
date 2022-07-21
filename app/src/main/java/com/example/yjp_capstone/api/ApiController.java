package com.example.yjp_capstone.api;

import com.example.yjp_capstone.domain.Storage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiController {

    @GET("checkMember/{memberId}")
    public Call<Object[]> getUseBoxList(@Query("memberId")String id);

    @GET("getStorage")
    Call<List<Storage>> getSt();
}
