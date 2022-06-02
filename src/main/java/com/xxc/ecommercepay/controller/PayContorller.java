package com.xxc.ecommercepay.controller;

import com.lly835.bestpay.model.PayResponse;
import com.xxc.ecommercepay.service.impl.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xiong Xuechun
 * @Date: 2022/5/16 16:48
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayContorller {
    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("amount") BigDecimal amount) {

        PayResponse response = payService.create(orderId, amount);

        Map map = new HashMap<>();
        map.put("codeUrl", response.getCodeUrl());

        return new ModelAndView("create", map);
    }

    @PostMapping("/notify")
    @ResponseBody
    public String asyncNotify(@RequestBody String notifyData) {

        return payService.asyncNotify(notifyData);
    }
}
