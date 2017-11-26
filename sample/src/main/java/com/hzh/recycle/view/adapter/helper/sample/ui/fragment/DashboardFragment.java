package com.hzh.recycle.view.adapter.helper.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hzh.lazy.fragment.ExtendLazyFragment;
import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.ui.activity.MainActivity;

/**
 * Package: com.hzh.lazy.fragment.sample.fragment
 * FileName: DashboardFramgent
 * Date: on 2017/11/24  上午11:47
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class DashboardFragment extends ExtendLazyFragment {
    private String position;
    private TextView tip;

    @Override
    public View onInflaterRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    protected void onLazyViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        position = arguments.getString(MainActivity.KEY_BUNDLE_POSITION);
    }

    @Override
    public void onFindViews(View mRootView) {
        tip = mRootView.findViewById(R.id.tip);
    }

    @Override
    public void onBindContent() {
        tip.setText("DashboardFragment position" + position);
    }

    @Override
    protected void onFragmentVisible() {
        super.onFragmentVisible();
    }

    @Override
    protected void onFragmentInvisible() {
        super.onFragmentInvisible();
    }
}
