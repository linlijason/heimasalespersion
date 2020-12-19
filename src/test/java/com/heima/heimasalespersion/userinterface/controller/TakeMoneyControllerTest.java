package com.heima.heimasalespersion.userinterface.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heima.heimasalespersion.service.takemoney.TokenMoneyService;
import com.heima.heimasalespersion.userinterface.dto.TakeMoneyPaymentRequest;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@ActiveProfiles("test")
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@EnableAutoConfiguration(exclude= DataSourceAutoConfiguration.class)

@WebMvcTest(TakeMoneyController.class)
public class TakeMoneyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TokenMoneyService tokenMoneyService;

    @Test
    public void payment_should_success_given_alipy_success() throws  Exception{
        TakeMoneyPaymentRequest request=new TakeMoneyPaymentRequest();
        request.setPayAmount(BigDecimal.valueOf(11.11));
        request.setPayType("支付宝");
        ObjectMapper mapper=new ObjectMapper();

        MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                .post("/takemoney/1/payment", request)
                .contentType(MediaType.APPLICATION_JSON).content(    mapper.writeValueAsString(request));
        mockMvc.perform(post)
                //.andDo(MockMvcResultHandlers.print())
                .andExpect(status().is(200));
        Mockito.verify(tokenMoneyService).payment(1,"支付宝",BigDecimal.valueOf(11.11));
    }

}