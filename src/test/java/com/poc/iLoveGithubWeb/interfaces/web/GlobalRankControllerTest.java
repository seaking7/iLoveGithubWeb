package com.poc.iLoveGithubWeb.interfaces.web;

import com.poc.iLoveGithubWeb.config.WebConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import(WebConfig.class)
//@WebMvcTest(GlobalRankController.class)
@AutoConfigureMockMvc       //@Service, @Repository 등 같이 구동
@SpringBootTest
class GlobalRankControllerTest {

    private final MockMvc mvc;

    @Autowired
    GlobalRankControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }


    @DisplayName("글로벌 유저 조회 View ")
    @Test
    void globalUserRank() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/global/user")
                                .queryParam("page", "0")
                                .queryParam("size", "30")
                                .queryParam("sortBy", "StargazersCount")
                        )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(handler().handlerType(GlobalRankController.class))
                .andExpect(handler().methodName("globalUserRank"))
                .andExpect(view().name("globalRank/userRank"))
                .andExpect(model().attributeExists("userRanks"));
    }
}