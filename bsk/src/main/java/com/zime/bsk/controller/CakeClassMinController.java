package com.zime.bsk.controller;

import com.zime.bsk.entity.CakeClass;
import com.zime.bsk.entity.CakeClassMin;
import com.zime.bsk.service.CakeClassMinService;
import com.zime.bsk.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/12/3
 * @TIME: 9:28
 */
@Controller
@CrossOrigin
public class CakeClassMinController {

    @Autowired
    private CakeClassMinService cakeClassMinService;


    /**
     * 通过蛋糕一级类别id获取到所有对应二级的类别信息
     * @param cakeclassminClassid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClassMin/getAllCakeClassMinByClassId")
    public Object getAllCakeClassMinByClassId(Integer cakeclassminClassid){
        if(cakeclassminClassid == null){
            return JsonUtil.fail("获取cakeclassminClassid为空");
        } else {
            List<CakeClassMin> cakeClassMins = cakeClassMinService.getAllCakeClassMinByClassId(cakeclassminClassid);
            return JsonUtil.success("获取一级类别id对应的所有二级的类别信息").addData(cakeClassMins).addCount(cakeClassMins.size());
        }
    }

    /**
     * 通过蛋糕二级类别id获取到对应二级的类别信息
     * @param cakeclassminId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClassMin/getCakeClassMinById")
    public Object getCakeClassMinById(Integer cakeclassminId){
        if(cakeclassminId == null){
            return JsonUtil.fail("获取cakeclassminId为空");
        } else {
            List<CakeClassMin> cakeClassMins = cakeClassMinService.getCakeClassMinById(cakeclassminId);
            return JsonUtil.success("获取二级类别id对应二级的类别信息").addData(cakeClassMins).addCount(cakeClassMins.size());
        }
    }

    /**
     * 添加蛋糕二级类别信息
     * @param cakeClassMin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClassMin/addCakeClassMin")
    public Object addCakeClassMin(CakeClassMin cakeClassMin){
        if(cakeClassMin == null){
            return JsonUtil.fail("获取蛋糕二级类别为空");
        } else {
            int flag = 0;
            try{
                flag = cakeClassMinService.addCakeClassMin(cakeClassMin);
                if(flag == 1){
                    return JsonUtil.success("添加蛋糕二级类别成功");
                } else {
                    return JsonUtil.fail("添加蛋糕二级类别失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("添加蛋糕二级类别失败");
            }
        }
    }

    /**
     * 修改蛋糕二级类别
     * @param cakeClassMin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClassMin/editCakeClassMin")
    public Object editCakeClassMin(CakeClassMin cakeClassMin){
        if(cakeClassMin == null){
            return JsonUtil.fail("修改蛋糕二级类别为空");
        } else {
            int flag = 0;
            try{
                flag = cakeClassMinService.editCakeClassMin(cakeClassMin);
                if(flag == 1){
                    return JsonUtil.success("修改蛋糕二级类别成功");
                } else {
                    return JsonUtil.fail("修改蛋糕二级类别失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("修改蛋糕二级类别失败");
            }
        }
    }

    /**
     * 通过id删除蛋糕二级类别
     * @param cakeclassminId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClassMin/removeCakeClassMin")
    public Object removeCakeClassMin(Integer cakeclassminId){
        if(cakeclassminId == null){
            return JsonUtil.fail("删除cakeclassminId为空");
        } else {
            int flag = 0;
            try{
                flag = cakeClassMinService.removeCakeClassMin(cakeclassminId);
                if(flag == 1){
                    return JsonUtil.success("删除蛋糕二级类别成功");
                } else {
                    return JsonUtil.fail("删除蛋糕二级类别失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("删除蛋糕二级类别失败");
            }
        }
    }

    /**
     * 通过蛋糕一级类别id删除所有蛋糕二级类别信息
     * @param cakeclassminClassid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClassMin/removeCakeClassMinByClassId")
    public Object removeCakeClassMinByClassId(Integer cakeclassminClassid){
        if(cakeclassminClassid == null){
            return JsonUtil.fail("删除cakeclassminClassid为空");
        } else {
            int flag = 0;
            try{
                flag = cakeClassMinService.removeCakeClassMinByClassId(cakeclassminClassid);
                if(flag == 1){
                    return JsonUtil.success("删除一级类别id对应所有蛋糕二级类别成功");
                } else {
                    return JsonUtil.fail("删除一级类别id对应所有蛋糕二级类别失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("删除一级类别id对应所有蛋糕二级类别失败");
            }
        }
    }


}
