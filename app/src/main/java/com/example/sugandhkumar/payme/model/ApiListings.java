
package com.example.sugandhkumar.payme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiListings {

    @SerializedName("food_nutrition")
    @Expose
    private FoodNutrition foodNutrition;
    @SerializedName("televisions")
    @Expose
    private Televisions televisions;
    @SerializedName("landline_phones")
    @Expose
    private LandlinePhones landlinePhones;
    @SerializedName("tv_video_accessories")
    @Expose
    private TvVideoAccessories tvVideoAccessories;

    public ELearning geteLearning() {
        return eLearning;
    }

    public void seteLearning(ELearning eLearning) {
        this.eLearning = eLearning;
    }

    @SerializedName("software")

    @Expose
    private Software software;
    @SerializedName("computer_storage")
    @Expose
    private ComputerStorage computerStorage;
    @SerializedName("fragrances")
    @Expose
    private Fragrances fragrances;
    @SerializedName("network_components")
    @Expose
    private NetworkComponents networkComponents;
    @SerializedName("e_learning")
    @Expose
    private ELearning eLearning;
    @SerializedName("video_players")
    @Expose
    private VideoPlayers videoPlayers;
    @SerializedName("mens_clothing")
    @Expose
    private MensClothing mensClothing;
    @SerializedName("music_movies_posters")
    @Expose
    private MusicMoviesPosters musicMoviesPosters;
    @SerializedName("furniture")
    @Expose
    private Furniture furniture;
    @SerializedName("bags_wallets_belts")
    @Expose
    private BagsWalletsBelts bagsWalletsBelts;
    @SerializedName("mobiles")
    @Expose
    private Mobiles mobiles;
    @SerializedName("kids_clothing")
    @Expose
    private KidsClothing kidsClothing;
    @SerializedName("kids_footwear")
    @Expose
    private KidsFootwear kidsFootwear;
    @SerializedName("pet_supplies")
    @Expose
    private PetSupplies petSupplies;
    @SerializedName("mens_footwear")
    @Expose
    private MensFootwear mensFootwear;
    @SerializedName("air_coolers")
    @Expose
    private AirCoolers airCoolers;
    @SerializedName("home_entertainment")
    @Expose
    private HomeEntertainment homeEntertainment;
    @SerializedName("watches")
    @Expose
    private Watches watches;
    @SerializedName("sunglasses")
    @Expose
    private Sunglasses sunglasses;
    @SerializedName("eyewear")
    @Expose
    private Eyewear eyewear;
    @SerializedName("computer_components")
    @Expose
    private ComputerComponents computerComponents;
    @SerializedName("laptop_accessories")
    @Expose
    private LaptopAccessories laptopAccessories;
    @SerializedName("womens_clothing")
    @Expose
    private WomensClothing womensClothing;
    @SerializedName("mobile_accessories")
    @Expose
    private MobileAccessories mobileAccessories;
    @SerializedName("camera_accessories")
    @Expose
    private CameraAccessories cameraAccessories;
    @SerializedName("air_conditioners")
    @Expose
    private AirConditioners airConditioners;
    @SerializedName("luggage_travel")
    @Expose
    private LuggageTravel luggageTravel;
    @SerializedName("automotive")
    @Expose
    private Automotive automotive;
    @SerializedName("tablets")
    @Expose
    private Tablets tablets;
    @SerializedName("refrigerator")
    @Expose
    private Refrigerator refrigerator;
    @SerializedName("home_improvement_tools")
    @Expose
    private HomeImprovementTools homeImprovementTools;
    @SerializedName("computer_peripherals")
    @Expose
    private ComputerPeripherals computerPeripherals;
    @SerializedName("stationery_office_supplies")
    @Expose
    private StationeryOfficeSupplies stationeryOfficeSupplies;
    @SerializedName("sports_fitness")
    @Expose
    private SportsFitness sportsFitness;
    @SerializedName("baby_care")
    @Expose
    private BabyCare babyCare;
    @SerializedName("cameras")
    @Expose
    private Cameras cameras;
    @SerializedName("wearable_smart_devices")
    @Expose
    private WearableSmartDevices wearableSmartDevices;
    @SerializedName("audio_players")
    @Expose
    private AudioPlayers audioPlayers;
    @SerializedName("grooming_beauty_wellness")
    @Expose
    private GroomingBeautyWellness groomingBeautyWellness;
    @SerializedName("tablet_accessories")
    @Expose
    private TabletAccessories tabletAccessories;
    @SerializedName("kitchen_appliances")
    @Expose
    private KitchenAppliances kitchenAppliances;
    @SerializedName("microwave_ovens")
    @Expose
    private MicrowaveOvens microwaveOvens;
    @SerializedName("laptops")
    @Expose
    private Laptops laptops;
    @SerializedName("washing_machine")
    @Expose
    private WashingMachine washingMachine;
    @SerializedName("gaming")
    @Expose
    private Gaming gaming;
    @SerializedName("toys")
    @Expose
    private Toys toys;
    @SerializedName("home_appliances")
    @Expose
    private HomeAppliances homeAppliances;
    @SerializedName("home_decor_and_festive_needs")
    @Expose
    private HomeDecorAndFestiveNeeds homeDecorAndFestiveNeeds;
    @SerializedName("home_and_kitchen_needs")
    @Expose
    private HomeAndKitchenNeeds homeAndKitchenNeeds;
    @SerializedName("jewellery")
    @Expose
    private Jewellery jewellery;
    @SerializedName("home_furnishing")
    @Expose
    private HomeFurnishing homeFurnishing;
    @SerializedName("desktops")
    @Expose
    private Desktops desktops;
    @SerializedName("womens_footwear")
    @Expose
    private WomensFootwear womensFootwear;
    @SerializedName("household_supplies")
    @Expose
    private HouseholdSupplies householdSupplies;
    /**
     * No args constructor for use in serialization
     */
    public ApiListings() {}
    /**
     * @param fragrances
     * @param sportsFitness
     * @param videoPlayers
     * @param airConditioners
     * @param furniture
     * @param audioPlayers
     * @param automotive
     * @param software
     * @param jewellery
     * @param computerStorage
     * @param computerPeripherals
     * @param tabletAccessories
     * @param homeEntertainment
     * @param televisions
     * @param householdSupplies
     * @param laptopAccessories
     * @param homeFurnishing
     * @param tablets
     * @param landlinePhones
     * @param womensClothing
     * @param sunglasses
     * @param homeImprovementTools
     * @param stationeryOfficeSupplies
     * @param musicMoviesPosters
     * @param homeDecorAndFestiveNeeds
     * @param homeAppliances
     * @param foodNutrition
     * @param mobileAccessories
     * @param desktops
     * @param gaming
     * @param kidsFootwear
     * @param tvVideoAccessories
     * @param petSupplies
     * @param womensFootwear
     * @param luggageTravel
     * @param wearableSmartDevices
     * @param homeAndKitchenNeeds
     * @param mobiles
     * @param microwaveOvens
     * @param mensFootwear
     * @param watches
     * @param computerComponents
     * @param cameras
     * @param washingMachine
     * @param babyCare
     * @param laptops
     * @param cameraAccessories
     * @param refrigerator
     * @param eLearning
     * @param kidsClothing
     * @param bagsWalletsBelts
     * @param groomingBeautyWellness
     * @param toys
     * @param kitchenAppliances
     * @param mensClothing
     * @param eyewear
     * @param airCoolers
     * @param networkComponents*/
    public ApiListings(FoodNutrition foodNutrition, Televisions televisions, LandlinePhones landlinePhones, TvVideoAccessories tvVideoAccessories, Software software, ComputerStorage computerStorage, Fragrances fragrances, NetworkComponents networkComponents, ELearning eLearning, VideoPlayers videoPlayers, MensClothing mensClothing, MusicMoviesPosters musicMoviesPosters, Furniture furniture, BagsWalletsBelts bagsWalletsBelts, Mobiles mobiles, KidsClothing kidsClothing, KidsFootwear kidsFootwear, PetSupplies petSupplies, MensFootwear mensFootwear, AirCoolers airCoolers, HomeEntertainment homeEntertainment, Watches watches, Sunglasses sunglasses, Eyewear eyewear, ComputerComponents computerComponents, LaptopAccessories laptopAccessories, WomensClothing womensClothing, MobileAccessories mobileAccessories, CameraAccessories cameraAccessories, AirConditioners airConditioners, LuggageTravel luggageTravel, Automotive automotive, Tablets tablets, Refrigerator refrigerator, HomeImprovementTools homeImprovementTools, ComputerPeripherals computerPeripherals, StationeryOfficeSupplies stationeryOfficeSupplies, SportsFitness sportsFitness, BabyCare babyCare, Cameras cameras, WearableSmartDevices wearableSmartDevices, AudioPlayers audioPlayers, GroomingBeautyWellness groomingBeautyWellness, TabletAccessories tabletAccessories, KitchenAppliances kitchenAppliances, MicrowaveOvens microwaveOvens, Laptops laptops, WashingMachine washingMachine, Gaming gaming, Toys toys, HomeAppliances homeAppliances, HomeDecorAndFestiveNeeds homeDecorAndFestiveNeeds, HomeAndKitchenNeeds homeAndKitchenNeeds, Jewellery jewellery, HomeFurnishing homeFurnishing, Desktops desktops, WomensFootwear womensFootwear, HouseholdSupplies householdSupplies) {
        super();
        this.foodNutrition = foodNutrition;
        this.televisions = televisions;
        this.landlinePhones = landlinePhones;
        this.tvVideoAccessories = tvVideoAccessories;
        this.software = software;
        this.computerStorage = computerStorage;
        this.fragrances = fragrances;
        this.networkComponents = networkComponents;
        this.eLearning = eLearning;
        this.videoPlayers = videoPlayers;
        this.mensClothing = mensClothing;
        this.musicMoviesPosters = musicMoviesPosters;
        this.furniture = furniture;
        this.bagsWalletsBelts = bagsWalletsBelts;
        this.mobiles = mobiles;
        this.kidsClothing = kidsClothing;
        this.kidsFootwear = kidsFootwear;
        this.petSupplies = petSupplies;
        this.mensFootwear = mensFootwear;
        this.airCoolers = airCoolers;
        this.homeEntertainment = homeEntertainment;
        this.watches = watches;
        this.sunglasses = sunglasses;
        this.eyewear = eyewear;
        this.computerComponents = computerComponents;
        this.laptopAccessories = laptopAccessories;
        this.womensClothing = womensClothing;
        this.mobileAccessories = mobileAccessories;
        this.cameraAccessories = cameraAccessories;
        this.airConditioners = airConditioners;
        this.luggageTravel = luggageTravel;
        this.automotive = automotive;
        this.tablets = tablets;
        this.refrigerator = refrigerator;
        this.homeImprovementTools = homeImprovementTools;
        this.computerPeripherals = computerPeripherals;
        this.stationeryOfficeSupplies = stationeryOfficeSupplies;
        this.sportsFitness = sportsFitness;
        this.babyCare = babyCare;
        this.cameras = cameras;
        this.wearableSmartDevices = wearableSmartDevices;
        this.audioPlayers = audioPlayers;
        this.groomingBeautyWellness = groomingBeautyWellness;
        this.tabletAccessories = tabletAccessories;
        this.kitchenAppliances = kitchenAppliances;
        this.microwaveOvens = microwaveOvens;
        this.laptops = laptops;
        this.washingMachine = washingMachine;
        this.gaming = gaming;
        this.toys = toys;
        this.homeAppliances = homeAppliances;
        this.homeDecorAndFestiveNeeds = homeDecorAndFestiveNeeds;
        this.homeAndKitchenNeeds = homeAndKitchenNeeds;
        this.jewellery = jewellery;
        this.homeFurnishing = homeFurnishing;
        this.desktops = desktops;
        this.womensFootwear = womensFootwear;
        this.householdSupplies = householdSupplies;
    }

    public FoodNutrition getFoodNutrition() {
        return foodNutrition;
    }

    public void setFoodNutrition(FoodNutrition foodNutrition) {
        this.foodNutrition = foodNutrition;
    }

    public Televisions getTelevisions() {
        return televisions;
    }

    public void setTelevisions(Televisions televisions) {
        this.televisions = televisions;
    }

    public LandlinePhones getLandlinePhones() {
        return landlinePhones;
    }

    public void setLandlinePhones(LandlinePhones landlinePhones) {
        this.landlinePhones = landlinePhones;
    }

    public TvVideoAccessories getTvVideoAccessories() {
        return tvVideoAccessories;
    }

    public void setTvVideoAccessories(TvVideoAccessories tvVideoAccessories) {
        this.tvVideoAccessories = tvVideoAccessories;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public ComputerStorage getComputerStorage() {
        return computerStorage;
    }

    public void setComputerStorage(ComputerStorage computerStorage) {
        this.computerStorage = computerStorage;
    }

    public Fragrances getFragrances() {
        return fragrances;
    }

    public void setFragrances(Fragrances fragrances) {
        this.fragrances = fragrances;
    }

    public NetworkComponents getNetworkComponents() {
        return networkComponents;
    }

    public void setNetworkComponents(NetworkComponents networkComponents) {
        this.networkComponents = networkComponents;
    }

    public ELearning getELearning() {
        return eLearning;
    }

    public void setELearning(ELearning eLearning) {
        this.eLearning = eLearning;
    }

    public VideoPlayers getVideoPlayers() {
        return videoPlayers;
    }

    public void setVideoPlayers(VideoPlayers videoPlayers) {
        this.videoPlayers = videoPlayers;
    }

    public MensClothing getMensClothing() {
        return mensClothing;
    }

    public void setMensClothing(MensClothing mensClothing) {
        this.mensClothing = mensClothing;
    }

    public MusicMoviesPosters getMusicMoviesPosters() {
        return musicMoviesPosters;
    }

    public void setMusicMoviesPosters(MusicMoviesPosters musicMoviesPosters) {
        this.musicMoviesPosters = musicMoviesPosters;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public BagsWalletsBelts getBagsWalletsBelts() {
        return bagsWalletsBelts;
    }

    public void setBagsWalletsBelts(BagsWalletsBelts bagsWalletsBelts) {
        this.bagsWalletsBelts = bagsWalletsBelts;
    }

    public Mobiles getMobiles() {
        return mobiles;
    }

    public void setMobiles(Mobiles mobiles) {
        this.mobiles = mobiles;
    }

    public KidsClothing getKidsClothing() {
        return kidsClothing;
    }

    public void setKidsClothing(KidsClothing kidsClothing) {
        this.kidsClothing = kidsClothing;
    }

    public KidsFootwear getKidsFootwear() {
        return kidsFootwear;
    }

    public void setKidsFootwear(KidsFootwear kidsFootwear) {
        this.kidsFootwear = kidsFootwear;
    }

    public PetSupplies getPetSupplies() {
        return petSupplies;
    }

    public void setPetSupplies(PetSupplies petSupplies) {
        this.petSupplies = petSupplies;
    }

    public MensFootwear getMensFootwear() {
        return mensFootwear;
    }

    public void setMensFootwear(MensFootwear mensFootwear) {
        this.mensFootwear = mensFootwear;
    }

    public AirCoolers getAirCoolers() {
        return airCoolers;
    }

    public void setAirCoolers(AirCoolers airCoolers) {
        this.airCoolers = airCoolers;
    }

    public HomeEntertainment getHomeEntertainment() {
        return homeEntertainment;
    }

    public void setHomeEntertainment(HomeEntertainment homeEntertainment) {
        this.homeEntertainment = homeEntertainment;
    }

    public Watches getWatches() {
        return watches;
    }

    public void setWatches(Watches watches) {
        this.watches = watches;
    }

    public Sunglasses getSunglasses() {
        return sunglasses;
    }

    public void setSunglasses(Sunglasses sunglasses) {
        this.sunglasses = sunglasses;
    }

    public Eyewear getEyewear() {
        return eyewear;
    }

    public void setEyewear(Eyewear eyewear) {
        this.eyewear = eyewear;
    }

    public ComputerComponents getComputerComponents() {
        return computerComponents;
    }

    public void setComputerComponents(ComputerComponents computerComponents) {
        this.computerComponents = computerComponents;
    }

    public LaptopAccessories getLaptopAccessories() {
        return laptopAccessories;
    }

    public void setLaptopAccessories(LaptopAccessories laptopAccessories) {
        this.laptopAccessories = laptopAccessories;
    }

    public WomensClothing getWomensClothing() {
        return womensClothing;
    }

    public void setWomensClothing(WomensClothing womensClothing) {
        this.womensClothing = womensClothing;
    }

    public MobileAccessories getMobileAccessories() {
        return mobileAccessories;
    }

    public void setMobileAccessories(MobileAccessories mobileAccessories) {
        this.mobileAccessories = mobileAccessories;
    }

    public CameraAccessories getCameraAccessories() {
        return cameraAccessories;
    }

    public void setCameraAccessories(CameraAccessories cameraAccessories) {
        this.cameraAccessories = cameraAccessories;
    }

    public AirConditioners getAirConditioners() {
        return airConditioners;
    }

    public void setAirConditioners(AirConditioners airConditioners) {
        this.airConditioners = airConditioners;
    }

    public LuggageTravel getLuggageTravel() {
        return luggageTravel;
    }

    public void setLuggageTravel(LuggageTravel luggageTravel) {
        this.luggageTravel = luggageTravel;
    }

    public Automotive getAutomotive() {
        return automotive;
    }

    public void setAutomotive(Automotive automotive) {
        this.automotive = automotive;
    }

    public Tablets getTablets() {
        return tablets;
    }

    public void setTablets(Tablets tablets) {
        this.tablets = tablets;
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    public HomeImprovementTools getHomeImprovementTools() {
        return homeImprovementTools;
    }

    public void setHomeImprovementTools(HomeImprovementTools homeImprovementTools) {
        this.homeImprovementTools = homeImprovementTools;
    }

    public ComputerPeripherals getComputerPeripherals() {
        return computerPeripherals;
    }

    public void setComputerPeripherals(ComputerPeripherals computerPeripherals) {
        this.computerPeripherals = computerPeripherals;
    }

    public StationeryOfficeSupplies getStationeryOfficeSupplies() {
        return stationeryOfficeSupplies;
    }

    public void setStationeryOfficeSupplies(StationeryOfficeSupplies stationeryOfficeSupplies) {
        this.stationeryOfficeSupplies = stationeryOfficeSupplies;
    }

    public SportsFitness getSportsFitness() {
        return sportsFitness;
    }

    public void setSportsFitness(SportsFitness sportsFitness) {
        this.sportsFitness = sportsFitness;
    }

    public BabyCare getBabyCare() {
        return babyCare;
    }

    public void setBabyCare(BabyCare babyCare) {
        this.babyCare = babyCare;
    }

    public Cameras getCameras() {
        return cameras;
    }

    public void setCameras(Cameras cameras) {
        this.cameras = cameras;
    }

    public WearableSmartDevices getWearableSmartDevices() {
        return wearableSmartDevices;
    }

    public void setWearableSmartDevices(WearableSmartDevices wearableSmartDevices) {
        this.wearableSmartDevices = wearableSmartDevices;
    }

    public AudioPlayers getAudioPlayers() {
        return audioPlayers;
    }

    public void setAudioPlayers(AudioPlayers audioPlayers) {
        this.audioPlayers = audioPlayers;
    }

    public GroomingBeautyWellness getGroomingBeautyWellness() {
        return groomingBeautyWellness;
    }

    public void setGroomingBeautyWellness(GroomingBeautyWellness groomingBeautyWellness) {
        this.groomingBeautyWellness = groomingBeautyWellness;
    }

    public TabletAccessories getTabletAccessories() {
        return tabletAccessories;
    }

    public void setTabletAccessories(TabletAccessories tabletAccessories) {
        this.tabletAccessories = tabletAccessories;
    }

    public KitchenAppliances getKitchenAppliances() {
        return kitchenAppliances;
    }

    public void setKitchenAppliances(KitchenAppliances kitchenAppliances) {
        this.kitchenAppliances = kitchenAppliances;
    }

    public MicrowaveOvens getMicrowaveOvens() {
        return microwaveOvens;
    }

    public void setMicrowaveOvens(MicrowaveOvens microwaveOvens) {
        this.microwaveOvens = microwaveOvens;
    }

    public Laptops getLaptops() {
        return laptops;
    }

    public void setLaptops(Laptops laptops) {
        this.laptops = laptops;
    }

    public WashingMachine getWashingMachine() {
        return washingMachine;
    }

    public void setWashingMachine(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    public Gaming getGaming() {
        return gaming;
    }

    public void setGaming(Gaming gaming) {
        this.gaming = gaming;
    }

    public Toys getToys() {
        return toys;
    }

    public void setToys(Toys toys) {
        this.toys = toys;
    }

    public HomeAppliances getHomeAppliances() {
        return homeAppliances;
    }

    public void setHomeAppliances(HomeAppliances homeAppliances) {
        this.homeAppliances = homeAppliances;
    }

    public HomeDecorAndFestiveNeeds getHomeDecorAndFestiveNeeds() {
        return homeDecorAndFestiveNeeds;
    }

    public void setHomeDecorAndFestiveNeeds(HomeDecorAndFestiveNeeds homeDecorAndFestiveNeeds) {
        this.homeDecorAndFestiveNeeds = homeDecorAndFestiveNeeds;
    }

    public HomeAndKitchenNeeds getHomeAndKitchenNeeds() {
        return homeAndKitchenNeeds;
    }

    public void setHomeAndKitchenNeeds(HomeAndKitchenNeeds homeAndKitchenNeeds) {
        this.homeAndKitchenNeeds = homeAndKitchenNeeds;
    }

    public Jewellery getJewellery() {
        return jewellery;
    }

    public void setJewellery(Jewellery jewellery) {
        this.jewellery = jewellery;
    }

    public HomeFurnishing getHomeFurnishing() {
        return homeFurnishing;
    }

    public void setHomeFurnishing(HomeFurnishing homeFurnishing) {
        this.homeFurnishing = homeFurnishing;
    }

    public Desktops getDesktops() {
        return desktops;
    }

    public void setDesktops(Desktops desktops) {
        this.desktops = desktops;
    }

    public WomensFootwear getWomensFootwear() {
        return womensFootwear;
    }

    public void setWomensFootwear(WomensFootwear womensFootwear) {
        this.womensFootwear = womensFootwear;
    }

    public HouseholdSupplies getHouseholdSupplies() {
        return householdSupplies;
    }

    public void setHouseholdSupplies(HouseholdSupplies householdSupplies) {
        this.householdSupplies = householdSupplies;
    }
}
