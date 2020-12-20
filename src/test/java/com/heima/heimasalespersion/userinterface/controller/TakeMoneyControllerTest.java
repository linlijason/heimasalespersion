package com.heima.heimasalespersion.userinterface.controller;

import com.heima.heimasalespersion.model.exceptions.ThirdException;
import com.heima.heimasalespersion.service.takemoney.TakeMoneyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TakeMoneyController.class)
public class TakeMoneyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TakeMoneyService takeMoneyService;

    @Test
    public void payment_should_success_given_alipy_success() throws Exception {
        String requestJson="{\"payType\":\"支付宝\",\"payAmount\":11.11,\"account\":\"account\"}";
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                .post("/takemoney/1/payment")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson);
        mockMvc.perform(post)
                //.andDo(MockMvcResultHandlers.print())
                .andExpect(status().is(200));
        Mockito.verify(takeMoneyService).payment(1, "支付宝"
                , BigDecimal.valueOf(11.11)
                , "account");
    }
    @Test
    public void payment_should_500_given_happend_thirdException() throws Exception {
        String requestJson="{\"payType\":\"支付宝\",\"payAmount\":11.11,\"account\":\"account\"}";
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                .post("/takemoney/1/payment")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson);
        doThrow(new ThirdException("支付宝错误:余额不足")).when(takeMoneyService).payment(1,
                "支付宝",BigDecimal.valueOf(11.11),"account");

        mockMvc.perform(post)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is(500))
                .andExpect(content().json("{\"message\":\"支付宝错误:余额不足\"}"));

    }

}