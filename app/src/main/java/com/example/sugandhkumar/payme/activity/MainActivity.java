package com.example.sugandhkumar.payme.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;

import com.example.sugandhkumar.payme.GetLocationActivity;
import com.example.sugandhkumar.payme.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sugandhkumar.payme.Callback;
import com.example.sugandhkumar.payme.KitchenHome;
import com.example.sugandhkumar.payme.LoginActivity;
import com.example.sugandhkumar.payme.Main2Activity;
import com.example.sugandhkumar.payme.Main4Activity;
import com.example.sugandhkumar.payme.Main5Activity;
import com.example.sugandhkumar.payme.Main6Activity;
import com.example.sugandhkumar.payme.MovieSongs;
import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.activity.hotels.HotelsActivity;
import com.example.sugandhkumar.payme.adapter.MainPagerAdapter;
import com.example.sugandhkumar.payme.adapter.NavMenuAdapter;
import com.example.sugandhkumar.payme.fragment.DthrechargeFragment;
import com.example.sugandhkumar.payme.fragment.ElectricityFragment;
import com.example.sugandhkumar.payme.fragment.MobrechargeFragment;
import com.example.sugandhkumar.payme.fragment.WaterchargeFragment;
import com.example.sugandhkumar.payme.helper.BottomNavigationViewHelper;
import com.example.sugandhkumar.payme.model.Navmenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

import static androidx.viewpager2.widget.ViewPager2.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,Callback {
    public static final String TAG = MainActivity.class.getSimpleName();
    final Context context = this;
    private FirebaseAuth auth;
    private BottomNavigationView mBottomNavigationView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter navAdapter;
    private DatabaseReference mDatabase;
    private List<Navmenu> navmenuList;
    MenuItem prevMenuItem;


    private LinearLayout free_orders;
    private ImageView img_delivery;

    String payeeAddress = "8266874892@upi";
    String payeeName = "Sugandh Kumar";
    String transactionNote = "Test for Deeplinking";
    String amount = "10";
    String currencyUnit = "INR";
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        setUpViewPager(mBinding.paymeMainViewpager);

        if (!isNetworkAvailable(this)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Are you offline?");
            alertDialogBuilder
                    .setMessage("Couldn't connect to the internet.Connect to the mobile data or WiFi and try again")
                    .setCancelable(false)
                    .setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            isNetworkAvailable(context);
                        }
                    })
                    .setNegativeButton("SETTINGS", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent dialogIntent = new Intent(Settings.ACTION_SETTINGS);
                            dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(dialogIntent);
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Created by Sugandh Ranawatt    Copyright © 2016", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        changeStatusBarColor();

        mDatabase = FirebaseDatabase.getInstance().getReference("category");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Navmenu navmenu = postSnapshot.getValue(Navmenu.class);
                    navmenuList.add(navmenu);
                }

                navAdapter = new NavMenuAdapter(getApplicationContext(),navmenuList,onClickListener);
                mRecyclerView.setAdapter(navAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(MainActivity.this,"Unable to load the data",Toast.LENGTH_LONG).show();
            }
        });
