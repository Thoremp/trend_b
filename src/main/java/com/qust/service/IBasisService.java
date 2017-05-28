package com.qust.service;

import com.qust.domain.dto.BasisField;
import com.qust.domain.dto.BasisSum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Tan Weichao on 2017/4/15.
 */
public interface IBasisService {

    /**
     * 查询全国若干城市对某一职业的各地区招聘数量和招聘人数
     * @param field
     * @param sum
     * @return
     */
    public abstract List<BasisSum> getChinaByCity(String field, Long sum);

    public abstract List<BasisField> getFieldAll();

    public List<BasisSum> getChinaAll(Long sum);

    public List<BasisSum> getFieldAll114();

    public List<BasisSum> getFieldAllDay();

    public List<BasisSum> getFieldDay7(Long parent_number);

    public List<BasisSum> getAreaDay(String area);

    public Long getUSAAll(String field);

    public List<BasisSum> getUSADayAll();

    public List<BasisSum> getUSADay15(String field);
}
