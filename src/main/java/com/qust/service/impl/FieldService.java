package com.qust.service.impl;

import com.qust.domain.Field;
import com.qust.mapper.FieldMapper;
import com.qust.service.IFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tan Weichao on 2017/4/25.
 */
@Service
public class FieldService implements IFieldService{

    @Autowired
    private FieldMapper fieldMapper;

    @Override
    public Map<String, Object> getFields(Map<String,Object> paramMap) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("rows", fieldMapper.fields(Integer.parseInt(paramMap.get("offset").toString()), Integer.parseInt(paramMap.get("limit").toString())));
        resultMap.put("total", fieldMapper.getFieldsNum());
        return resultMap;
    }
}
