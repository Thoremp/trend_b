package com.qust.mapper;

import com.qust.domain.Field;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Tan Weichao on 2017/4/25.
 */
public interface FieldMapper {

    @Select(" SELECT f1.id,f1.addTime,f1.deleteStatus,f1.level,f1.field_name,f1.field_number," +
            " (SELECT f2.field_number FROM trend_field f2 WHERE f1.parent_id=f2.id) AS parent_id" +
            " FROM trend_field f1 limit #{offset},#{limit}")
    List<Field> fields(@Param("offset") Integer offset, @Param("limit") Integer limit);

//    @Select("select count(*) from trend_field limit #{offset},#{limit}")
//    Integer getFieldsNum(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select count(*) from trend_field")
    Integer getFieldsNum();
}
