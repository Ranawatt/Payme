package com.example.sugandhkumar.payme.activity;

import android.content.Intent;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.adapter.FlipkartPagerAdapter;
import com.example.sugandhkumar.payme.fragment.flipkartfragment.BagWalletBeltsFragment;
import com.example.sugandhkumar.payme.fragment.flipkartfragment.FoodNutritionFragment;
import com.example.sugandhkumar.payme.fragment.flipkartfragment.KidsFootwearFragment;
import com.example.sugandhkumar.payme.fragment.flipkartfragment.MensFootwearFragment;
import com.example.sugandhkumar.payme.fragment.flipkartfragment.TelevisionFragment;

public class FlipkartActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Toolbar toolbar;

    private  FlipkartPagerAdapter mPager;
    private static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipkart);

        setCustomActionBar();
        initViews();
        setupViewPager(mViewPager);
        fragmentManager = getSupportFragmentManager();

    }

    private void setCustomActionBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setTitle("PayMe FlipKart");
    }

    private void setupViewPager(ViewPager mViewPager) {
        mPager = new FlipkartPagerAdapter(getSupportFragmentManager());
//        if (fragmentManager.getBackStackEntryCount() > 0) {
//            fragmentManager.popBackStack();
//        }
        mPager.addFrag(new FoodNutritionFragment(),"Food Nutrition");

        mPager.addFrag(new MensFootwearFragment(),"Mens FootWear");
        mPager.addFrag(new KidsFootwearFragment(),"Kids FootWear");
        mPager.addFrag(new BagWalletBeltsFragment(),"Bag WalletBelts");
        mPager.addFrag(new TelevisionFragment(),"Television");
        mViewPager.setAdapter(mPager);

    }

//    private void initPages() {   }

    private void initViews() {
        mTabLayout =(TabLayout) findViewById(R.id.t1Home);
        mViewPager =(ViewPager) findViewById(R.id.vpHome);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         mPager.getItem(mViewPager.getCurrentItem()).onActivityResult(requestCode, resultCode, data);
    }
}
