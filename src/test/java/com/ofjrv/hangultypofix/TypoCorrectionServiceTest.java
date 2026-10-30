package com.ofjrv.hangultypofix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TypoCorrectionServiceTest {
    @Autowired
    private TypoCorrectionService correctionService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void correctsKeyboardTypo() {
        CorrectionResponse response = correctionService.correct("dkdlvoem");

        assertEquals(TypoType.KEYBOARD, response.type());
        assertEquals("아이패드", response.mapped());
        assertEquals("아이패드", response.candidates().get(0).word());
        assertEquals(0, response.candidates().get(0).distance());
    }

    @Test
    void correctsJamoSpellingTypo() {
        CorrectionResponse response = correctionService.correct("아잇패드");

        assertEquals(TypoType.SPELLING, response.type());
        assertTrue(response.candidates().stream().anyMatch(candidate ->
                candidate.word().equals("아이패드") && candidate.distance() == 1));
    }

    @Test
    void findsGalaxyForKeyboardTypo() {
        CorrectionResponse response = correctionService.correct("rkfortl");

        assertTrue(response.candidates().stream().anyMatch(candidate ->
                candidate.word().equals("갤럭시")));
    }

    @Test
    void servesCorrectionApi() throws Exception {
        mockMvc.perform(get("/api/correct").param("q", "dkdlvoem"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mapped").value("아이패드"))
                .andExpect(jsonPath("$.candidates[0].distance").value(0));
    }

    @Test
    void rejectsBlankQueries() throws Exception {
        mockMvc.perform(get("/api/correct").param("q", " "))
                .andExpect(status().isBadRequest());
    }
}
