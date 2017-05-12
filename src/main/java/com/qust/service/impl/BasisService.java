package com.qust.service.impl;

import com.qust.domain.dto.BasisField;
import com.qust.domain.dto.BasisSum;
import com.qust.mapper.BasisMapper;
import com.qust.service.IBasisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<BasisSum> getChinaByCity(String field, Long sum){
        return basisMapper.getChinaByCity(field, sum);
    }

    public List<BasisField> getFieldAll(){
        return basisMapper.getFieldAll();
    }

    public List<BasisSum> getChinaAll(Long sum){
        return basisMapper.getChinaAll(sum);
    }

    public List<BasisSum> getFieldAll114(){
        return basisMapper.getFieldAll114();
    }

    public List<BasisSum> getFieldAllDay(){
        return basisMapper.getFieldAllDay();
    }
}
