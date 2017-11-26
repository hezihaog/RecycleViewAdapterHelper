package com.hzh.recycle.view.adapter.helper.sample.entity;

import java.io.Serializable;

/**
 * Package: com.hzh.recycle.view.adapter.helper.sample.entity
 * FileName: Person
 * Date: on 2017/11/25  下午3:30
 * Auther: zihe
 * Descirbe: 好友bean
 * Email: hezihao@linghit.com
 */

public class Friend implements Serializable {
    //姓名
    private String name;
    //评论
    private String comment;
    //头像链接
    private String avatarUrl;

    public String getName() {
        return name;
    }

    public Friend setName(String name) {
        this.name = name;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Friend setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Friend setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }
}
