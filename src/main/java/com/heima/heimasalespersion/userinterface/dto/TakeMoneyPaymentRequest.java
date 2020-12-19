package com.heima.heimasalespersion.userinterface.dto;

import java.math.BigDecimal;

public class TakeMoneyPaymentRequest {
    private String payType;
    private BigDecimal payAmount;

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
