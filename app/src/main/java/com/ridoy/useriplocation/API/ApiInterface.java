package com.ridoy.useriplocation.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    static final String BASE_URL="http://ip-api.com/";

    @GET("json")
    Call<List<UserCountry>> getCountryData();
}
