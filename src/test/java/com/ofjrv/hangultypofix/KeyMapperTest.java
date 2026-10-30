package com.ofjrv.hangultypofix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeyMapperTest {
    private final KeyMapper keyMapper = new KeyMapper();

    @Test
    void mapsKeyboardTyposToHangul() {
        assertEquals("아이패드", keyMapper.map("dkdlvoem"));
    }

    @Test
    void combinesDoubleConsonantsAndCompoundVowels() {
        assertEquals("까", keyMapper.map("rrk"));
        assertEquals("과", keyMapper.map("rhk"));
        assertEquals("의", keyMapper.map("dml"));
    }

    @Test
    void movesFinalConsonantToNextSyllable() {
        assertEquals("아이", keyMapper.map("dkdl"));
    }
}
