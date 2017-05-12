package com.qust.controller;

import com.qust.domain.dto.BasisField;
import com.qust.domain.dto.BasisSum;
import com.qust.service.IBasisService;
import com.qust.util.HanyuPinyinHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Tan Weichao on 2017/4/15.
 */
@Controller
@EnableAutoConfiguration
public class TrendController {

    @Autowired
    private IBasisService basisService;

    @Autowired
    private HanyuPinyinHelper hanyuPinyinHelper;

    //显示主页
    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }

    /**
     * 显示职业类别页面
     * @param model
     * @return
     */
    @RequestMapping("/cn_field.htm")
    String cn_field(Model model){
        return "cn_field";
    }

    /**
     * 全国各城市IT职业总量展示
     * @param model
     * @return
     */
    @RequestMapping("/china_java")
    String chinaJava(Model model){
        String field = "Java开发工程师";
        Long sum = 300L;
        List<BasisSum> citys = basisService.getChinaByCity(field, sum);
        Map<String, Object> map = new HashMap<>();
        for(BasisSum city : citys){
            Long persons = city.getSum();
            String address = city.getArea();
            String addressPinyin = hanyuPinyinHelper.toHanyuPinyin(address);//地址汉字转拼音
            map.put(addressPinyin, persons);
        }
        model.addAllAttributes(map);
        return "china/china_java";
    }

    /**
     * 各大类职业展示
     * @return
     */
    @RequestMapping(value="/field_all")
    public String field_all(Model model){
        List<BasisField> fields = basisService.getFieldAll();
        Map<String, Object> map = new HashMap<>();
        for(BasisField field : fields){
            Integer num = field.getRecruitNum();
            Integer number = field.getParent_id();
            map.put("field_"+number,num);
        }
        model.addAllAttributes(map);
        return "china/field_all";
    }

    /**
     * 中国各城市计算机行业从业人员统计
     * @param model
     * @return
     */
    @RequestMapping(value="/china_all")
    public String china_all(Model model){
        List<BasisSum> sums = basisService.getChinaAll(3000L);
        Map<String, Object> map = new HashMap<>();
        for(BasisSum BasisSum : sums){
            Long sum = BasisSum.getSum();
            sum = sum/1000;//单位:千人
            String area = BasisSum.getArea();
            String areaPinyin = hanyuPinyinHelper.toHanyuPinyin(area);
            map.put(areaPinyin, sum);
        }
        System.out.println(map);
        model.addAllAttributes(map);
        return "china/china_all";
    }

    /**
     * 饼图: 114个职业的分布
     * @return
     */
    @RequestMapping(value = "/cn_field_all114")
    public String cn_field_all114(Model model){
        List<BasisSum> bsts = basisService.getFieldAll114();
        Map<String, Object> map = new HashMap<>();
        for(BasisSum bst : bsts){
            Long sum = bst.getSum();
            String field = bst.getField();
            String field_pinyin = hanyuPinyinHelper.toHanyuPinyin(field);
            field_pinyin = field_pinyin.replace("/","");
            field_pinyin = field_pinyin.replace("（","");
            field_pinyin = field_pinyin.replace("）","");
            map.put(field_pinyin, sum);
        }
        model.addAllAttributes(map);
        for (Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return "china/cn_field_all114";
    }

    /**
     * 职业总量,每一天,折线图
     * @return
     */
    @RequestMapping(value="/cn_day_field_sum")
    public String cn_day_field_sum(Model model) {
        List<BasisSum> bss = basisService.getFieldAllDay();//从数据库获取数据
        List<String> relList = new ArrayList<>();//封装 X 坐标轴
        List<Long> sumList = new ArrayList<>();//封装数据
        for (BasisSum bs : bss) {
            Long sum = bs.getSum();
            Date releaseDate = bs.getReleaseDate();

            //封装 X 坐标轴
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String releaseDateStr = formatter.format(releaseDate);
            relList.add(releaseDateStr);

            //封装数据
            sumList.add(sum);
        }
        model.addAttribute("relList", relList);
        model.addAttribute("sumList", sumList);
        for (int i = 0; i < relList.size(); i++) {
            System.out.println(relList.get(i));
            System.out.println(sumList.get(i));
        }
        return "china/cn_day_field_sum";
    }
}


