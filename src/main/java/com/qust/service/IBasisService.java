package com.qust.service;

import com.qust.domain.Basis;
import com.qust.domain.dto.BasisDTO;
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
    public abstract List<BasisSum> getChinaByCity(String field, Integer sum);

    public abstract List<BasisField> getFieldAll();

    public List<BasisSum> getChinaAll(Integer sum);

    /**
     * 以下是本地数据,以上是服务器数据
     */

    /**
     * 查询一个职位的所有记录
     * @param field
     * @return
     */
    List<Basis> getBasisesByfieldAndArea(String field, String area, String releaseDate);

    List<BasisDTO> getBasisCount(String releaseDate, String area, String field);

    List<BasisDTO> getBasisCountByAreaFieldDate();

    List<Integer> getBasisCountAll();

    List<BasisDTO> getBasis0413();
}
