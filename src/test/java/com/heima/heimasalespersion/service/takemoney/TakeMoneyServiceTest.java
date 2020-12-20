package com.heima.heimasalespersion.service.takemoney;

import com.heima.heimasalespersion.infrastructure.acl.AclAdapter;
import com.heima.heimasalespersion.infrastructure.dao.TakeMoneyPaymentRepository;
import com.heima.heimasalespersion.infrastructure.dao.TakeMoneyRepository;
import com.heima.heimasalespersion.model.takemoney.TakeMoney;
import com.heima.heimasalespersion.model.takemoney.TakeMoneyPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;


@RunWith(MockitoJUnitRunner.class)
public class TakeMoneyServiceTest {


    @InjectMocks
    private TakeMoneyService service;

    @Mock
    private TakeMoneyRepository takeMoneyRepository;

    @Mock
    private TakeMoneyPaymentRepository takeMoneyPaymentRepository;

    @Mock
    private AclAdapter aclAdapter;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void payment_should_success_when_dao_success_and_aliacl_success() {
        int id = 1;
        BigDecimal money = BigDecimal.valueOf(10.1);
        Mockito.when(takeMoneyRepository.getOne(id)).thenReturn(new TakeMoney() {{
            setId(id);
        }});
        service.payment(id, "支付宝", money, "account");

        Mockito.verify(takeMoneyPaymentRepository).save(ArgumentMatchers.argThat(a -> a.getTakeMoneyId()==id
        && a.getAccount().equals("account") && a.getStatus().equals("支付中")));
        Mockito.verify(aclAdapter).aliPay("account", money);

    }
    @Test
    public void payment_should_success_when_dao_success_and_wxacl_success() {
        int id = 1;
        BigDecimal money = BigDecimal.valueOf(10.1);
        Mockito.when(takeMoneyRepository.getOne(id)).thenReturn(new TakeMoney() {{
            setId(id);
        }});
        service.payment(id, "微信", money, "account");

        Mockito.verify(takeMoneyPaymentRepository).save(ArgumentMatchers.argThat(a -> a.getTakeMoneyId()==id
                && a.getAccount().equals("account") && a.getStatus().equals("支付中")));
        Mockito.verify(aclAdapter).wxPay("account", money);

    }

}