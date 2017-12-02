package com.hzh.recycle.view.adapter.helper.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.hzh.lazy.fragment.ExtendLazyFragment;
import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.ui.activity.MainActivity;
import com.hzh.recycle.view.adapter.helper.sample.util.FragmentFactory;


/**
 * Package: com.hzh.recycle.view.adapter.helper.sample.ui.fragment
 * FileName: MainFragment
 * Date: on 2017/12/2  下午2:40
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class MainFragment extends ExtendLazyFragment {
    private ViewPager pager;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onLazyViewCreated(View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public View onInflaterRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onFindViews(View mRootView) {
        pager = (ViewPager) mRootView.findViewById(R.id.pager);
        bottomNavigation = (BottomNavigationView) mRootView.findViewById(R.id.bottomNavigation);
    }

    @Override
    public void onBindContent() {
        pager.setOffscreenPageLimit(bottomNavigation.getMenu().size());
        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Bundle args = new Bundle();
                args.putString(MainActivity.KEY_BUNDLE_POSITION, String.valueOf(position));
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        //首个Fragment不需要懒加载，后续的则需要
                        fragment = FragmentFactory.newInstance(getContext().getApplicationContext(), HomeFragment.class, args);
                        break;
                    case 1:
                        fragment = FragmentFactory.newInstance(getContext().getApplicationContext(), DashboardFragment.class, args);
                        break;
                    case 2:
                        fragment = FragmentFactory.newInstance(getContext().getApplicationContext(), NotificationsFragment.class, args);
                        break;
                    case 3:
                        fragment = FragmentFactory.newInstance(getContext().getApplicationContext(), ShoppingCartFragment.class, args);
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
