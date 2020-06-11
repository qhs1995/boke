package com.hongshen.boke.dao.jianli.object;

import java.io.Serializable;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2019/09/23
 */
public class UserinfoDO implements Serializable {
    private Integer id;

    /** 姓名 */
    private String name;

    /** 性别 */
    private String sex;

    /** 年龄 */
    private Integer age;

    /** 户口地址 */
    private String address;

    /** 联系地址 */
    private String linkAddress;

    /** 专业 */
    private String specialty;

    /** 学历 */
    private String education;

    /** 学校 */
    private String school;

    /** qq */
    private String linkQq;

    /** 微信 */
    private String linkWechat;

    /** 电话 */
    private String linkPhone;

    /** 联系邮箱 */
    private String linkEmail;

    /** 应聘岗位 */
    private String job;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLinkQq() {
        return linkQq;
    }

    public void setLinkQq(String linkQq) {
        this.linkQq = linkQq;
    }

    public String getLinkWechat() {
        return linkWechat;
    }

    public void setLinkWechat(String linkWechat) {
        this.linkWechat = linkWechat;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", address=").append(address);
        sb.append(", linkAddress=").append(linkAddress);
        sb.append(", specialty=").append(specialty);
        sb.append(", education=").append(education);
        sb.append(", school=").append(school);
        sb.append(", linkQq=").append(linkQq);
        sb.append(", linkWechat=").append(linkWechat);
        sb.append(", linkPhone=").append(linkPhone);
        sb.append(", linkEmail=").append(linkEmail);
        sb.append(", job=").append(job);
        sb.append("]");
        return sb.toString();
    }
}