package com.hzh.recycle.view.adapter.helper.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzh.lazy.fragment.ExtendLazyFragment;
import com.hzh.logger.L;
import com.hzh.recycle.view.adapter.helper.adapter.multitype.HeaderFooterAdapter;
import com.hzh.recycle.view.adapter.helper.divider.RecycleViewDivider;
import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.base.Dashboard;
import com.hzh.recycle.view.adapter.helper.sample.base.Footer;
import com.hzh.recycle.view.adapter.helper.sample.base.Header;
import com.hzh.recycle.view.adapter.helper.sample.provider.DashboardProvider;
import com.hzh.recycle.view.adapter.helper.sample.provider.FooterProvider;
import com.hzh.recycle.view.adapter.helper.sample.provider.HeaderProvider;
import com.hzh.recycle.view.adapter.helper.sample.ui.activity.MainActivity;
import com.hzh.recycle.view.adapter.helper.sample.util.FakeUtil;

import java.util.ArrayList;

/**
 * Package: com.hzh.lazy.fragment.sample.fragment
 * FileName: DashboardFramgent
 * Date: on 2017/11/24  上午11:47
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class DashboardFragment extends ExtendLazyFragment {
    private RecyclerView mRecyclerView;
    private ArrayList<Dashboard> mDatas;

    @Override
    public View onInflaterRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    protected void onLazyViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String position = arguments.getString(MainActivity.KEY_BUNDLE_POSITION);
        L.d("position ::: " + position);
    }

    @Override
    public void onFindViews(View mRootView) {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
    }

    @Override
    public void onBindContent() {
        initData();
        HeaderFooterAdapter adapter = new HeaderFooterAdapter();
        adapter.register(Dashboard.class, new DashboardProvider(getContext()));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL
                , R.drawable.item_divider));
        adapter.registerHeader(new Header(), new HeaderProvider(getContext()));
        adapter.registerFooter(new Footer(), new FooterProvider(getContext()));
        adapter.addDatas(mDatas);
    }

    @Override
    protected void onFragmentVisible() {
        super.onFragmentVisible();
    }

    @Override
    protected void onFragmentInvisible() {
        super.onFragmentInvisible();
    }

    private void initData() {
        mDatas = new ArrayList<Dashboard>();
        for (int i = 0; i < 15; i++) {
            Dashboard dashboard = new Dashboard();
            dashboard.setText(FakeUtil.getRandomScenicName(i));
            mDatas.add(dashboard);
        }
    }
}
