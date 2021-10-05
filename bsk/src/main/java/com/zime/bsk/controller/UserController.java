package com.zime.bsk.controller;

import com.alibaba.fastjson.JSONObject;
import com.zime.bsk.context.MySessionContext;
import com.zime.bsk.entity.User;
import com.zime.bsk.service.UserService;
import com.zime.bsk.util.JsonUtil;
import com.zime.bsk.util.NodeCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:31
 */
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    private MySessionContext myc = MySessionContext.getInstance();

    private NodeCodeUtil nodeCodeUtil = new NodeCodeUtil();

    /**
     * 发送验证码
     * @param phoneNum
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPhoneCode")
    public Object getPhoneCode(String select, String phoneNum, HttpServletRequest request, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否发送Cookie
        String msg = isTruePhone(phoneNum);
        if(!"".equals(msg)){
            return JsonUtil.fail(msg);
        } else {
            User user = new User();
            user.setUserPhone(phoneNum);
            List<User> users = userService.getUserByPhone(user);
            if(select.equals("1") && users.size() == 1){
                return JsonUtil.fail("该账号以注册");
            } else if (select.equals("0") && users.size() == 0){
                return JsonUtil.fail("该账号不存在");
            }
            try{
                String getCode = nodeCodeUtil.getNodeCode(phoneNum);
//                String getCode = "{\"code\":200,\"msg\":\"1\",\"obj\":\"101773\"}";
                JSONObject jsonCode = JSONObject.parseObject(getCode);
                String code = jsonCode.get("code").toString();
                String obj = jsonCode.get("obj").toString();
                if(code.equals("200")){
                    request.getSession().setMaxInactiveInterval(20*60);
                    request.getSession().setAttribute(phoneNum, obj);
                    request.getSession().setAttribute("msg", code);
                    System.out.println(request.getSession().getId());
                    myc.AddSession(request.getSession());
                    return JsonUtil.success("验证码获取成功 "+obj).addSession(request.getSession().getId());
                } else {
                    request.getSession().setMaxInactiveInterval(10*60);
                    request.getSession().setAttribute("msg", code);
                    System.out.println(request.getSession().getId());
                    myc.AddSession(request.getSession());
                    return JsonUtil.fail("验证码获取失败"+code);
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("验证码获取失败");
            }
        }

    }

    /**
     * 通过验证码用户登录
     * @param user
     * @param code
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginByPhone")
    public Object loginByPhone(@RequestParam(value = "sessionid", defaultValue = "")String sessionid,
                               User user, @RequestParam(value = "code", defaultValue = "0")String code, HttpServletRequest request) {
        String msg = isTruePhone(user.getUserPhone());
        if(!"".equals(msg)){
            return JsonUtil.fail(msg);
        } else {
            List<User> users = userService.getUserByPhone(user);
            if(users.size() == 1){
                HttpSession sess = myc.getSession(sessionid);
                if(sessionid == null || "".equals(sessionid) || sess == null){
                    return JsonUtil.fail("没有验证码或验证码已过期");
                }
                if(sess.getAttribute(user.getUserPhone())==null){
                    return JsonUtil.fail("没有获取到验证码");
                }
                String phoneCode = sess.getAttribute(user.getUserPhone()).toString();
                String phoneCodeMsg = sess.getAttribute("msg").toString();
                System.out.println("phoneCode"+phoneCode);
                System.out.println("phoneCodeMsg"+phoneCodeMsg);
                if(phoneCode.equals(code)){
                    request.getSession().setMaxInactiveInterval(10*24*60*60);
                    request.getSession().setAttribute("userInfo", users.get(0));
                    System.out.println(request.getSession().getId());
                    myc.AddSession(request.getSession());
                    return JsonUtil.success("登录成功").addData(users).addSession(request.getSession().getId());
                } else {
                    return JsonUtil.fail("登录失败，验证码错误");
                }
            } else {
                return JsonUtil.fail("没有此用户");
            }
        }
    }

    /**
     * 通过手机号密码登录
     * @param user
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginByPwd")
    public Object loginByPwd(User user, HttpServletRequest request) {
        String msg = isTruePhone(user.getUserPhone());
        if(!"".equals(msg)){
            return JsonUtil.fail(msg);
        } else {
            List<User> users = userService.getUserByPhone(user);
            List<User> users1 = userService.getUserByPwd(user);
            if(users.size() == 1){
                if(users1.size() == 1){
                    request.getSession().setMaxInactiveInterval(10*24*60*60);
                    request.getSession().setAttribute("userInfo", users1.get(0));
                    System.out.println(request.getSession().getId());
                    myc.AddSession(request.getSession());
                    return JsonUtil.success("登录成功").addData(users1).addSession(request.getSession().getId());
                } else {
                    return JsonUtil.fail("登录失败，密码错误");
                }
            } else {
                return JsonUtil.fail("没有此用户");
            }
        }
    }

    /**
     * 判断用户是否登录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/isLogin")
    public Object isLogin(@RequestParam(value = "sessionid", defaultValue = "")String sessionid, HttpServletRequest request) {
        HttpSession sess = myc.getSession(sessionid);
        if(sessionid == null || "".equals(sessionid) || sess == null){
            return JsonUtil.fail("没有用户登录");
        }
        if(sess.getAttribute("userInfo")==null){
            return JsonUtil.fail("没有用户登录");
        } else {
            System.out.println(sess.getId());
            User user = (User)sess.getAttribute("userInfo");
            List<User> users = new ArrayList<>();
            users.add(user);
            return JsonUtil.success("已有用户登录").addData(users);
        }
    }

    /**
     * 退出登录用户
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/quitLogin")
    public Object quitLogin(@RequestParam(value = "sessionid", defaultValue = "")String sessionid, HttpServletRequest request) {
        HttpSession sess = myc.getSession(sessionid);
        if(sessionid == null || "".equals(sessionid) || sess == null){
            return JsonUtil.fail("没有用户登录");
        }
        if(sess.getAttribute("userInfo")==null){
            return JsonUtil.fail("没有用户登录,不需要退出");
        } else {
            User user = (User)sess.getAttribute("userInfo");
            myc.DelSession(sess);
            return JsonUtil.success(user.getUserName()+" 用户已退出");
        }
    }

    /**
     * 注册账户
     * @param user
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register")
    public Object register(@RequestParam(value = "sessionid", defaultValue = "")String sessionid,
                           User user, @RequestParam(value = "code", defaultValue = "0")String code){
        String msg = isTruePhone(user.getUserPhone());
        if(!"".equals(msg)){
            return JsonUtil.fail(msg);
        } else {
            if(user.getUserPwd()==null){
                return JsonUtil.fail("注册失败，密码为空");
            } else if(user.getUserPwd().length()<6){
                return JsonUtil.fail("注册失败，密码长度需大于6位");
            }
            List<User> users = userService.getUserByPhone(user);
            if(users.size() == 0){
                HttpSession sess = myc.getSession(sessionid);
                if(sessionid == null || "".equals(sessionid) || sess == null){
                    return JsonUtil.fail("没有验证码或验证码已过期");
                }
                if(sess.getAttribute(user.getUserPhone())==null){
                    return JsonUtil.fail("没有获取到验证码");
                }
                String phoneCode = sess.getAttribute(user.getUserPhone()).toString();
                String phoneCodeMsg = sess.getAttribute("msg").toString();
                System.out.println("phoneCode"+phoneCode);
                System.out.println("phoneCodeMsg"+phoneCodeMsg);
                if(phoneCode.equals(code)){
                    int flag = userService.addUser(user);
                    if(flag == 1){
                        return JsonUtil.success("注册成功");
                    } else {
                        return JsonUtil.fail("注册失败");
                    }
                } else {
                    return JsonUtil.fail("注册失败，验证码错误");
                }
            } else {
                return JsonUtil.fail("该手机号已注册");
            }
        }
    }

    /**
     * 中国电信号段 133、149、153、173、177、180、181、189、199
     * 中国联通号段 130、131、132、145、155、156、166、175、176、185、186
     * 中国移动号段 134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198
     * 其他号段
     * 14号段以前为上网卡专属号段，如中国联通的是145，中国移动的是147等等。
     * 虚拟运营商
     * 电信：1700、1701、1702
     * 移动：1703、1705、1706
     * 联通：1704、1707、1708、1709、171
     * 卫星通信：1349
     * @param phone
     * @return
     */
    public String isTruePhone(String phone){

        if(phone == null){
            return "手机号为空";
        } else if(phone.length()!=11){
            return "手机号不是11位";
        } else if(phone.length()==11) {
            String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if(!isMatch)
                return "请填入正确的手机号";
        }
        return "";
    }

    /**
     * 通过手机号查询用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/getUserByPhone")
    public Object getUserByPhone(User user) {
        if(user == null){
            return JsonUtil.fail("用户手机号为空");
        } else {
            String msg = isTruePhone(user.getUserPhone());
            if(!"".equals(msg)){
                return JsonUtil.fail(msg);
            } else {
                List<User> users = userService.getUserByPhone(user);
                if (users.size() == 1) {
                    return JsonUtil.success("查询成功").addData(users);
                } else if (users.size() == 0) {
                    return JsonUtil.fail("没有此用户");
                } else {
                    return JsonUtil.fail("有多个改手机号用户").addData(users);
                }
            }
        }

    }

    /**
     * 通过id查询用户
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/getUserById")
    public Object getUserById(Integer userId) {
        if(userId == null){
            return JsonUtil.fail("userId为空");
        } else {
            List<User> users = userService.getUserById(userId);
            if(users.size() == 1){
                return JsonUtil.success("查询成功").addData(users);
            } else {
                return JsonUtil.fail("没有此用户");
            }
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/editUser")
    public Object editUser(User user) {
        if(user == null){
            return JsonUtil.fail("修改用户信息为空");
        } else {
            int flag = userService.editUser(user);
            if(flag == 1){
                return JsonUtil.success("修改成功");
            } else {
                return JsonUtil.fail("修改失败");
            }
        }
    }

    /**
     * 通过id删除用户
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/removeUser")
    public Object removeUser(Integer userId) {
        if(userId == null){
            return JsonUtil.fail("删除userId为空");
        } else {
            int flag = userService.removeUser(userId);
            if(flag == 1){
                return JsonUtil.success("删除成功");
            } else {
                return JsonUtil.fail("删除失败");
            }
        }
    }

}
