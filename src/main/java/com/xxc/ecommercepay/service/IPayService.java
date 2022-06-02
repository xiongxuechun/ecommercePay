package com.xxc.ecommercepay.service;

import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

/**
 * @Author: Xiong Xuechun
 * @Date: 2022/4/22 16:45
 */

public interface IPayService {
    /**
     * 创建/发起支付
     */
    PayResponse create(String order, BigDecimal amount);

    /**
     * @Author: Xiong Xuechun
     * @Description: 异步通知处理
     * @DateTime: 2022/5/17 16:00
     * @Params:
     * @Return
     */
    String asyncNotify(String notifyData);


}
