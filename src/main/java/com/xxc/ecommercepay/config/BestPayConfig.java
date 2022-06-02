package com.xxc.ecommercepay.config;

import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: Xiong Xuechun
 * @Date: 2022/5/17 15:47
 */

@Component
public class BestPayConfig {

    @Bean
    public BestPayService bestPayService() {
        //微信支付配置
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId("wxd898fcb01713c658");          //公众号Id
//        wxPayConfig.setMiniAppId("wxab8ae5e8323c1788");      //小程序Id
//        wxPayConfig.setAppAppId("xxxxx");       //移动AppId
        //支付商户资料
        wxPayConfig.setMchId("1483469312");
        wxPayConfig.setMchKey("7mdApPMfXddfWWbbP4DUaVYm2wjyh3v3");
        wxPayConfig.setNotifyUrl(" http://xiongxuechun.natapp1.cc/pay/notify");
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        return bestPayService;
    }
}
