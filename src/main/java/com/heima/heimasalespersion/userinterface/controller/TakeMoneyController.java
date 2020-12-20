package com.heima.heimasalespersion.userinterface.controller;

import com.heima.heimasalespersion.model.exceptions.ParamsErrorException;
import com.heima.heimasalespersion.service.takemoney.TakeMoneyService;
import com.heima.heimasalespersion.userinterface.Result;
import com.heima.heimasalespersion.model.takemoney.TakeMoneyPaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("takemoney")
public class TakeMoneyController {

    @Autowired
    private TakeMoneyService service;

    @PostMapping("/{id}/payment")
    public Result payment(@PathVariable("id") int id,
                          @RequestBody TakeMoneyPaymentRequest req) {
        if(req.getPayType().equals("支付宝") || req.getPayType().equals("微信")) {
            service.payment(id, req.getPayType(), req.getPayAmount(), req.getAccount());
        }else{
            throw new ParamsErrorException("支付方式错误");
        }
        return Result.ok();
    }
}
