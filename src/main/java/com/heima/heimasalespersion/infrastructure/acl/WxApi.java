package com.heima.heimasalespersion.infrastructure.acl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "wxApi",url = "${extenal.wx.url}")
public interface WxApi {

    @PostMapping(value = "/wxpay")
    ExtenalPaymentResponse pay(@RequestBody ExtenalPaymentRequest request);
}
