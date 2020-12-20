package com.heima.heimasalespersion.userinterface.controller;

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
        service.payment(id, req.getPayType(), req.getPayAmount(),req.getAccount());
        return Result.ok();
    }
}
