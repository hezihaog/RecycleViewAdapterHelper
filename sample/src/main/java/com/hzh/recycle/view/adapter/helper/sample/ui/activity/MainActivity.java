package com.hzh.recycle.view.adapter.helper.sample.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.ui.fragment.MainFragment;
import com.hzh.recycle.view.adapter.helper.sample.util.FragmentFactory;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_BUNDLE_POSITION = "key_position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, FragmentFactory.newInstance(getApplicationContext(), MainFragment.class, null)
                        , MainFragment.class.getSimpleName())
                .commit();
    }
}
