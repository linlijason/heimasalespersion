package com.heima.heimasalespersion.infrastructure.acl;

import com.heima.heimasalespersion.model.exceptions.ThirdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AclAdapter {

    @Autowired
    private AliApi api;

    @Autowired
    private WxApi wxapi;

    public void aliPay(String account, BigDecimal money) {
        ExtenalPaymentResponse pay = api.pay(new ExtenalPaymentRequest() {{
            setAccount(account);
            setMoney(money);
        }});
        if (pay.getCode() != 0) {
            throw new ThirdException("调用支付宝失败:"+pay.getMessage());
        }
    }
    public void wxPay(String account,BigDecimal money){
        ExtenalPaymentResponse pay = wxapi.pay(new ExtenalPaymentRequest() {{
            setAccount(account);
            setMoney(money);
        }});
        if (pay.getCode() != 0) {
            throw new ThirdException("调用微信失败:"+pay.getMessage());
        }
    }
}
