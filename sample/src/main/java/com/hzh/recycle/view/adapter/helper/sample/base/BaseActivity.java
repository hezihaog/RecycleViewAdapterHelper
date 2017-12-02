package com.hzh.recycle.view.adapter.helper.sample.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hzh.view.injector.ViewInjectManager;

/**
 * Package: com.hzh.recycle.view.adapter.helper.sample.base
 * FileName: BaseActivity
 * Date: on 2017/12/2  下午6:50
 * Auther: zihe
 * Descirbe: Activity基类
 * Email: hezihao@linghit.com
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectManager.getOperate().inject(this);
    }

    public void toast(String msg) {
        Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
