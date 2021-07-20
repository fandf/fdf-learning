package com.fandf.mall.pay.controller;

import com.alibaba.fastjson.JSON;
import com.fandf.mall.pay.model.PayLog;
import com.fandf.mall.pay.service.PayLogService;
import com.fandf.mall.util.RespResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/wx")
public class WeixinPayController {

    @Autowired
    private PayLogService payLogService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /***
     * 记录支付结果
     * 执行事务消息发送
     */
    @GetMapping(value = "/result")
    public RespResult payLog(){
        //记录日志
        PayLog payLog = new PayLog("1",1,"test","No001",new Date());
        Message message = MessageBuilder.withPayload(JSON.toJSONString(payLog)).build();
        rocketMQTemplate.sendMessageInTransaction("rocket","log",message,null);
        return RespResult.ok();
    }
}