package com.example.dominos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        BestSellers bestSellers = new BestSellers();
        ChickenLoversPizza chickenLoversPizza = new ChickenLoversPizza();
        NewLaunches newLaunches = new NewLaunches();
        VegPizza vegPizza = new VegPizza();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(bestSellers, "BEST SELLERS");
        viewPagerAdapter.addFragment(chickenLoversPizza, "CHICKEN LOVERS PIZZA");
        viewPagerAdapter.addFragment(newLaunches, "NEW LAUNCHES");
        viewPagerAdapter.addFragment(vegPizza, "VEG PIZZA");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
class ViewPagerAdapter extends FragmentPagerAdapter{
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, int behaviour)
    {
        super(fm,behaviour);
    }
    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}