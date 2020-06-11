package com.hongshen.boke.dao.object;

import java.io.Serializable;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2018/11/09
 */
public class UserDO implements Serializable {
    private Integer id;

    /** 登录账号 */
    private String username;

    /** 登录密码 */
    private String password;

    /** 用户名 */
    private String name;

    /** 用户头像 */
    private String headPortrait;

    /** 用户微信 */
    private String wechat;

    /** 用户QQ */
    private String qqNumber;

    /** 用户微博 */
    private String weibo;

    /** 用户签名 */
    private String signature;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", headPortrait=").append(headPortrait);
        sb.append(", wechat=").append(wechat);
        sb.append(", qqNumber=").append(qqNumber);
        sb.append(", weibo=").append(weibo);
        sb.append(", signature=").append(signature);
        sb.append("]");
        return sb.toString();
    }
}