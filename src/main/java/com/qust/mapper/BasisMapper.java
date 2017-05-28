package com.qust.mapper;

import com.qust.domain.Basis;
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
     * 查询全国若干城市对某一职业的各地区招聘数量和招聘人数（例如Java）地图
     * @param field
     * @param sum
     * @return
     */
    @Select(" select count(recruitNum) count, sum(recruitNum) sum, area\n" +
            " from trend_basis where field = #{field} group by area having sum>#{sum}\n" +
            " order by area desc")
    public List<BasisSum> getChinaByCity(@Param("field") String field, @Param("sum") Long sum);

    /**
     * 中国主要城市计算机行业招聘人数总量
     * 7个大类的占比-饼图
     * @return
     */
    @Select(" SELECT COUNT(tba.recruitNum) AS recruitNum,tba.parent_id,tba.companyIndustry " +
            "FROM view_basis_all tba GROUP BY tba.parent_id ")
    public List<BasisField> getFieldAll();

    //各地区的人数统计-地图
    @Select(" select count(recruitNum) count, sum(recruitNum) sum, area" +
            " from trend_basis group by area having sum > #{sum} order by area desc ")
    public List<BasisSum> getChinaAll(@Param("sum") Long sum);

    //114个行业-饼图
    @Select("select count(*) as count,sum(recruitNum) as sum,field from trend_basis " +
            "group by field order by sum desc")
    public List<BasisSum> getFieldAll114();

    //统计行业人数总量(每日)
    @Select("select count(*) count, sum(recruitNum) sum,releaseDate from trend_basis " +
            "group by releaseDate having releaseDate >= '2017-04-20'  order by releaseDate")
    public List<BasisSum> getFieldAllDay();

    //统计行业数(指定大类行业)
    //7个职业各自的趋势
    @Select("select count(*) count,sum(recruitNum) sum,releaseDate,parent_number " +
            "from trend_basis where releaseDate >= '2017-04-20' and parent_number is not null " +
            "and parent_number=#{parent_number} group by parent_number,releaseDate")
    public List<BasisSum> getFieldDay7(@Param("parent_number") Long parent_number);

    //统计招聘人数(指定地区)
    @Select("select count(*) count, sum(recruitNum) sum, area, releaseDate from trend_basis" +
            " where area =#{area} and releaseDate >= '2017-04-20' group by area,releaseDate")
    public List<BasisSum> getAreaDay(@Param("area") String area);

    //计算美国各行业占比
    @Select("select count(*) as count from trend_basis_usa where title like #{field}")
    public Long getUSAAll(@Param("field") String field);

    //每日 美国总量
    @Select("select count(*) count,releaseDate from trend_basis_usa where " +
            "releaseDate >= '2017-03-27' group by releaseDate")
    public List<BasisSum> getUSADayAll();

    //每日 美国15个职业量 - 趋势图
    @Select("select count(*) count, releaseDate from trend_basis_usa where " +
            "releaseDate > '2017-03-27' and title like #{field} group by releaseDate")
    public List<BasisSum> getUSADay15(@Param("field") String field);
}
