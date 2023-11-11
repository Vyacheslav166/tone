package com.task.tone.controller;

import com.task.tone.exception.BadRequestException;
import com.task.tone.service.AnalyticStringService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AnalyticStringControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AnalyticStringService analyticStringService;

    @Test
    public void badString_thenReturnBadRequest() throws Exception {
        given(analyticStringService.giveCountCharacterInString(Mockito.any()))
                .willThrow(new BadRequestException("Bad string"));

        String string = "";
        mockMvc.perform(post("/service/string")
                        .content(string))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void testString_thenReturnMapChar() throws Exception {
        String string = "aaab";
        HashMap<Character, Integer> dataMap = new HashMap<>();
        dataMap.put('a', 3);
        dataMap.put('b', 1);
        given(analyticStringService.giveCountCharacterInString(string))
                .willReturn(dataMap);

        mockMvc.perform(post("/service/string")
                .content(string))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andDo(print());
    }
}
