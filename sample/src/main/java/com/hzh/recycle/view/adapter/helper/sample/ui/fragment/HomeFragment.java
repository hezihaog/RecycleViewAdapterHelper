package com.hzh.recycle.view.adapter.helper.sample.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hzh.logger.L;
import com.hzh.recycle.view.adapter.helper.adapter.base.RecyclerViewHolder;
import com.hzh.recycle.view.adapter.helper.adapter.singletype.SingleTypeAdapter;
import com.hzh.recycle.view.adapter.helper.divider.RecycleViewDivider;
import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.base.BaseFragment;
import com.hzh.recycle.view.adapter.helper.sample.entity.Friend;
import com.hzh.recycle.view.adapter.helper.sample.ui.activity.DetailActivity;
import com.hzh.recycle.view.adapter.helper.sample.ui.activity.MainActivity;
import com.hzh.recycle.view.adapter.helper.sample.util.FakeUtil;
import com.hzh.recycle.view.adapter.helper.sample.util.ImageUtil;
import com.hzh.view.injector.anno.ContentView;
import com.hzh.view.injector.anno.ViewInject;

import java.util.ArrayList;

/**
 * Package: com.hzh.lazy.fragment.sample.fragment
 * FileName: HomeFragment
 * Date: on 2017/11/24  上午11:11
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {
    @ViewInject(R.id.recyclerView)
    private RecyclerView mRecyclerView;

    private ArrayList<Friend> mDatas;

    @Override
    protected void onLazyViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String position = arguments.getString(MainActivity.KEY_BUNDLE_POSITION);
        L.d("position ::: " + position);
    }

    @Override
    public void onFindViews(View mRootView) {
    }

    @Override
    public void onBindContent() {
        initData();
        SingleTypeAdapter<Friend> adapter = new SingleTypeAdapter<Friend>(getActivity(), R.layout.item_main_friend) {

            @Override
            public void convert(int position, RecyclerViewHolder holder, Friend bean) {
                holder.setText(R.id.name, bean.getName());
                holder.setText(R.id.comment, bean.getComment());
                ImageUtil.loadImage(getActivity(), bean.getAvatarUrl(), (ImageView) holder.get(R.id.avatar));
                holder.get(R.id.avatar).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext().getApplicationContext(), "avatar on click", Toast.LENGTH_SHORT).show();
                    }
                });
                holder.getRootView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), DetailActivity.class));
                    }
                });
            }
        };
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL
                , R.drawable.item_divider));
        adapter.addDatas(mDatas);
    }

    private void initData() {
        mDatas = new ArrayList<Friend>();
        for (int i = 0; i < 15; i++) {
            Friend friend = new Friend();
            friend.setAvatarUrl(FakeUtil.getRandomAvatar(i));
            friend.setName(FakeUtil.getRandomName(i));
            friend.setComment(FakeUtil.getRandomComment(i));
            mDatas.add(friend);
        }
    }
}
