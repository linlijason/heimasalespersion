package com.heima.heimasalespersion.infrastructure.acl;

import com.heima.heimasalespersion.infrastructure.AliPaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "alipay",url = "${extenal.alipay.url}")
public interface AliApi {

    @PostMapping(value = "/pay")
    AliPaymentResponse pay(@RequestBody AliPaymentRequest request);
}
