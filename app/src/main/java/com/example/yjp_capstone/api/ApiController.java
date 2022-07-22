package com.example.yjp_capstone.api;

import com.example.yjp_capstone.domain.Storage;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiController {

    @GET("checkMember/{memberId}")
    public Call<List<Map<String,Object>>> getUseBoxList(@Path("memberId") String id);

    @GET("getStorage")
    Call<List<Storage>> getSt();

}
