package com.heima.heimasalespersion.infrastructure.acl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "alipay",url = "${extenal.alipay.url}")
public interface AliApi {

    @PostMapping(value = "/pay")
    ExtenalPaymentResponse pay(@RequestBody ExtenalPaymentRequest request);
}
