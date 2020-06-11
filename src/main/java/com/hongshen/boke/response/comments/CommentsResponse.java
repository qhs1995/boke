package com.hongshen.boke.response.comments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/12/4 14:48
 * @Desc:
 */
public class CommentsResponse implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(CommentsResponse.class);

    /** 昵称 */
    private String nickname;

    /** 创建时间 */
    private Date creatTime;

    /** 留言信息 */
    private String leaveComments;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getLeaveComments() {
        return leaveComments;
    }

    public void setLeaveComments(String leaveComments) {
        this.leaveComments = leaveComments;
    }
}
