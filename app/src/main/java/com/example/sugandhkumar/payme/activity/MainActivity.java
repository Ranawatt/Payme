package com.example.sugandhkumar.payme.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.sugandhkumar.payme.FlightDetails;
import com.example.sugandhkumar.payme.KitchenHome;
import com.example.sugandhkumar.payme.LoginActivity;
import com.example.sugandhkumar.payme.Main2Activity;
import com.example.sugandhkumar.payme.Main4Activity;
import com.example.sugandhkumar.payme.Main5Activity;
import com.example.sugandhkumar.payme.Main6Activity;
import com.example.sugandhkumar.payme.Main7Activity;
import com.example.sugandhkumar.payme.Main8Activity;
import com.example.sugandhkumar.payme.MovieSongs;
import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.activity.hotels.HotelsActivity;
import com.example.sugandhkumar.payme.adapter.MainPagerAdapter;
import com.example.sugandhkumar.payme.fragment.DthrechargeFragment;
import com.example.sugandhkumar.payme.fragment.ElectricityFragment;
import com.example.sugandhkumar.payme.fragment.MobrechargeFragment;
import com.example.sugandhkumar.payme.fragment.WaterchargeFragment;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final Context context = this;
    private FirebaseAuth auth;
    private BottomNavigationView mBottomNavigationView;
    private ViewPager mVpMain;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        initView();
        setUpViewPager(mVpMain);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (!isNetworkAvailable(this)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Are you offline?");
            alertDialogBuilder
                    .setMessage("Couldn't connect to the internet.Connect to the mobile data or WiFi and try again")
                    .setCancelable(false)
                    .setNegativeButton("TRY AGAIN", new DialogInterface.OnClickListener() {
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


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        changeStatusBarColor();
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(R.color.colorAccent);
        }
    }

    private void initView(){
        mVpMain = (ViewPager) findViewById(R.id.mVpMain);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mob_icon:
                        mVpMain.setCurrentItem(0);
                        break;
                    case R.id.electric_bill:
                        mVpMain.setCurrentItem(1);
                        break;
                    case R.id.dth_recharge:
                        mVpMain.setCurrentItem(2);
                        break;
                    case R.id.water_bill:
                        mVpMain.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(prevMenuItem!= null){
                    prevMenuItem.setChecked(false);
                }
                else{
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page","On PageSelected: "+ position);
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mBottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
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
        }
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
        if (id == R.id.action_search){
            return  true;
        }
        if (id == R.id.action_settings) {
            Intent i = new Intent(Settings.ACTION_SETTINGS);
            startActivity(i);
        }
        if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("Text/html");
            intent.putExtra(Intent.EXTRA_TEXT, "sugandh");
            startActivity(intent.createChooser(intent, "Select anyone"));
        }
        if (id == R.id.nav_camera) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(cameraIntent);
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
            Intent intent = new Intent(MainActivity.this, IntroductionActivity.class);
            startActivity(intent);

        } else if (id == R.id.mobile) {
            Intent intent = new Intent(MainActivity.this, Main4Activity.class);
            startActivity(intent);
        } else if (id == R.id.electronics) {
            Intent intent = new Intent(MainActivity.this, Main5Activity.class);
            startActivity(intent);
        } else if (id == R.id.fashion) {
            Intent intent = new Intent(MainActivity.this, Main6Activity.class);
            startActivity(intent);
        } else if (id == R.id.wfashion) {
            Intent intent = new Intent(MainActivity.this, Main7Activity.class);
            startActivity(intent);
        } else if (id == R.id.baby) {
            Intent intent = new Intent(MainActivity.this, Main8Activity.class);
            startActivity(intent);
        } else if (id == R.id.home) {
            Intent intent = new Intent(MainActivity.this, KitchenHome.class);
            startActivity(intent);
        } else if (id == R.id.deals) {
            Intent intent = new Intent(MainActivity.this, FlightDetails.class);
            startActivity(intent);
        } else if (id == R.id.sports) {
            Intent intent = new Intent(MainActivity.this, UploadActivity.class);
            startActivity(intent);
        } else if (id == R.id.gifts) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        } else if (id == R.id.bus) {
            Intent intent = new Intent(MainActivity.this, HotelsActivity.class);
            startActivity(intent);
        } else if (id == R.id.movies) {
            Intent intent = new Intent(MainActivity.this, MovieSongs.class);
            startActivity(intent);
        } else if(id == R.id.navsign_out){
            auth.signOut();
            Toast.makeText(getApplicationContext(),"SignedOut Successfully",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        } else  if (id == R.id.nav_send) {
            Intent intent = new Intent(Intent.ACTION_ALL_APPS);
            intent.setType("Text/html");
            intent.putExtra(Intent.EXTRA_TEXT, "sugandh");
            startActivity(intent.createChooser(intent, "click pic"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUpViewPager(ViewPager viewPager){
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());

        MobrechargeFragment mobrechargeFragment = new MobrechargeFragment();
        ElectricityFragment electricityFragment = new ElectricityFragment();
        DthrechargeFragment dthrechargeFragment = new DthrechargeFragment();
        WaterchargeFragment waterchargeFragment = new WaterchargeFragment();

        adapter.addFragment(mobrechargeFragment);
        adapter.addFragment(electricityFragment);
        adapter.addFragment(dthrechargeFragment);
        adapter.addFragment(waterchargeFragment);
        viewPager.setAdapter(adapter);
    }

    private void aboutDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Pay Me");
        final WebView webView = new WebView(this);
        String about = "<p>1.1</p>" +
                "<p>A lightweight, opensource instant payment app.</p>" +
                "<p>Developed by <a href='mailto:sugandhpatna95@gmail.com'>Sugandh Ranawatt</a></p>" +
                "<p>Data provided by <a href='http://firebase.org/'>Fire Base</a>, under the <a href='http://creativecommons.org/licenses/by-sa/2.0/'>Creative Commons license</a>" +
                "<p>Every Icons are <a href='https://www.github.com/Ranawatt/'>Designed Icons</a>, by <a href='http://www.twitter.com/artill'>Lukas Bischoff</a> and <a href='http://www.twitter.com/Erik_UX'>Erik Flowers</a>, under the <a href='http://scripts.sil.org/OFL'>SIL OFL 1.1</a> licence.";
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
}
