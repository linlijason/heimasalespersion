package com.heima.heimasalespersion.service.takemoney;

import com.heima.heimasalespersion.infrastructure.acl.AclAdapter;
import com.heima.heimasalespersion.infrastructure.dao.TakeMoneyPaymentRepository;
import com.heima.heimasalespersion.infrastructure.dao.TakeMoneyRepository;
import com.heima.heimasalespersion.model.takemoney.TakeMoney;
import com.heima.heimasalespersion.model.takemoney.TakeMoneyPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TakeMoneyService {

    @Autowired
    private TakeMoneyRepository takeMoneyRepository;

    @Autowired
    private TakeMoneyPaymentRepository takeMoneyPaymentRepository;

    @Autowired
    private AclAdapter aclAdapter;

    public void payment(int id, String payType, BigDecimal amount,String account) {
        TakeMoney tokeMoney = takeMoneyRepository.getOne(id);
        if(payType.equals("支付宝"))
             aclAdapter.aliPay(account, amount);
        if(payType.equals("微信")){
            aclAdapter.wxPay(account, amount);
        }

        TakeMoneyPayment payment = new TakeMoneyPayment(null, tokeMoney.getId(), LocalDateTime.now(),
                payType, account, "", "支付中");

        takeMoneyPaymentRepository.save(payment);
    }

}
