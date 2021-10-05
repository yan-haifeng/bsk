package com.zime.bsk.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.zime.bsk.config.AlipayConfig;
import com.zime.bsk.entity.CakeCar;
import com.zime.bsk.entity.CakeInfo;
import com.zime.bsk.entity.CakeOrderInfo;
import com.zime.bsk.service.CakeCarService;
import com.zime.bsk.service.CakeInfoService;
import com.zime.bsk.service.CakeOrderInfoService;
import com.zime.bsk.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 94704
 * @DATE: 2019/12/11
 * @TIME: 14:15
 */
@Controller
@CrossOrigin
public class AlipayController {

    @Autowired
    private CakeInfoService cakeInfoService;
    @Autowired
    private CakeCarService cakeCarService;
    @Autowired
    private CakeOrderInfoService cakeOrderInfoService;

    private CakeOrderInfo cakeOrderInfo;

    @RequestMapping("/alipay/payPhone")
    public void alipayToPayPhone(CakeOrderInfo orderInfo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(orderInfo!=null && orderInfo.getOrderNo()!=null && orderInfo.getOrderCarid()!=null && orderInfo.getOrderPrice()!=null){
            cakeOrderInfo = orderInfo;
            // 商户订单号，商户网站订单系统中唯一订单号，必填
//            String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = format.format(new Date());
            String out1 = Math.random() * 1000000+"";
            String out_trade_no = out1.replace(".","") + time;
            out_trade_no = orderInfo.getOrderNo();
            // 订单名称，必填
//            String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
//            System.out.println(subject);
            String subject = "金美刀1";
            String[] carIds = orderInfo.getOrderCarid().split("\\?");
            if(carIds.length>1){
                subject = "多蛋糕购买";
            } else {
                List<CakeCar> cakeCars =  cakeCarService.getCakeCarById(Integer.parseInt(carIds[0]));
                List<CakeInfo> cakeInfos = cakeInfoService.getCakeInfoById(cakeCars.get(0).getCarCakeid());
                subject = cakeInfos.get(0).getCakeName();
            }
            // 付款金额，必填
//            String total_amount=new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
            String total_amount = "666.6";
            total_amount = orderInfo.getOrderPrice()+"";
            // 商品描述，可空
//            String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
            String body = "这是蛋糕";
            // 超时时间 可空
            String timeout_express="2m";
            // 销售产品码 必填
            String product_code=orderInfo.getOrderNo();
            /**********************/
            // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
            //调用RSA签名方式
            AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
            AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();

            // 封装请求支付信息
            AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
            model.setOutTradeNo(out_trade_no);
            model.setSubject(subject);
            model.setTotalAmount(total_amount);
            model.setBody(body);
            model.setTimeoutExpress(timeout_express);
            model.setProductCode(product_code);
            alipay_request.setBizModel(model);
            // 设置异步通知地址
            alipay_request.setNotifyUrl(AlipayConfig.notify_url);
            // 设置同步地址
            alipay_request.setReturnUrl(AlipayConfig.return_url);

            // form表单生产
            String form = "";
            try {
                // 调用SDK生成表单
                form = client.pageExecute(alipay_request).getBody();
                response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
//                response.getWriter().write(form);//直接将完整的表单html输出到页面
//                response.getWriter().flush();
//                response.getWriter().close();
                PrintWriter out = response.getWriter();
                out.write(form);
                out.flush();
                out.close();
            } catch (AlipayApiException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
            String temp = JSON.toJSONString(JsonUtil.fail("提交信息错误"));
            PrintWriter out = response.getWriter();
            out.write(temp);
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/alipay/pay")
    public void alipayToPay(CakeOrderInfo orderInfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(orderInfo!=null && orderInfo.getOrderNo()!=null && orderInfo.getOrderCarid()!=null && orderInfo.getOrderPrice()!=null){
            cakeOrderInfo = orderInfo;
            //获得初始化的AlipayClient
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,
                    AlipayConfig.RSA_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
                    AlipayConfig.SIGNTYPE);

            //设置请求参数
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);//同步
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);//异步

            //商户订单号，商户网站订单系统中唯一订单号，必填
            // 机器码 + 日期 + MD5（hotelId，roomID，当前时间毫秒数，百万单位随机数）取六位
           /* StringBuilder md5 = new StringBuilder("");
            md5.append(order.getHotelId());
            md5.append(order.getRoomId());
            md5.append(System.currentTimeMillis());
            md5.append(Math.random() * 1000000);
            String md5Str = MD5.getMd5(md5.toString(), 6);
            StringBuilder builder = new StringBuilder("");
            builder.append("aaaa");
            builder.append(DateUtil.format(new Date(), "yyyyMMddHHmmss"));
            builder.append(md5Str);
            order.setOrderNo(builder.toString());*/
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = format.format(new Date());
            String out1 = Math.random() * 1000000+"";
            String out_trade_no = out1.replace(".","") + time;
            out_trade_no = orderInfo.getOrderNo();
            //String out_trade_no = new String(req.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //付款金额，必填
            String total_amount = "10.0";
            total_amount = orderInfo.getOrderPrice()+"";
            //String total_amount = new String(req.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");

            //订单名称，必填
            String subject = "金美刀1";
            String[] carIds = orderInfo.getOrderCarid().split("\\?");
            if(carIds.length>1){
                subject = "多蛋糕购买";
            } else {
                List<CakeCar> cakeCars =  cakeCarService.getCakeCarById(Integer.parseInt(carIds[0]));
                List<CakeInfo> cakeInfos = cakeInfoService.getCakeInfoById(cakeCars.get(0).getCarCakeid());
                subject = cakeInfos.get(0).getCakeName();
            }
            // String subject = new String(req.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
            //商品描述，可空
            //String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");

            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"total_amount\":\""+ total_amount +"\","
                    + "\"subject\":\""+ subject +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
            //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
            //		+ "\"total_amount\":\""+ total_amount +"\","
            //		+ "\"subject\":\""+ subject +"\","
            //		+ "\"body\":\""+ body +"\","
            //		+ "\"timeout_express\":\"10m\","
            //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

            //请求
            //String result = null;
            AlipayTradePagePayResponse alipayResponse = null;
            try {
                alipayResponse = alipayClient.pageExecute(alipayRequest);
                System.out.println("========================");
                System.out.println(alipayResponse.getBody());
                System.out.println(alipayResponse.getMsg());
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write(alipayResponse.getBody());
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
            String temp = JSON.toJSONString(JsonUtil.fail("提交信息错误"));
            PrintWriter out = response.getWriter();
            out.write(temp);
            out.flush();
            out.close();
        }

    }

    @RequestMapping(value = "/alipay/alipayNotifyUrl")
    public String alipayNotifyUrl(HttpServletRequest request, HttpServletResponse response){
        try{
            System.out.println("==========异步请求==========");
            //获取支付宝POST过来反馈信息
            Map<String,String> params = new HashMap<String,String>();
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
                params.put(name, valueStr);
            }
            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
            //商户订单号

            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号

            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
            //计算得出通知验证结果
            //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
            boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
            PrintWriter out = response.getWriter();
            if(verify_result){//验证成功
                //////////////////////////////////////////////////////////////////////////////////////////
                //请在这里加上商户的业务逻辑程序代码

                //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

                if(trade_status.equals("TRADE_FINISHED")){
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                    //如果有做过处理，不执行商户的业务程序

                    //注意：
                    //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                    //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                } else if (trade_status.equals("TRADE_SUCCESS")){
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                    //如果有做过处理，不执行商户的业务程序

                    //注意：
                    //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                }
                CakeOrderInfo cakeOrder = new CakeOrderInfo();
                cakeOrder.setOrderId(cakeOrderInfo.getOrderId());
                cakeOrder.setOrderState(1);
                cakeOrderInfoService.editCakeOrderInfo(cakeOrder);
                //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
                //out.println("success");	//请不要修改或删除
                return "/bsk_success.html?CakePrice="+cakeOrderInfo.getOrderPrice();
                //////////////////////////////////////////////////////////////////////////////////////////
            }else{//验证失败
                //out.println("fail");
                return "/bsk_fail.html?CakePrice=111";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "redirect:/bsk_fail.html?CakePrice=222";
        }

    }

    @RequestMapping(value = "/alipay/alipayReturnUrl")
    public String alipayReturnUrl(HttpServletRequest request, HttpServletResponse response){
        try{
            //获取支付宝GET过来反馈信息
            Map<String,String> params = new HashMap<String,String>();
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
            //商户订单号

            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号

            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
            //计算得出通知验证结果
            //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
            boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
            PrintWriter out = response.getWriter();
            if(verify_result){//验证成功
                //////////////////////////////////////////////////////////////////////////////////////////
                //请在这里加上商户的业务逻辑程序代码
                //该页面可做页面美工编辑
                //out.println("验证成功<br />");
                //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
                CakeOrderInfo cakeOrder = new CakeOrderInfo();
                cakeOrder.setOrderId(cakeOrderInfo.getOrderId());
                cakeOrder.setOrderState(1);
                cakeOrderInfoService.editCakeOrderInfo(cakeOrder);
                return "redirect:/bsk_success.html?CakePrice="+cakeOrderInfo.getOrderPrice();
                //////////////////////////////////////////////////////////////////////////////////////////
            }else{
                //该页面可做页面美工编辑
                //out.println("验证失败");
                return "redirect:/bsk_fail.html?CakePrice=1111";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "redirect:/bsk_fail.html?CakePrice=2222";
        }

    }
}
