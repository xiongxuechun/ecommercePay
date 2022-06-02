package com.xxc.ecommercepay.service.impl;

import com.xxc.ecommercepay.EcommercePayApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: Xiong Xuechun
 * @Date: 2022/4/22 17:11
 */

public class PayServiceTest extends EcommercePayApplicationTests {

    @Autowired
    private PayService payService;

    @Test
    public void cerate(){
        payService.create("10707481107074", BigDecimal.valueOf(0.01));
    }


}