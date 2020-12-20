package com.heima.heimasalespersion.infrastructure.acl;

import java.math.BigDecimal;

public class ExtenalPaymentRequest {
    private String  account;
    private BigDecimal money;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
