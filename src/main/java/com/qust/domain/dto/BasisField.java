package com.qust.domain.dto;

/**
 *
 * 统计七个大类各有多少人
 * Created by Tan Weichao on 2017/5/5.
 */
public class BasisField {
    private Integer recruitNum;
    private Integer parent_id;
    private String companyIndustry;

    public Integer getRecruitNum() {
        return recruitNum;
    }

    public void setRecruitNum(Integer recruitNum) {
        this.recruitNum = recruitNum;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }
}