//        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Pangram-Medium.otf");
//        tv_orders.setTypeface(typeface);
        if (getIntent().getExtras() != null) {

            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);

                if (key.equals("Main6Activity") && value.equals("True")) {
                    Intent intent = new Intent(this, Main6Activity.class);
                    intent.putExtra("value", value);
                    startActivity(intent);
//                    finish();
                }
            }
        }
        subscribeToPushService();
    }

    private void setUpViewPager(ViewPager2 paymeMainViewpager) {
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());

        MobrechargeFragment mobrechargeFragment = new MobrechargeFragment();
        ElectricityFragment electricityFragment = new ElectricityFragment();
        DthrechargeFragment dthrechargeFragment = new DthrechargeFragment();
        WaterchargeFragment waterchargeFragment = new WaterchargeFragment();

        adapter.addFragment(mobrechargeFragment);
        adapter.addFragment(electricityFragment);
        adapter.addFragment(dthrechargeFragment);
        adapter.addFragment(waterchargeFragment);
        paymeMainViewpager.setAdapter(navAdapter);
    }

    public void processToPayments() {

        Uri uri = Uri.parse("upi://pay?pa="+payeeAddress+"&pn="+payeeName+"&tn="+transactionNote+
                "&am="+amount+"&cu="+currencyUnit);
        Log.d(TAG, "onClick: uri: "+uri);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if(isIntentSafe)
            startActivityForResult(intent,1);
        else
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=in.org.npci.upiapp&hl=en"));
            startActivity(intent);
    }

    private void subscribeToPushService() {
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        String token = FirebaseInstanceId.getInstance().getToken();
        // Log and toast
        Log.d("PayMeToken", token);
        Log.d("PayMe", "Subscribed");
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorAccent));
        }
    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_navmenu);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        navmenuList = new ArrayList<>();

        mBinding.paymeOrders.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main6Activity.class));
            }
        });
        mBinding.paymeMainViewpager.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {

            }

            @Override
            public void onViewDetachedFromWindow(View v) {

            }
        });

        mBinding.paymeMainViewpager.registerOnPageChangeCallback(new OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "On PageSelected: " + position);
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mBottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMan.getActiveNetworkInfo() != null && conMan.getActiveNetworkInfo().isConnected())
            return true;
        else
            return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode: " + requestCode);
        Log.d(TAG, "onActivityResult: resultCode: " + resultCode);
        //txnId=UPI20b6226edaef4c139ed7cc38710095a3&responseCode=00&ApprovalRefNo=null&Status=SUCCESS&txnRef=undefined
        //txnId=UPI608f070ee644467aa78d1ccf5c9ce39b&responseCode=ZM&ApprovalRefNo=null&Status=FAILURE&txnRef=undefined
        if (data != null) {
            Log.d(TAG, "onActivityResult: data: " + data.getStringExtra("response"));
            String res = data.getStringExtra("response");
            String search = "SUCCESS";
            if (res.toLowerCase().contains(search.toLowerCase())) {
                Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onBackPressed() {

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Confirm Exit");
            alertDialogBuilder
                    .setMessage("Click yes to exit")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchViewAndroidActionBar.clearFocus();
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        item.collapseActionView();
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search)
            return  true;
        if (id == R.id.action_settings)
            startActivity(new Intent(Settings.ACTION_SETTINGS));
        if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("Text/html");
            intent.putExtra(Intent.EXTRA_TEXT, "sugandh");
            startActivity(intent.createChooser(intent, "Select anyone"));
        }
        if (id == R.id.nav_camera) {
            startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
        }
        if (id == R.id.action_about){
            aboutDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.recharge) {
            // Handle the camera action
        } else if (id == R.id.hotels) {
            startActivity( new Intent(MainActivity.this, IntroductionActivity.class));
        } else if (id == R.id.mobile) {
            startActivity(new Intent(MainActivity.this, Main4Activity.class));
        } else if (id == R.id.electronics) {
            startActivity(new Intent(MainActivity.this, Main5Activity.class));
        } else if (id == R.id.fashion) {
            startActivity(new Intent(MainActivity.this, Main6Activity.class));
        } else if (id == R.id.wfashion) {
        } else if (id == R.id.baby) {
            startActivity(new Intent(MainActivity.this, GetLocationActivity.class));
        } else if (id == R.id.home) {
            startActivity(new Intent(MainActivity.this, KitchenHome.class));
        } else if (id == R.id.deals) {
            startActivity(new Intent(MainActivity.this, FlipkartActivity.class));
        } else if (id == R.id.sports) {
            Intent intent = new Intent(MainActivity.this, UploadActivity.class);
            startActivity(intent);
        } else if (id == R.id.gifts) {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        } else if (id == R.id.bus) {
            startActivity(new Intent(MainActivity.this, HotelsActivity.class));
        } else if (id == R.id.movies) {
            startActivity(new Intent(MainActivity.this, MovieSongs.class));
        } else if(id == R.id.navsign_out){
            auth.signOut();
            Toast.makeText(getApplicationContext(),"SignedOut Successfully",Toast.LENGTH_SHORT).show();
            startActivity( new Intent(MainActivity.this,LoginActivity.class));
        } else  if (id == R.id.nav_send) {
            Intent intent = new Intent(Intent.ACTION_ALL_APPS);
            intent.setType("Text/html");
            intent.putExtra(Intent.EXTRA_TEXT, "sugandh");
            startActivity(intent.createChooser(intent, "click pic"));
        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void setUpViewPager(ViewPager2 viewPager){

//        viewPager.setAdapter(adapter);
//    }

    @SuppressLint("RestrictedApi")
    private void aboutDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Pay Me");
        final WebView webView = new WebView(this);
        String about = "<p>1.1</p>" +
                "<p>A lightweight, opensource instant payment app.</p>" +
                "<p>Developed by <a href='mailto:sugandhpatna95@gmail.com'>Sugandh Ranawatt</a></p>" +
                "<p>Data provided by <a href='http://firebase.org/'>Fire Base</a>, under the <a href='http://creativecommons.org/licenses/by-sa/2.0/'>Creative Commons license</a>" +
                "<p>Every Icons are <a href='https://www.github.com/Ranawatt/'>Designed Icons</a>, by <a href='http://www.twitter.com/artill'>Lukas Bischoff</a> " +
                "and <a href='http://www.twitter.com/Erik_UX'>Erik Flowers</a>, under the <a href='http://scripts.sil.org/OFL'>SIL OFL 1.1</a> licence.";
        TypedArray ta = obtainStyledAttributes(new int[]{android.R.attr.textColorPrimary, R.attr.colorAccent});
        String textColor = String.format("#%06X", (0xFFFFFF & ta.getColor(0, Color.BLACK)));
        String accentColor = String.format("#%06X", (0xFFFFFF & ta.getColor(1, Color.BLUE)));
        ta.recycle();
        about = "<style media=\"screen\" type=\"text/css\">" +
                "body {\n" +
                "    color:" + textColor + ";\n" +
                "}\n" +
                "a:link {color:" + accentColor + "}\n" +
                "</style>" +
                about;
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.loadData(about, "text/html", "UTF-8");
        alert.setView(webView, 32, 0, 32, 0);
        alert.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        alert.show();
    }

    private NavMenuAdapter.OnClickListener onClickListener = new NavMenuAdapter.OnClickListener(){

        @Override
        public void onClick(Navmenu navmenu) {

            String name = navmenu.getNavName();
            if(name.equals("MEN")){
                startActivity(new Intent(MainActivity.this,Main6Activity.class));
            }else if (name.equals("WOMEN")){
            }else if (name.equals("BEAUTY")){
                startActivity(new Intent(MainActivity.this,Main4Activity.class));
            }else if (name.equals("KIDS")){
                startActivity(new Intent(MainActivity.this,KitchenHome.class));
            }else if (name.equals("HOME")){
                startActivity(new Intent(MainActivity.this,HotelsActivity.class));
            }else if (name.equals("MUSIC")){
                startActivity(new Intent(MainActivity.this,MovieSongs.class));
            }
        }
    };
}
