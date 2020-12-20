package com.heima.heimasalespersion.infrastructure.acl;

import com.heima.heimasalespersion.FakeDbTest;
import com.heima.heimasalespersion.model.exceptions.ThirdException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 7788)
//因为要启动springboot,so 需要fake db，不然springboot无法启动
public class AclAdapterTest extends FakeDbTest {


    @Autowired
    private AclAdapter adapter;

    @Test
    public void pay_should_success_when_ali_success() {
        String response = "{\"message\":\"ok\",\"code\":0,\"seqNo\":\"seqNo\"}";
        stubFor(post(urlEqualTo("/pay"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(response)));

        adapter.aliPay("account", BigDecimal.valueOf(10));
    }

    @Test
    public void pay_should_exception_when_ali_error() {
        String response = "{\"message\":\"余额不足\",\"code\":100,\"seqNo\":\"seqNo\"}";
        stubFor(post(urlEqualTo("/pay"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json").withBody(response)));

        assertThrows(ThirdException.class,()->
            adapter.aliPay("account", BigDecimal.valueOf(10))
        ,"调用支付宝失败:余额不足")
       ;
    }

    @Test
    public void pay_should_success_when_wx_success() {
        String response = "{\"message\":\"ok\",\"code\":0,\"seqNo\":\"seqNo\"}";
        stubFor(post(urlEqualTo("/wxpay"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(response)));

        adapter.wxPay("account", BigDecimal.valueOf(10));
    }
    @Test
    public void pay_should_exception_when_wx_error() {
        String response = "{\"message\":\"余额不足\",\"code\":100,\"seqNo\":\"seqNo\"}";
        stubFor(post(urlEqualTo("/wxpay"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json").withBody(response)));

        assertThrows(ThirdException.class,()->
                        adapter.wxPay("account", BigDecimal.valueOf(10))
                ,"调用微信失败:余额不足")
        ;
    }
}