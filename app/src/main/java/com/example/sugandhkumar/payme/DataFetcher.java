package com.example.sugandhkumar.payme;

import android.util.Log;

import com.example.sugandhkumar.payme.model.Affiliate;
import com.example.sugandhkumar.payme.model.ApiListings;
import com.example.sugandhkumar.payme.model.AvailableVariants;
import com.example.sugandhkumar.payme.model.FlipkartProducts;
import com.example.sugandhkumar.payme.model.FoodNutrition;
import com.example.sugandhkumar.payme.model.V010;
import com.example.sugandhkumar.payme.model.flipkartinfo.ProductInfoList;
import com.example.sugandhkumar.payme.network.API;
import com.example.sugandhkumar.payme.network.RestClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.*;
import retrofit2.Callback;

/**
 * Created by sugandh kumar on 16-02-2018.
 */

public class DataFetcher {

    private static Affiliate affiliate;
    private static ApiListings apiListings;
    private  static AvailableVariants availableVariants;
    private static FoodNutrition foodNutrition;
    private static V010 v010;

    private static ArrayList<ProductInfoList> mLists = new ArrayList<>();

    public static ArrayList<ProductInfoList> getmLists() {
        return mLists;
    }

    public static void setmLists(ArrayList<ProductInfoList> mLists) {
        DataFetcher.mLists = mLists;
        mLists.clear();
    }


    public static void getTelevisionDataDetails(String data)  {

        API apiService = RestClient.getData().create(API.class);
        Log.d("Api Calling:--",data);
        final Call<FlipkartProducts> flipkartProductsCall = apiService.getTelevisionDetails(data);
        flipkartProductsCall.enqueue(new Callback<FlipkartProducts>() {
            @Override
            public void onResponse(Call<FlipkartProducts> call, Response<FlipkartProducts> response) {

                FlipkartProducts flipkartProducts = response.body();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonStr = gson.toJson(flipkartProducts);
                Log.d("FlipkartActivity.this",jsonStr);
                System.out.println(jsonStr);
                mLists.clear();
                ArrayList<ProductInfoList> productInfoList = flipkartProducts.getProductInfoList();
                String jsonInfo = gson.toJson(productInfoList);
                System.out.print("ProductsInfoJson :"+jsonInfo);
                ProductInfoList[] posts= gson.fromJson(jsonInfo, ProductInfoList[].class);
                for(int i=0;i<posts.length;i++){
                    System.out.print("Products Arraylists"+ posts[i]);
//
                    mLists.add(posts[i]);
                }

            }

            @Override

            public void onFailure(@NotNull  Call<FlipkartProducts> call, Throwable t) {
                t.printStackTrace();
                System.out.println("Unable to fetch the data from  Flipkart server");
            }
        });
    }
}
