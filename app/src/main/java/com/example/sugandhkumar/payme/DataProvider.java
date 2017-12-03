package com.example.sugandhkumar.payme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sugandh kumar on 20-07-2017.
 */

public class DataProvider {
    public static HashMap<String, List<String>> getInfo(){
        HashMap<String,List<String>> HeaderDetails = new HashMap<>();

        List<String> CasesDetails = new ArrayList<>();
        CasesDetails.add("Nylon Classic");
        HeaderDetails.put("Cases & Covers", CasesDetails);

        List<String> GuardDetails = new ArrayList<>();
        GuardDetails.add("Nokia Tempered");
        HeaderDetails.put("Screen Guards",GuardDetails);

        List<String> BatteryDetails = new ArrayList<>();
        BatteryDetails.add("Trustable");
        HeaderDetails.put("Chargers & Batteries",BatteryDetails);

        List<String> HolderDetails = new ArrayList<>();
        HolderDetails.add("Mobile Covers");
        HeaderDetails.put("Mobile Holder",HolderDetails);

        List<String> MobileDetails = new ArrayList<>();
        MobileDetails.add("Samsung Galaxy");
        MobileDetails.add("Micromax Canvas");
        MobileDetails.add("Nokia Lumia");
        MobileDetails.add("Blackberry");
        MobileDetails.add("Lenovo");
        MobileDetails.add("Oppo SmartCamera");
        MobileDetails.add("IPhone S8");
        HeaderDetails.put("Mobiles",MobileDetails);

        List<String> TabletDetails = new ArrayList<>();
        TabletDetails.add("Galaxy Note32");
        TabletDetails.add("Lenovo 3T 100");
        HeaderDetails.put("Tablets",TabletDetails);

        List<String> HeadPhoneDetails = new ArrayList<>();
        HeadPhoneDetails.add("Sony Classic 800");
        HeadPhoneDetails.add("Philips Phantom");
        HeadPhoneDetails.add("NuFox Music");
        HeaderDetails.put("HeadPhones & HeadSets", HeadPhoneDetails);

        List<String> PowerBankDetails = new ArrayList<>();
        PowerBankDetails.add("Sony Power 4000mh");
        PowerBankDetails.add("Philips Charger 200");
        HeaderDetails.put("PowerBanks",PowerBankDetails);

        return HeaderDetails;
    }
}
