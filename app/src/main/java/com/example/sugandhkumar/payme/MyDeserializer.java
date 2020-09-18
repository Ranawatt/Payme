package com.example.sugandhkumar.payme;

import com.example.sugandhkumar.payme.model.Flipkart;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by sugandh kumar on 11-02-2018.
 */

public class MyDeserializer implements JsonDeserializer<Flipkart> {
    @Override
    public Flipkart deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Flipkart flipkart = new Gson().fromJson(json,Flipkart.class);
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.has("apiGroups")){
            JsonObject apiGroupsObject = jsonObject.getAsJsonObject("apiGroups");
            if (apiGroupsObject.has("affiliate")){
                JsonObject affiliateObject = apiGroupsObject.getAsJsonObject("affiliate");
                if (affiliateObject.has("apiListings")){
                    JsonObject apiListingsObject = affiliateObject.getAsJsonObject("apiListings");
                }
            }
        }
        return flipkart;
    }
}
