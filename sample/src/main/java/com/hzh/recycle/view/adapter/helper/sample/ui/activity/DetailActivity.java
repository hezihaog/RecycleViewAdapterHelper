package com.hzh.recycle.view.adapter.helper.sample.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.ui.fragment.DashboardFragment;
import com.hzh.recycle.view.adapter.helper.sample.util.FragmentFactory;
import com.hzh.slide.back.layout.SlideBackLayout;
import com.hzh.view.injector.ViewInjectorImpl;
import com.hzh.view.injector.anno.ContentView;
import com.hzh.view.injector.anno.ViewInject;


/**
 * Package: com.hzh.recycle.view.adapter.helper.sample.ui.activity
 * FileName: DetailActivity
 * Date: on 2017/12/2  上午11:20
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
@ContentView(R.layout.activity_detail)
public class DetailActivity extends AppCompatActivity {
    @ViewInject(R.id.container)
    public FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectorImpl.getInstance().inject(this);
        Bundle args = new Bundle();
        args.putString(MainActivity.KEY_BUNDLE_POSITION, String.valueOf(0));
        Fragment fragment = FragmentFactory.newInstance(getApplicationContext(), DashboardFragment.class, args);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment, fragment.getClass().getSimpleName())
                .commit();
        SlideBackLayout slideBackLayout = new SlideBackLayout(getApplicationContext());
        slideBackLayout.bind(this);
    }
}
