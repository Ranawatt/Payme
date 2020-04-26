package com.example.sugandhkumar.payme.network;

import com.example.sugandhkumar.payme.model.Flipkart;
import com.example.sugandhkumar.payme.model.FlipkartProducts;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public interface API {

    @GET(APIHelper.JSON_LIST)
    Call<Flipkart>  getFlipkartDetails();


    @GET
    Call<FlipkartProducts> getTelevisionDetails(@Url String url);



}
