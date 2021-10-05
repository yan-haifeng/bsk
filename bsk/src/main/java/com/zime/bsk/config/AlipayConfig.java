package com.zime.bsk.config;

/**
 * @Author: 94704
 * @DATE: 2019/12/11
 * @TIME: 15:48
 */
public class AlipayConfig {
    // 商户appid
    public static String APPID = "2016101600701291";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDzQG0nW267NUjofhjhUPL0PGQWA1wEndGspArzbOHZqYfmWQ8pgU263B3QQAoENFBbUz/u5bPZMt4fcpGKX8+1a4REMCeHDKzVGY/hVImx/D+kseEVgTzkGP8ZGfRD45FX2v6sY3GS+UZV9FsHNrk42g6kAXT9QEdAlpy1IzOnx7X0fZ45QZk1zGuF3WEE5gVko53eWg30/w3+GLDip/iNNYSx3TQguPyZTqkGokdRhYj/5hLxvs6XnzLh3bLmdBdqrAWbG+tXutF6psS6mA4ri2HQ2rF8wbJakKQVlhBYb2Z4F7mmHg3VkLja07NuFCVYInpzz2Lgb0d5SCT7Lx23AgMBAAECggEAUBFw3HeYJz8O1JhNED1Y+1O1jhlk/JAGKFGG2UGJxd+rwAKonvzU3SD/H0E1CtU9bhIlBTnOzTuVKbzIc0e+UvUlAFzpZeaiLTLQzVbKTC+/szJp6G414M7piRWl9YK+oLCRC6VgCQTMRha8r88vgKsmDo38ODAkQ/pPcsA3jI3n46sLTpCi/Aur01lU6oar2Ed7oMVDxhgMZ69i22FZkP6WbPzd+tuO1e8myS3Z9llsFSRfIOLuwY3k2/9IJI6VVBtRXeuE1GBSTLVZiQkmUcELH/FfFVuwvU9ay7EjylEHQKLws8oH/z2DE/M+ECrFsXXjgsqXqsGpJNUSe/7soQKBgQD+Hvujrs2CkbIkC568T9UJgk2aYO7rJbc7QiqfbHPCuHe/2Xd2gD+VL1kjZmCOmkxcnvg8SfM3Gk6M4G1F+4JVkdg9wQ8qmChE2ZnqzxTcciABS+d1CRkQlCglNXFQ2eo8sRsvTnrxSToP5Zzsa9dnYj/GTioszqhTukpu9ORwxQKBgQD1DN6B/4M2b+cb9crpNOe0jP6sAGwUMmXXY6PkPQyD15ZsjuBdgWlKuZaffh52WgySN2+RYiJGN4cpYJCz4r9SpI5pO0F1UkkJIL7tl12bQsEwwP4SE70Q73e7XMASkkHttZY6nA4Pw5MPeTKTgw7dbfyoXd7/y+MaNrqZGnMESwKBgQD4c7xd1UsSbHY57a59uKO2D1LmK/2LpC1YX6GiivtHFunlha3aCxufNVK2XKLs6YjdSYO0Fi0X472G2OmdcYCFPvmnrviwEWHVptZoj5x6x43pFpgugf2iiugRMQYgIV51hkbo4pcrDwgYgMsDD5DjgFiP/t4XPtmuOsYJY59xbQKBgFnlULNL8uzDfHrrXnbS67V2i+65cOyv2GB9syAFrVOogQxuFaz3zpKVJsZ30+EDA92X7Jve7kfoEvOA81SqeBlvOLct/8N0Xkq08pXik3pjsM+b3RjwmMlfsALR8bxeX0U++k+h9B6gVpC0m3M1/vwIX0m8thQMzdFOBoIoC82lAoGBAPthUKl/slzZSD7S215f+z2NVdJLktwkizBkqfwH/XXmIUlAxGwvmLsabTPx1pU1YjsCHwcyBruuSjOGMZp3cutFKLM44yLXy/qh4Gev50MNY4ljCDHVdzmDPRgHCqYLRtwq1+BEZ86EIL7B25B3oHA0fhQ9lRESwZz8jMzRT9GU";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.reloss.top:8888/bsk/alipay/alipayNotifyUrl";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://www.reloss.top:8888/bsk/alipay/alipayReturnUrl";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmylbtHC6+YvCTbarVEAq3hON7T8jKaDau6Mu+KN+TSpcc1LUONpWxDSs8BG3t/ljjlEGF+yWRI7ljFAYflk4uX9aZSa8OX7XyXCFaQUzp412o1r4t04OoG64yzAkJQ34yGRZP3bUfBKwC5hGmotEMJmNlhtFaonP8lyTD0/LI7vPULxjPFOtSd2YW8TS0SVtFGRtPy6t0WPnTfIVJ0PVD7Gr3nZRR3IMQok2OyHPOHKFxT6f55e9efnxw9D3BiQcmedEcgXaGZBwSm2/1uBtDUVNot79Bjpw8y4IAYaioiIjwAbOZg3ZEaCR/xSPIuK4Ni+TV+HLzI8ejLlG+w2YcwIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
