package com.heima.heimasalespersion.userinterface.controller;

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

}