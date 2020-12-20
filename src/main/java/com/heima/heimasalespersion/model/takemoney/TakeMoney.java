package com.heima.heimasalespersion.model.takemoney;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "take_money")
public class TakeMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="money")
    private BigDecimal money;
    @Column(name="create_at")
    private LocalDateTime createAt;

    public TakeMoney() {
    }

    public TakeMoney(Integer id, Integer userId, BigDecimal money, LocalDateTime createAt) {
        this.id = id;
        this.userId = userId;
        this.money = money;
        this.createAt = createAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
