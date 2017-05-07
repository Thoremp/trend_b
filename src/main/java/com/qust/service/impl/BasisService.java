package com.qust.service.impl;

import com.qust.domain.Basis;
import com.qust.domain.dto.BasisDTO;
import com.qust.domain.dto.BasisField;
import com.qust.domain.dto.BasisSum;
import com.qust.mapper.BasisMapper;
import com.qust.service.IBasisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tan Weichao on 2017/4/15.
 */
@Service()
public class BasisService implements IBasisService {

    @Autowired
    private BasisMapper basisMapper;

    /**
     * 查询全国若干城市对某一职业的各地区招聘数量和招聘人数
     * citys 集合中的每一个List中的参数分别是:招聘数量,招聘人数,招聘地点
     * @param field
     * @param sum
     * @return
     */
    public List<BasisSum> getChinaByCity(String field, Integer sum){
        return basisMapper.getChinaByCity(field, sum);
    }

    public List<BasisField> getFieldAll(){
        return basisMapper.getFieldAll();
    }

    public List<BasisSum> getChinaAll(Integer sum){
        return basisMapper.getChinaAll(sum);
    }

    /**
     * 以下是本地数据,以上是服务器数据
     */

    /**
     * 查询一个职位的所有记录
     * @param field
     * @return
     */
    @Override
    public List<Basis> getBasisesByfieldAndArea(String field, String area, String releaseDate) {
        return basisMapper.getBasisesByfieldAndArea(field, area, releaseDate);
    }

    @Override
    public List<BasisDTO> getBasisCount(String releaseDate, String area, String field) {
        return basisMapper.getBasisCount(releaseDate, area, field);
    }

    @Override
    public List<BasisDTO> getBasisCountByAreaFieldDate() {
        return basisMapper.getBasisCountByAreaFieldDate();
    }

    @Override
    public List<Integer> getBasisCountAll() {
        return basisMapper.getBasisCountAll();
    }

    @Override
    public List<BasisDTO> getBasis0413() {
        return basisMapper.getBasis0413();
    }
}
