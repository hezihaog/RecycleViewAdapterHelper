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
 * Last modified 2017-04-08 15:05:32
 *
 * GitHub:  https://github.com/GcsSloop
 * Website: http://www.gcssloop.com
 * Weibo:   http://weibo.com/GcsSloop
 */

package com.hzh.recycle.view.adapter.helper.sample.provider;

import android.content.Context;
import android.support.annotation.NonNull;

import com.hzh.recycle.view.adapter.helper.adapter.base.RecyclerViewHolder;
import com.hzh.recycle.view.adapter.helper.adapter.multitype.BaseViewProvider;
import com.hzh.recycle.view.adapter.helper.sample.R;
import com.hzh.recycle.view.adapter.helper.sample.base.Header;


public class HeaderProvider extends BaseViewProvider<Header> {
    public HeaderProvider(@NonNull Context context) {
        super(context, R.layout.item_header);
    }

    /**
     * 在绑定数据时调用，需要用户自己处理
     *
     * @param holder ViewHolder
     * @param bean   数据
     */
    @Override
    public void onBindView(RecyclerViewHolder holder, Header bean) {
        holder.setText(R.id.header, "-- 头部 --");
    }
}
