package com.heima.heimasalespersion.infrastructure.dao;

import com.heima.heimasalespersion.model.takemoney.TakeMoneyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeMoneyPaymentRepository extends JpaRepository<TakeMoneyPayment, Integer>,
        JpaSpecificationExecutor<TakeMoneyPayment> {
}
