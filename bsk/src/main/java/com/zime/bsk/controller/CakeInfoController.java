package com.zime.bsk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.jmx.snmp.tasks.ThreadService;
import com.zime.bsk.entity.CakeInfo;
import com.zime.bsk.entity.CakeSpecs;
import com.zime.bsk.service.CakeInfoService;
import com.zime.bsk.service.CakeSpecsService;
import com.zime.bsk.util.JsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static java.lang.Thread.sleep;

/**
 * @Author: 94704
 * @DATE: 2019/11/22
 * @TIME: 11:07
 */
@Controller
@CrossOrigin
public class CakeInfoController {

    @Autowired
    private CakeInfoService cakeInfoService;
    @Autowired
    private CakeSpecsService cakeSpecsService;

    //今日折扣蛋糕
    private List<CakeInfo> cakeInfoDay;
    //所有蛋糕信息
    private static List<CakeInfo> cakeInfoAll;
    //随机人气蛋糕显示
    private static Map<Integer, List<CakeInfo>> cakeInfoRandomMap = new HashMap<>();

//    public CakeInfoController(){
//        //每个1天更新一次
//        runUpateTime(12, 0);
//    }

    /**
     * 获取今日折扣蛋糕
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/getCakeInfoByDay")
    public Object getCakeInfoByDay(){
        try{
            if(cakeInfoDay != null && cakeInfoDay.size()>0){
                return JsonUtil.success("获取今日折扣蛋糕成功").addData(cakeInfoDay).addCount(cakeInfoDay.size());
            } else {
                cakeInfoDay = cakeInfoService.getCakeInfoByDay();
                splitImgAndSpecs(cakeInfoDay);
                return JsonUtil.success("获取今日折扣蛋糕成功").addData(cakeInfoDay).addCount(cakeInfoDay.size());
            }
        } catch (Exception e){
            e.printStackTrace();
            return JsonUtil.fail("获取今日折扣蛋糕失败").addData(Arrays.asList(e.getStackTrace()));
        }
    }

    /**
     * 获取人气蛋糕
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/getCakeInfoByPopulity")
    public Object getCakeInfoByPopulity(
            @RequestParam(value = "randomNum", defaultValue = "1")Integer randomNum,
            @RequestParam(value = "randomSize", defaultValue = "3")Integer randomSize){
        try{
            cakeInfoAll = cakeInfoService.getAllCakeInfo();
            if(randomNum==null || randomSize==null) {
                return JsonUtil.fail("randomNum||randomSize为空");
            }
            if(cakeInfoAll.size()<randomSize){
                return JsonUtil.fail("所获取数量大于总数量为空");
            }
            if(cakeInfoRandomMap.get(randomNum)!=null && cakeInfoRandomMap.get(randomNum).size()==randomSize)
                return JsonUtil.success("获取"+randomNum+"个 蛋糕获取成功").addData(cakeInfoRandomMap.get(randomNum)).addCount(randomSize);
            HashSet<Integer> set = new HashSet<>();
            List<CakeInfo> cakeInfoRandom = new ArrayList<CakeInfo>();
            Random r = new Random();
            for(; set.size()<randomSize; ){
                int flag = r.nextInt(cakeInfoAll.size());
                if(!set.contains(flag)){
                    set.add(flag);
                    cakeInfoRandom.add(cakeInfoAll.get(flag));
                }
            }
            splitImgAndSpecs(cakeInfoRandom);
            cakeInfoRandomMap.put(randomNum, cakeInfoRandom);
            return JsonUtil.success("获取"+randomNum+"个 蛋糕获取成功").addData(cakeInfoRandom).addCount(cakeInfoRandom.size());
        } catch (Exception e){
            e.printStackTrace();
            return JsonUtil.fail("获取人气蛋糕失败").addData(Arrays.asList(e.getStackTrace()));
        }
    }

    /**
     * 获取所有蛋糕信息-默认不分页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/getAllCake")
    public Object getAllCake(@RequestParam(value="page", defaultValue="0") Integer page,
                             @RequestParam(value="limit", defaultValue="0")Integer limit){
        try{
            int count = cakeInfoService.getAllCakeInfo().size();
            int sumPage = (int)Math.ceil(count*1.0/limit);  //向上取整计算总页数
            PageHelper.startPage(page, limit);
            List<CakeInfo> cakeInfoList = cakeInfoService.getAllCakeInfo();
            splitImgAndSpecs(cakeInfoList);
            PageInfo<CakeInfo> pageInfo = new PageInfo<>(cakeInfoList);
            if(page==0 || limit==0){
                return JsonUtil.success("所有蛋糕获取成功").addData(pageInfo.getList()).addCount(count);
            } else {
                return JsonUtil.success(page+"/"+sumPage+"页"+limit+"/"+"条 所有蛋糕获取成功").addData(pageInfo.getList()).addCount(count);
            }
        } catch (Exception e){
            e.printStackTrace();
            return JsonUtil.fail("查询所有蛋糕失败").addData(Arrays.asList(e.getStackTrace()));
        }
    }

    /**
     * 通过一级类别id获取所有蛋糕-默认不分页
     * @param cakeClassid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/getAllCakeInfoByClassId")
    public Object getAllCakeInfoByClassId(Integer cakeClassid,
                                          @RequestParam(value="page", defaultValue="0") Integer page,
                                          @RequestParam(value="limit", defaultValue="0")Integer limit){
        if(cakeClassid == null){
            return JsonUtil.fail("cakeClassid为空");
        } else {
            int count = cakeInfoService.getAllCakeInfoByClassId(cakeClassid).size();
            int sumPage = (int)Math.ceil(count*1.0/limit);  //向上取整计算总页数
            PageHelper.startPage(page, limit);
            List<CakeInfo> cakeInfoList = cakeInfoService.getAllCakeInfoByClassId(cakeClassid);
            splitImgAndSpecs(cakeInfoList);
            PageInfo<CakeInfo> pageInfo = new PageInfo<>(cakeInfoList);
            if(page==0 || limit==0){
                return JsonUtil.success("通过一级类别id获取所有蛋糕成功").addData(pageInfo.getList()).addCount(count);
            } else {
                return JsonUtil.success(page+"/"+sumPage+"页"+limit+"/"+"条 通过一级类别id获取所有蛋糕成功").addData(pageInfo.getList()).addCount(count);
            }
        }
    }

    /**
     * 通过二级类别id获取所有蛋糕-默认不分页
     * @param cakeClassminid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/getAllCakeInfoByClassMinId")
    public Object getAllCakeInfoByClassMinId(Integer cakeClassminid,
                                             @RequestParam(value="page", defaultValue="0") Integer page,
                                             @RequestParam(value="limit", defaultValue="0")Integer limit){
        if(cakeClassminid == null){
            return JsonUtil.fail("cakeClassminid为空");
        } else {
            int count = cakeInfoService.getAllCakeInfoByClassMinId(cakeClassminid).size();
            int sumPage = (int)Math.ceil(count*1.0/limit);  //向上取整计算总页数
            PageHelper.startPage(page, limit);
            List<CakeInfo> cakeInfoList = cakeInfoService.getAllCakeInfoByClassMinId(cakeClassminid);
            splitImgAndSpecs(cakeInfoList);
            PageInfo<CakeInfo> pageInfo = new PageInfo<>(cakeInfoList);
            if(page==0 || limit==0){
                return JsonUtil.success("通过二级类别id获取所有蛋糕成功").addData(pageInfo.getList()).addCount(count);
            } else {
                return JsonUtil.success(page+"/"+sumPage+"页"+limit+"/"+"条 通过二级类别id获取所有蛋糕成功").addData(pageInfo.getList()).addCount(count);
            }
        }
    }

    /**
     * 通过id获取蛋糕信息
     * @param cakeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/getCakeById")
    public Object getCakeById(Integer cakeId){
        if(cakeId == null){
            return JsonUtil.fail("cakeId为空");
        } else {
            try{
                List<CakeInfo> cakeInfoList = cakeInfoService.getCakeInfoById(cakeId);
                splitImgAndSpecs(cakeInfoList);
                return JsonUtil.success("id蛋糕获取成功").addData(cakeInfoList);
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("获取蛋糕失败");
            }
        }
    }

    /**
     * 添加蛋糕信息
     * @param cakeInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/addCakeInfo")
    public Object addCakeInfo(CakeInfo cakeInfo){
        if(cakeInfo == null){
            return JsonUtil.fail("添加蛋糕信息为空");
        } else {
            int flag = 0;
            try{
                flag = cakeInfoService.addCakeInfo(cakeInfo);
                if(flag == 1){
                    return JsonUtil.success("添加蛋糕信息成功");
                } else {
                    return JsonUtil.fail("添加蛋糕信息失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("添加蛋糕信息失败");
            }
        }
    }

    /**
     * 修改蛋糕信息
     * @param cakeInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/editCakeInfo")
    public Object editCakeInfo(CakeInfo cakeInfo){
        if(cakeInfo == null){
            return JsonUtil.fail("修改蛋糕信息为空");
        } else {
            int flag = 0;
            try{
                flag = cakeInfoService.editCakeInfo(cakeInfo);
                if(flag == 1){
                    return JsonUtil.success("修改蛋糕信息成功");
                } else {
                    return JsonUtil.fail("修改蛋糕信息失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("修改蛋糕信息失败");
            }
        }
    }

    /**
     * 通过蛋糕id删除蛋糕信息
     * @param cakeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/removeCakeInfo")
    public Object removeCakeInfo(Integer cakeId){
        if(cakeId == null){
            return JsonUtil.fail("cakeId为空");
        } else {
            int flag = 0;
            try{
                flag = cakeInfoService.removeCakeInfo(cakeId);
                if(flag == 1){
                    return JsonUtil.success("删除蛋糕信息成功");
                } else {
                    return JsonUtil.fail("删除蛋糕信息失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("删除蛋糕信息失败");
            }
        }
    }

    /**
     * 更改首页折扣蛋糕和精品蛋糕的随机时间-更新时间h小时m分钟
     * @param h
     * @param m
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeInfo/setUpdateTime")
    public Object setUpdateTime(@RequestParam(value = "h", defaultValue = "1")Integer h,
                                @RequestParam(value = "m", defaultValue = "30")Integer m){
        try{
            runUpateTime(h, m);
            return JsonUtil.success("设置更新时间成功为： "+h+"小时 "+m+"分钟");
        } catch (Exception e){
            e.printStackTrace();
            return JsonUtil.fail("设置更新时间失败");
        }
    }

    //处理图片分割
    private void splitImgAndSpecs(List<CakeInfo> cakeInfos){
        for(int i=0; i<cakeInfos.size(); i++){
            String[] imgs = cakeInfos.get(i).getCakeImg().split("\\?");
            cakeInfos.get(i).setCakeImgList(Arrays.asList(imgs));
            cakeInfos.get(i).setCakeImg(cakeInfos.get(i).getCakeImgList().get(0));
            cakeInfos.get(i).setCakeSpecsList(cakeSpecsService.getAllCakeSpecsByCakeId(cakeInfos.get(i).getCakeId()));
        }
    }

    //每个一段时间清空蛋糕临时信息
    public static void runUpateTime(Integer h, Integer m) {
        long timeInterval = h*60*60*1000 + m*60*1000;// 两分钟运行一次
        while (true) {
            try{
                cakeInfoAll.clear();
                cakeInfoRandomMap.clear();
                System.out.println("更新蛋糕");
                sleep(timeInterval);   //间隔1秒执行一次！
            } catch (Exception e){

            }
        }
    }

}
