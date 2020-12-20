package com.heima.heimasalespersion.infrastructure.dao;

import com.heima.heimasalespersion.FakeDbTest;
import com.heima.heimasalespersion.model.takemoney.TakeMoney;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TakeMoneyRepositoryTest extends FakeDbTest {

    @Autowired
    public TakeMoneyRepository repository;

    @Test
    public void getOne_should_return_data_when_data_exists(){
        TakeMoney one = repository.getOne(1);
        assertThat(one.getUserId()).isEqualTo(2);
        assertThat(one.getMoney()).isEqualByComparingTo(BigDecimal.valueOf(100.11));
    }

}