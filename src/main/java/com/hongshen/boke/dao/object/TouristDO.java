package com.hongshen.boke.dao.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2018/12/04
 */
public class TouristDO implements Serializable {
    private Integer id;

    /** 昵称 */
    private String nickname;

    /** 邮箱 */
    private String mailbox;

    /** 账号 */
    private String username;

    /** 密码 */
    private String password;

    /** 头像 */
    private String headPortrait;

    /** 创建时间 */
    private Date creatTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
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

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", mailbox=").append(mailbox);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", headPortrait=").append(headPortrait);
        sb.append(", creatTime=").append(creatTime);
        sb.append("]");
        return sb.toString();
    }
}