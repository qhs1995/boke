package com.hongshen.boke.dao.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2018/12/04
 */
public class CommentsDO implements Serializable {
    private Integer id;

    /** 游客id */
    private Integer touristId;

    /** 文章id */
    private Integer articleId;

    /** 创建时间 */
    private Date creatTime;

    /** 留言信息 */
    private String leaveComments;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTouristId() {
        return touristId;
    }

    public void setTouristId(Integer touristId) {
        this.touristId = touristId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", touristId=").append(touristId);
        sb.append(", articleId=").append(articleId);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", leaveComments=").append(leaveComments);
        sb.append("]");
        return sb.toString();
    }
}