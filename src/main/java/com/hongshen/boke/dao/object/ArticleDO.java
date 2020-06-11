package com.hongshen.boke.dao.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2018/12/04
 */
public class ArticleDO implements Serializable {
    private Integer id;

    /** 文章主题 */
    private String title;

    private Date creatTime;

    private Integer userId;

    /** 文章描述 */
    private String description;

    /** 关联栏目id */
    private Integer columnId;

    /** 关联游客id */
    private Integer touristId;

    /** 文章内容 */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public Integer getTouristId() {
        return touristId;
    }

    public void setTouristId(Integer touristId) {
        this.touristId = touristId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", userId=").append(userId);
        sb.append(", description=").append(description);
        sb.append(", columnId=").append(columnId);
        sb.append(", touristId=").append(touristId);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}