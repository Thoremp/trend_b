package com.qust.mapper;

import com.qust.domain.dto.BasisField;
import com.qust.domain.dto.BasisSum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Tan Weichao on 2017/4/15.
 */
public interface BasisMapper {


    /**
     * 查询全国若干城市对某一职业的各地区招聘数量和招聘人数
     * @param field
     * @param sum
     * @return
     */
    @Select(" select count(recruitNum) count, sum(recruitNum) sum, area\n" +
            " from trend_basis \n" +
            " where field = #{field}\n" +
            " group by area having sum>#{sum}\n" +
            " order by area desc")
    public List<BasisSum> getChinaByCity(@Param("field") String field, @Param("sum") Long sum);

    /**
     * 查询各职业的
     * @return
     */
    @Select(" SELECT COUNT(tba.recruitNum) AS recruitNum,tba.parent_id,tba.companyIndustry FROM view_basis_all tba\n" +
            " GROUP BY tba.parent_id ")
    public List<BasisField> getFieldAll();

    @Select(" select count(recruitNum) count, sum(recruitNum) sum, area" +
            " from trend_basis group by area having sum > 3000 order by area desc ")
    public List<BasisSum> getChinaAll(@Param("sum") Long sum);

    @Select("select count(*) as count,sum(recruitNum) as sum,field from trend_basis group by field order by sum desc")
    public List<BasisSum> getFieldAll114();

    //统计行业人数总量(每日)
    @Select("select count(*) count, sum(recruitNum) sum,releaseDate from trend_basis group by releaseDate having releaseDate >= '2017-04-20'  order by releaseDate")
    public List<BasisSum> getFieldAllDay();

}
