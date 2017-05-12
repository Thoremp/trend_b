package com.qust.domain.dto;

import java.util.Date;

/**
 * 统计中国各城市的职业总量
 * Created by Tan Weichao on 2017/5/4.
 */
public class BasisSum {

    /** 招聘条数 */
    private Long count;

    /** 招聘人数 */
    private Long sum;

    /** 工作地点 */
    private String area;

    /** 招聘发布日期 */
    private Date releaseDate;

    /** 招聘职业 */
    private String field;

    /** 职业代码 */
    private Long field_number;

    /** 职业父级代码 */
    private Long parent_number;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
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

    public Long getParent_number() {
        return parent_number;
    }

    public void setParent_number(Long parent_number) {
        this.parent_number = parent_number;
    }
}
