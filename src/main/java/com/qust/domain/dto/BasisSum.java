package com.qust.domain.dto;

/**
 * 统计中国各城市的职业总量
 * Created by Tan Weichao on 2017/5/4.
 */
public class BasisSum {

    /** 招聘条数 */
    private Integer count;

    /** 招聘人数 */
    private Integer sum;

    /** 工作地点 */
    private String area;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
