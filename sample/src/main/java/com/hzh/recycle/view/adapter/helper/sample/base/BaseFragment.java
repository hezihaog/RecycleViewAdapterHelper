package com.hzh.recycle.view.adapter.helper.sample.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hzh.lazy.fragment.ExtendLazyFragment;
import com.hzh.view.injector.ViewInjectManager;

/**
 * Package: com.hzh.recycle.view.adapter.helper.sample.base
 * FileName: BaseFragment
 * Date: on 2017/12/2  下午6:52
 * Auther: zihe
 * Descirbe: Fragment基类
 * Email: hezihao@linghit.com
 */

public abstract class BaseFragment extends ExtendLazyFragment {

    @Override
    public View onInflaterRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return ViewInjectManager.getOperate().inject(this, inflater, container);
    }

    public void toast(String msg) {
        Toast.makeText(getContext().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
