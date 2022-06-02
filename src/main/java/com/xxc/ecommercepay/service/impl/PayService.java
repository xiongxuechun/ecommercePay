package com.xxc.ecommercepay.service.impl;

import com.lly835.bestpay.config.AliPayConfig;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.xxc.ecommercepay.service.IPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: Xiong Xuechun
 * @Date: 2022/4/22 16:48
 */

@Slf4j
@Service
public class PayService implements IPayService {

    @Autowired
    private BestPayService bestPayService;

    @Override
    public PayResponse create(String order, BigDecimal amount) {


        //支付宝配置
        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId("xxxxxx");
        aliPayConfig.setPrivateKey("xxxxxx");
        aliPayConfig.setAliPayPublicKey("xxxxxx");
        aliPayConfig.setReturnUrl("http://xxxxx");
        aliPayConfig.setNotifyUrl("http://xxxxx");

        //支付类, 所有方法都在这个类里

//        bestPayService.setAliPayConfig(aliPayConfig);

        PayRequest payRequest = new PayRequest();
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);
        payRequest.setOrderId(order);
        payRequest.setOrderName("1070748110707481");
        payRequest.setOrderAmount(amount.doubleValue());
//        payRequest.setOpenid("openid_xxxxxx");
        bestPayService.pay(payRequest);

        PayResponse response = bestPayService.pay(payRequest);
        log.info("response={}", response);
        return response;
    }

    /**
     * @Author: Xiong Xuechun
     * @Description: 异步通知处理
     * @DateTime: 2022/5/18 14:26
     * @Params:
     * @Return
     */
    @Override
    public String asyncNotify(String notifyData) {
        //1、签名验证
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("payResponse={}", payResponse);

        //2、金额校验（从数据库查订单）
        //3、修改订单支付状态
        //4、告诉微信不要再通知了
        return "<xml>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>";
    }


}
