package com.example.myapplicati.networking;

import com.example.myapplicati.db.model.Transaction;
import com.example.myapplicati.db.model.User;
import com.example.myapplicati.networking.model.AppConfig;
import com.example.myapplicati.networking.model.ChecksumResponse;
import com.example.myapplicati.networking.model.LoginRequest;
import com.example.myapplicati.networking.model.Order;
import com.example.myapplicati.networking.model.PrepareOrderRequest;
import com.example.myapplicati.networking.model.PrepareOrderResponse;
import com.example.myapplicati.networking.model.Product;
import com.example.myapplicati.networking.model.RegisterRequest;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {
    @POST("login")
    Call<User> login(@Body LoginRequest loginRequest);

    @POST("register")
    Call<User> register(@Body RegisterRequest registerRequest);

    @GET("appConfig")
    Call<AppConfig> getAppConfig();

    @FormUrlEncoded
    @POST("getChecksum")
    Call<ChecksumResponse> getCheckSum(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("transactionStatus")
    Call<Order> checkTransactionStatus(@Field("order_gateway_id") String orderId);

    @GET("products")
    Call<List<Product>> getProducts();

    @POST("prepareOrder")
    Call<PrepareOrderResponse> prepareOrder(@Body PrepareOrderRequest request);

    @GET("transactions")
    Call<List<Transaction>> getTransactions();
}
