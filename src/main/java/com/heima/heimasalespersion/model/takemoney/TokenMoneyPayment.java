package com.heima.heimasalespersion.model.takemoney;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "take_money_payment")
public class TokenMoneyPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="take_money_id")
    private Integer takeMoneyId;
    @Column(name="create_at")
    private LocalDateTime createAt;
    @Column(name="pay_type")
    private String payType;
    @Column(name="pay_seq_no")
    private String paySeqNo;

    public TokenMoneyPayment() {
    }

    public TokenMoneyPayment(Integer id, Integer takeMoneyId, LocalDateTime createAt, String payType, String paySeqNo) {
        this.id = id;
        this.takeMoneyId = takeMoneyId;
        this.createAt = createAt;
        this.payType = payType;
        this.paySeqNo = paySeqNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTakeMoneyId() {
        return takeMoneyId;
    }

    public void setTakeMoneyId(Integer takeMoneyId) {
        this.takeMoneyId = takeMoneyId;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPaySeqNo() {
        return paySeqNo;
    }

    public void setPaySeqNo(String paySeqNo) {
        this.paySeqNo = paySeqNo;
    }
}
