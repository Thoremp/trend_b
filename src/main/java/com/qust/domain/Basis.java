package com.qust.domain;

import java.util.Date;

/**
 * Created by Tan Weichao on 2017/4/15.
 */
public class Basis {
    private Long id;
    private Date addTime;
    private Integer deleteStatus;

    /** 招聘详情主页url */
    private String recruitUrl;
    private String title;
    private String companyName;

    /** 工作地点 */
    private String area;
    private String salary;

    /** 发布日期 */
    private Date releaseDate;
    private String wordNature;

    /** 工作性质(全职/兼职) */
    private String workExperience;

    /** 学历要求 */
    private String edu;
    private Integer recruitNum;

    /** 招聘职位! */
    private String field;
    private String companyScale;

    /** 公司性质(民营/国企) */
    private String companyIndustry;

    /** 公司行业 */
    private String companyNature;
    private String companyAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getRecruitUrl() {
        return recruitUrl;
    }

    public void setRecruitUrl(String recruitUrl) {
        this.recruitUrl = recruitUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getWordNature() {
        return wordNature;
    }

    public void setWordNature(String wordNature) {
        this.wordNature = wordNature;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public Integer getRecruitNum() {
        return recruitNum;
    }

    public void setRecruitNum(Integer recruitNum) {
        this.recruitNum = recruitNum;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
