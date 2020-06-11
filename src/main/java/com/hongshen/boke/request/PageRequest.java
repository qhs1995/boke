package com.hongshen.boke.request;


import com.hongshen.boke.utils.StringUtils;

/**
 * @Description: 请求对象基础类
 * @Package: com.shanghe.shop.common
 * @ClassName: PageRequest
 * @Author: zhoubo
 * @CreateDate: 2018年07月06 15:41
 * @Version: 1.0
 **/
public class PageRequest {

    /**商户ID*/
    private String merchantCode;

    /**页码*/
    private Integer page = 1;
    /**每页默认显示大小*/
    private Integer limit = 10;
//    /**开始页*/
//    private Integer startNum;
    /**排序字段*/
    private String sortField;
    /**排序方式 asc  desc*/
    private String sortType;
    /**默认排序 eg：id desc */
    private String defaultOrderBy;

    public String buildOrderBy(){
        if(!StringUtils.isBlank(sortField)){
            return sortField + " " + sortType;
        }
        return defaultOrderBy;
    }
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

//    public Integer getStartNum() {
//        return startNum;
//    }
//
//    public void setStartNum(Integer startNum) {
//        this.startNum = startNum;
//    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getDefaultOrderBy() {
        return defaultOrderBy;
    }

    public void setDefaultOrderBy(String defaultOrderBy) {
        this.defaultOrderBy = defaultOrderBy;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }
}
