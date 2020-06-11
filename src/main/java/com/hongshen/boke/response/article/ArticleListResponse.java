package com.hongshen.boke.response.article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/9 11:20
 * @Desc: 文章列表数据接收实体
 */
public class ArticleListResponse implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(ArticleListResponse.class);

    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 创建时间
     */
    private Date creatTime;
    /**
     * 描述
     */
    private String description;
    /**
     * 栏目名称
     */
    private String columnName;
    /**
     * 作者
     */
    private String uName;

    private String parentName;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "ArticleListResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creatTime=" + creatTime +
                ", description='" + description + '\'' +
                ", columnName='" + columnName + '\'' +
                ", uName='" + uName + '\'' +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
