package com.hzh.recycle.view.adapter.helper.sample.ui.activity;

import android.os.Bundle;

import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.base.BaseActivity;
import com.hzh.recycle.view.adapter.helper.sample.ui.fragment.MainFragment;
import com.hzh.recycle.view.adapter.helper.sample.util.FragmentFactory;
import com.hzh.view.injector.anno.ContentView;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    public static final String KEY_BUNDLE_POSITION = "key_position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, FragmentFactory.newInstance(getApplicationContext(), MainFragment.class, null)
                        , MainFragment.class.getSimpleName())
                .commit();
    }
}
