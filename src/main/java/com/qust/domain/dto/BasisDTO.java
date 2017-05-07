package com.qust.domain.dto;

import java.util.Date;

/**
 * Created by Tan Weichao on 2017/4/17.
 */
public class BasisDTO {

    /** 招聘总人数 */
    private Integer recruitNums;

    /** 招聘总数 */
    private Integer releases;

    /** 招聘日期 */
    private Date releaseDate;

    /** 招聘地区 */
    private String area;

    /** 招聘职业 */
    private String field;

    public Integer getRecruitNums() {
        return recruitNums;
    }

    public void setRecruitNums(Integer recruitNums) {
        this.recruitNums = recruitNums;
    }

    public Integer getReleases() {
        return releases;
    }

    public void setReleases(Integer releases) {
        this.releases = releases;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
