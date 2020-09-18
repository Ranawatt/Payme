package com.example.sugandhkumar.payme.fragment.flipkartfragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sugandhkumar.payme.DataFetcher;
import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.adapter.flipkart.FoodNutritionAdapter;
import com.example.sugandhkumar.payme.model.Affiliate;
import com.example.sugandhkumar.payme.model.ApiGroups;
import com.example.sugandhkumar.payme.model.ApiListings;
import com.example.sugandhkumar.payme.model.Flipkart;
import com.example.sugandhkumar.payme.model.FoodNutrition;
import com.example.sugandhkumar.payme.model.flipkartinfo.ProductInfoList;
import com.example.sugandhkumar.payme.network.API;
import com.example.sugandhkumar.payme.network.RestClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sugandh kumar on 13-02-2018.
 */

public class FoodNutritionFragment extends Fragment {

    private RecyclerView rvList;
    private FoodNutritionAdapter fnAdapter;
    private FoodNutrition foodNutrition;
    private ArrayList<ProductInfoList> productLists;
    private static boolean isFirstFetchDone;
    public FoodNutritionFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFlipkartDataDetails();
//        if (getArguments() != null) {
//            String data = getArguments().getString("FOOD");
//            DataFetcher.getTelevisionDataDetails(data);
//        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        if (savedInstanceState != null){
//            productLists = (ArrayList<ProductInfoList>) savedInstanceState.get("productsList");
//        };
        View eView = inflater.inflate(R.layout.fragment_list,container,false);
        initView(eView);
        return eView;
    }

    private void initView(View eView) {
        productLists = DataFetcher.getmLists();
        rvList = (RecyclerView) eView.findViewById(R.id.rvList);
        fnAdapter = new FoodNutritionAdapter(getContext(),productLists,onClickListener);

        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvList.setHasFixedSize(true);
        rvList.setAdapter(fnAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        getFlipkartDataDetails();
        fnAdapter.notifyDataSetChanged();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !isFirstFetchDone) {
//            processGroupsList();
            isFirstFetchDone = true;
        }
    }
    private FoodNutritionAdapter.OnClickListener onClickListener = new FoodNutritionAdapter.OnClickListener() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }
    };


//    @Override
//    public void onSaveInstanceState(Bundle currentState){
//        currentState.putString("productList", String.valueOf((ArrayList<ProductInfoList>) productLists));
//    };

    public  void getFlipkartDataDetails(){
        API apiService = RestClient.getClient().create(API.class);
        final Call<Flipkart> flipkartCall = apiService.getFlipkartDetails();

        flipkartCall.enqueue(new Callback<Flipkart>() {
            @Override
            public void onResponse(Call<Flipkart> call, Response<Flipkart> response) {
                Flipkart flipkart = response.body();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonStr = gson.toJson(flipkart);
                Log.d("FlipkartActivity.this",jsonStr);
                System.out.print(jsonStr);
                ApiGroups apiGroups = flipkart.getApiGroups();
                System.out.print(apiGroups);
                Affiliate affiliate = apiGroups.getAffiliate();
                ApiListings apiListings = affiliate.getApiListings();
                foodNutrition = apiListings.getFoodNutrition();
                String dataFlip = foodNutrition.getAvailableVariants().getV010().getGet();
                DataFetcher.getTelevisionDataDetails(dataFlip);

            }
            @Override
            public void onFailure(Call<Flipkart> call, Throwable t) {

            }
        });
    }
}
