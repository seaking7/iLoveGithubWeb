package com.poc.ilovegithubweb.interfaces.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class KoreanRankControllerTest {

	private MockMvc mockMvc;

	@Autowired
	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@Test
	void koreanUserRankTest() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/korean/user")
			.accept(MediaType.TEXT_HTML)
		);

		result.andDo(print())
			.andExpect(status().isOk())
			.andExpect(handler().handlerType(KoreanRankController.class))
			.andExpect(handler().methodName("koreanUserRank"));

	}
}
