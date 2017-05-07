package com.qust.controller;

import com.qust.domain.Basis;
import com.qust.domain.Field;
import com.qust.domain.dto.BasisDTO;
import com.qust.domain.dto.BasisField;
import com.qust.domain.dto.BasisSum;
import com.qust.service.IBasisService;
import com.qust.service.IFieldService;
import com.qust.util.HanyuPinyinHelper;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Integer sum = 300;
        List<BasisSum> citys = basisService.getChinaByCity(field, sum);
        Map<String, Object> map = new HashMap<>();
        for(BasisSum city : citys){
            Integer persons = city.getSum();
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
    @RequestMapping(value="/field_all", method = RequestMethod.GET)
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
    @RequestMapping(value="china_all")
    public String china_all(Model model){
        List<BasisSum> sums = basisService.getChinaAll(3000);
        Map<String, Object> map = new HashMap<>();
        for(BasisSum BasisSum : sums){
            Integer sum = BasisSum.getSum();
            sum = sum/1000;//单位:千人
            String area = BasisSum.getArea();
            String areaPinyin = hanyuPinyinHelper.toHanyuPinyin(area);
            map.put(areaPinyin, sum);
        }
        model.addAllAttributes(map);
        return "china_all";
    }

    /**
     * 下面是一周演示用的(数据在本地),上面是正式的数据(数据在阿里云)
     */

    @RequestMapping("/index")
    String index(Model model){
        return "index";
    }

    /**
     * Java开发工程师和软件工程师在北上广青的量(34)
     * 顺序:java/硬件 时间0413-0417 上北广青
     * @param model
     * @return
     */
    @RequestMapping("/compare")
    String compare(Model model){
        List<BasisDTO> counts = basisService.getBasisCountByAreaFieldDate();
        List<Integer> nums = new ArrayList<>();
        for(BasisDTO basisDTO : counts){
            nums.add(basisDTO.getRecruitNums());
        }
        model.addAttribute("nums",nums);
        return "compare";
    }

    /**
     * 北上广青四地平均值
     * @param model
     */
    @RequestMapping("/all")
    String all(Model model){
        List<Integer> nums = basisService.getBasisCountAll();
        System.out.println(nums);
        model.addAttribute("nums",nums);
        model.addAttribute("javanum",nums.get(0) + nums.get(2) + nums.get(4) + nums.get(6));
        model.addAttribute("hardwarenum",nums.get(1) + nums.get(3) + nums.get(5) + nums.get(7));
        return "all";
    }

    /**
     * 4月13日的全国主要城市的招聘量
     * @param model
     * @return
     */
    @RequestMapping("/china")
    String china(Model model){
        List<BasisDTO> basisDTOs = basisService.getBasis0413();
        List<Integer> sums = new ArrayList<>();
        for(BasisDTO basisDTO : basisDTOs){
            sums.add(basisDTO.getRecruitNums());
        }
        model.addAttribute("sums", sums);
        return "china";
    }
}


