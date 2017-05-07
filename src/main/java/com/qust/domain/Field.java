package com.qust.domain;

import java.util.Date;

/**
 * Created by Tan Weichao on 2017/4/15.
 */
public class Field {
    private Long id;
    private Date addTime;
    private Integer deleteStatus;

    /** 分类级别 */
    private Integer level;

    /** 职位名称 */
    private String field_name;

    /** 职位编码! */
    private Long field_number;
    private Long parent_id;

    /** 1表示顶级 */
    private Integer common;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
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

    public Integer getCommon() {
        return common;
    }

    public void setCommon(Integer common) {
        this.common = common;
    }
}
