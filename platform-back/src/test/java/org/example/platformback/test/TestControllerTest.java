package org.example.platformback.test;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("secret key 조회 테스트")
    public void test() throws Exception {
        try {
            mockMvc.perform(get("/secret").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (AssertionError e) {
            System.err.println("테스트가 실패하였습니다: " + e.getMessage());
            throw e; // 실패를 다시 throw하여 테스트가 실패했음을 나타냄
        }
    }
}