package com.heima.heimasalespersion.model.takemoney;

import java.math.BigDecimal;

public class TakeMoneyPaymentRequest {
    private String payType;
    private BigDecimal payAmount;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
}
