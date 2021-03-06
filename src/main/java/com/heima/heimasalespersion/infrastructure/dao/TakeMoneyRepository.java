package com.heima.heimasalespersion.infrastructure.dao;

import com.heima.heimasalespersion.model.takemoney.TakeMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeMoneyRepository extends JpaRepository<TakeMoney, Integer>,
        JpaSpecificationExecutor<TakeMoney> {

}
