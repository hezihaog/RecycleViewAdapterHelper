package com.hzh.recycle.view.adapter.helper.sample.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.hzh.recycle.view.adapter.helper.sample.util.FragmentFactory;
import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.ui.fragment.DashboardFragment;
import com.hzh.recycle.view.adapter.helper.sample.ui.fragment.HomeFragment;
import com.hzh.recycle.view.adapter.helper.sample.ui.fragment.NotificationsFragment;
import com.hzh.recycle.view.adapter.helper.sample.ui.fragment.ShoppingCartFragment;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_BUNDLE_POSITION = "key_position";
    private ViewPager pager;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        pager.setOffscreenPageLimit(bottomNavigation.getMenu().size());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Bundle args = new Bundle();
                args.putString(KEY_BUNDLE_POSITION, String.valueOf(position));
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        //首个Fragment不需要懒加载，后续的则需要
                        fragment = FragmentFactory.newInstance(getApplicationContext(), HomeFragment.class, args);
                        break;
                    case 1:
                        fragment = FragmentFactory.newInstance(getApplicationContext(), DashboardFragment.class, args);
                        break;
                    case 2:
                        fragment = FragmentFactory.newInstance(getApplicationContext(), NotificationsFragment.class, args);
                        break;
                    case 3:
                        fragment = FragmentFactory.newInstance(getApplicationContext(), ShoppingCartFragment.class, args);
                        break;
                }
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() {
                return bottomNavigation.getMenu().size();
            }
        });
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        pager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_dashboard:
                        pager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_notifications:
                        pager.setCurrentItem(2);
                        return true;
                    case R.id.navigation_shopping_cart:
                        pager.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigation.setSelectedItemId(bottomNavigation.getMenu().getItem(position).getItemId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigation.setSelectedItemId(bottomNavigation.getMenu().getItem(0).getItemId());
    }
}
