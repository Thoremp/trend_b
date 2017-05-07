package com.qust.controller;

import com.qust.domain.Field;
import com.qust.service.IFieldService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tan Weichao on 2017/4/25.
 */
@RestController
@EnableAutoConfiguration
public class TrendDataController {

    @Autowired
    private IFieldService fieldService;

    /**
     * 往前台返回所有类别和代码
     * @param model
     */
    @RequestMapping("/data_field.json")
    @ResponseBody
    Map data_field(Model model, @Param("offset") Integer offset,@Param("limit") Integer limit){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("offset", offset);
        paramMap.put("limit", limit);
        Map<String, Object> resultMap = fieldService.getFields(paramMap);
        return resultMap;
    }

    @RequestMapping(value="/test")
    public @ResponseBody Map test(){
        Map<String, Object> map = new HashMap<>();
        map.put("青岛","科技大学");
        return map;
    }
}
