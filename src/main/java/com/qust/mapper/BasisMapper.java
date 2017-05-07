package com.qust.mapper;

import com.qust.domain.Basis;
import com.qust.domain.dto.BasisDTO;
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
    public List<BasisSum> getChinaByCity(@Param("field") String field, @Param("sum") Integer sum);

    /**
     * 查询各职业的
     * @return
     */
    @Select(" SELECT COUNT(tba.recruitNum) AS recruitNum,tba.parent_id,tba.companyIndustry FROM view_basis_all tba\n" +
            " GROUP BY tba.parent_id ")
    public List<BasisField> getFieldAll();

    @Select(" select count(recruitNum) count, sum(recruitNum) sum, area" +
            " from trend_basis group by area having sum > 3000 order by area desc ")
    public List<BasisSum> getChinaAll(@Param("sum") Integer sum);

    /**
     * 以上是正式的代码
     * 以下是一周检查用的代码
     */

    /**
     * 查询一个职位在一个地区的所有信息(指定日期-天).
     * <pre>
     *     条件 职位代码 城市名 某一天
     *     结果 该职位所有信息
     * </pre>
     * @param field 职位代码
     * @return
     */
    @Select("select * from trend_basis where field = #{field} and area = #{area} and releaseDate = #{releaseDate}")
    List<Basis> getBasisesByfieldAndArea(@Param("field") String field, @Param("area") String area, @Param("releaseDate") String releaseDate);

    /**
     * 招聘总人数/招聘数量
     * @param releaseDate 时间
     * @param area 地区
     * @param field 职位类别
     * @return
     */
    @Select("select * from view_count where releaseDate = #{releaseDate}"+
            " and area=#{area} and field=#{field}")
    List<BasisDTO> getBasisCount(@Param("releaseDate") String releaseDate,
                                 @Param("area") String area, @Param("field") String field);

    /**
     * 查询北上广青/Java和硬件/0413-0417
     * @return
     */
    @Select(" select * from view_count \n" +
            " where releaseDate between '2017-04-13' and '2017-04-17' \n" +
            " and area in('北京','上海','广州','青岛') \n" +
            " and field in('Java开发工程师','硬件工程师')\n" +
            " order by area,field,releaseDate")
    List<BasisDTO> getBasisCountByAreaFieldDate();

    /**
     * 北上广青 分别在 软硬工程师的总量
     * @return
     */
    @Select("SELECT SUM(recruitNums) AS recruitNums,FIELD,AREA FROM view_count \n" +
            "WHERE releaseDate BETWEEN '2017-04-13' AND '2017-04-17' \n" +
            "AND AREA IN('北京','上海','广州','青岛') \n" +
            "AND FIELD IN('Java开发工程师','硬件工程师')\n" +
            "GROUP BY AREA,FIELD")
    List<Integer> getBasisCountAll();

    @Select(" SELECT * FROM view_count \n" +
            " WHERE FIELD ='Java开发工程师'\n" +
            " AND releaseDate = '2017-04-13'\n" +
            " ORDER BY AREA")
    List<BasisDTO> getBasis0413();
}
