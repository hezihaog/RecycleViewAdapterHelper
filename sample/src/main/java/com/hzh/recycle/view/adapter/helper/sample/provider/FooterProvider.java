/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2017-04-08 21:51:56
 *
 * GitHub:  https://github.com/GcsSloop
 * Website: http://www.gcssloop.com
 * Weibo:   http://weibo.com/GcsSloop
 */

package com.hzh.recycle.view.adapter.helper.sample.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hzh.recycle.view.adapter.helper.adapter.base.RecyclerViewHolder;
import com.hzh.recycle.view.adapter.helper.adapter.multitype.BaseViewProvider;
import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.base.Footer;


public class FooterProvider extends BaseViewProvider<Footer> {
    private static final String FOOTER_LOADING = "loading...";
    private static final String FOOTER_NORMAL = "-- end --";
    private static final String FOOTER_ERROR_A = "-- 获取失败 --";
    private static final String FOOTER_ERROR_B = "-- 失败，点击重试 --";
    private TextView footer;

    public FooterProvider(@NonNull Context context) {
        super(context, R.layout.item_footer);
    }

    @Override
    public void onViewHolderIsCreated(RecyclerViewHolder holder) {
         footer = holder.get(R.id.footer);
    }

    @Override
    public void onBindView(RecyclerViewHolder holder, Footer bean) {
        //footer= holder.get(R.id.footer);
        needLoadMore();
    }

    public void needLoadMore() {}

    public void setFooterLoading() {
        if (null == footer) return;
        footer.setText(FOOTER_LOADING);
    }

    public void setFooterNormal() {
        if (null == footer) return;
        footer.setText(FOOTER_NORMAL);
    }

    public void setFooterError(View.OnClickListener listener) {
        if (null == footer) return;
        if (null != listener) {
            footer.setText(FOOTER_ERROR_B);
            footer.setOnClickListener(listener);
            return;
        }
        footer.setText(FOOTER_ERROR_A);
    }
}
