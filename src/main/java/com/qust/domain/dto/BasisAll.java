package com.qust.domain.dto;

import java.util.Date;

/**
 * Created by Tan Weichao on 2017/5/5.
 */
public class BasisAll {

    private Long id;
    private String area;
    private Date releaseDate;
    private Long recruitNum;
    private String field;
    private Long field_number;
    private Long parent_id;
    private String companyIndustry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getRecruitNum() {
        return recruitNum;
    }

    public void setRecruitNum(Long recruitNum) {
        this.recruitNum = recruitNum;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Long getField_number() {
        return field_number;
    }

    public void setField_number(Long field_number) {
        this.field_number = field_number;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }
}
