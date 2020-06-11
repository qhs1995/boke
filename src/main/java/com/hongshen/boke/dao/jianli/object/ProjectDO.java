package com.hongshen.boke.dao.jianli.object;

import java.io.Serializable;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2019/09/25
 */
public class ProjectDO implements Serializable {
    private Integer id;

    /** 项目名称 */
    private String projectName;

    /** 项目使用技术 */
    private String projectSkill;

    /** 项目周期 */
    private String projectTime;

    /** 项目类别 */
    private String projectClass;

    /** 项目图片 */
    private String projectImg;

    /** 项目详情 */
    private String projectDetails;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectSkill() {
        return projectSkill;
    }

    public void setProjectSkill(String projectSkill) {
        this.projectSkill = projectSkill;
    }

    public String getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(String projectTime) {
        this.projectTime = projectTime;
    }

    public String getProjectClass() {
        return projectClass;
    }

    public void setProjectClass(String projectClass) {
        this.projectClass = projectClass;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectSkill=").append(projectSkill);
        sb.append(", projectTime=").append(projectTime);
        sb.append(", projectClass=").append(projectClass);
        sb.append(", projectImg=").append(projectImg);
        sb.append(", projectDetails=").append(projectDetails);
        sb.append("]");
        return sb.toString();
    }
}