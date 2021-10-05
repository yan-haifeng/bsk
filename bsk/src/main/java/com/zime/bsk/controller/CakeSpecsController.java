package com.zime.bsk.controller;

import com.zime.bsk.entity.CakeCar;
import com.zime.bsk.entity.CakeSpecs;
import com.zime.bsk.service.CakeSpecsService;
import com.zime.bsk.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/12/5
 * @TIME: 9:47
 */
@Controller
@CrossOrigin
public class CakeSpecsController {

    @Autowired
    private CakeSpecsService cakeSpecsService;

    /**
     * 通过蛋糕id获取某个蛋糕的所有规格
     * @param cakespecsCakeid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeSpecs/getAllCakeSpecsByCakeId")
    public Object getAllCakeSpecsByCakeId(Integer cakespecsCakeid){
        if(cakespecsCakeid == null){
            return JsonUtil.fail("cakespecsCakeid为空");
        } else {
            List<CakeSpecs> cakeSpecs = cakeSpecsService.getAllCakeSpecsByCakeId(cakespecsCakeid);
            return JsonUtil.success("通过蛋糕id获取某个蛋糕的所有规格").addData(cakeSpecs).addCount(cakeSpecs.size());
        }
    }

    /**
     * 通过蛋糕规格id获取某个规格
     * @param cakespecsId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeSpecs/getCakeSpecs")
    public Object getCakeSpecs(Integer cakespecsId){
        if(cakespecsId == null){
            return JsonUtil.fail("cakespecsId为空");
        } else {
            List<CakeSpecs> cakeSpecs = cakeSpecsService.getCakeSpecs(cakespecsId);
            return JsonUtil.success("通过蛋糕规格id获取某个规格").addData(cakeSpecs).addCount(cakeSpecs.size());
        }
    }


}
