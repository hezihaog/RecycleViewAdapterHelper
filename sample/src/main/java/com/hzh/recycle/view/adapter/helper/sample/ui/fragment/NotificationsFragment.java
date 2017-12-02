package com.hzh.recycle.view.adapter.helper.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.base.BaseFragment;
import com.hzh.recycle.view.adapter.helper.sample.ui.activity.MainActivity;
import com.hzh.view.injector.anno.ContentView;
import com.hzh.view.injector.anno.OnClick;
import com.hzh.view.injector.anno.ViewInject;

/**
 * Package: com.hzh.lazy.fragment.sample.fragment
 * FileName: DashboardFramgent
 * Date: on 2017/11/24  上午11:47
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

@ContentView(R.layout.fragment_notifications)
public class NotificationsFragment extends BaseFragment {
    @ViewInject(R.id.tip)
    private TextView tip;

    private String position;

    @Override
    protected void onLazyViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        position = arguments.getString(MainActivity.KEY_BUNDLE_POSITION);
    }

    @Override
    public void onFindViews(View mRootView) {
    }

    @Override
    public void onBindContent() {
        tip.setText("NotificationsFragment position" + position);
    }

    @OnClick(R.id.tip)
    public void onClick(View view) {
        toast("onClick...");
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
