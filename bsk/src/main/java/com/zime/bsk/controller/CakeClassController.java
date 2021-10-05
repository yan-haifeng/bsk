package com.zime.bsk.controller;

import com.github.pagehelper.PageInfo;
import com.zime.bsk.entity.CakeClass;
import com.zime.bsk.service.CakeClassService;
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
 * @TIME: 9:27
 */
@Controller
@CrossOrigin
public class CakeClassController {

    @Autowired
    private CakeClassService cakeClassService;

    /**
     * 获取所有一级类别
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClass/getAllCakeClass")
    public Object getAllCakeClass(){
        List<CakeClass> cakeClassList = cakeClassService.getAllCakeClass();
        return JsonUtil.success("获取一级所有类别").addData(cakeClassList).addCount(cakeClassList.size());
    }

    /**
     * 通过id获取对应一级蛋糕类别信息
     * @param cakeclassId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClass/getCakeClassById")
    public Object getCakeClassById(Integer cakeclassId){
        if(cakeclassId == null){
            return JsonUtil.fail("获取cakeclassId为空");
        } else {
            List<CakeClass> cakeClassList = cakeClassService.getCakeClassById(cakeclassId);
            return JsonUtil.success("获取一级所有类别").addData(cakeClassList).addCount(cakeClassList.size());
        }
    }

    /**
     * 添加蛋糕一级类别
     * @param cakeClass
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClass/addCakeClass")
    public Object addCakeClass(CakeClass cakeClass){
        if(cakeClass == null){
            return JsonUtil.fail("添加蛋糕一级类别为空");
        } else {
            int flag = 0;
            try{
                flag = cakeClassService.addCakeClass(cakeClass);
                if(flag == 1){
                    return JsonUtil.success("添加蛋糕一级类别成功");
                } else {
                    return JsonUtil.fail("添加蛋糕一级类别失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("添加蛋糕一级类别失败");
            }
        }
    }

    /**
     * 修改蛋糕一级类别
     * @param cakeClass
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClass/editCakeClass")
    public Object editCakeClass(CakeClass cakeClass){
        if(cakeClass == null){
            return JsonUtil.fail("修改蛋糕一级类别为空");
        } else {
            int flag = 0;
            try{
                flag = cakeClassService.editCakeClass(cakeClass);
                if(flag == 1){
                    return JsonUtil.success("修改蛋糕一级类别成功");
                } else {
                    return JsonUtil.fail("修改蛋糕一级类别失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("修改蛋糕一级类别失败");
            }
        }
    }

    /**
     * 通过id删除蛋糕一级类别
     * @param cakeclassId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeClass/removeCakeClass")
    public Object removeCakeClass(Integer cakeclassId){
        if(cakeclassId == null){
            return JsonUtil.fail("删除cakeclassId为空");
        } else {
            int flag = 0;
            try{
                flag = cakeClassService.removeCakeClass(cakeclassId);
                if(flag == 1){
                    return JsonUtil.success("删除蛋糕一级类别成功");
                } else {
                    return JsonUtil.fail("删除蛋糕一级类别失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("删除蛋糕一级类别失败");
            }
        }
    }
}
