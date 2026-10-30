package com.ofjrv.hangultypofix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JamoDecomposerTest {
    private final JamoDecomposer decomposer = new JamoDecomposer();

    @Test
    void decomposesHangulSyllablesAndKeepsStandaloneJamo() {
        assertEquals("ㅇㅏㅇㅣㅍㅐㄷㅡ", decomposer.decompose("아이패드"));
        assertEquals("ㄱㅘㄳ", decomposer.decompose("과ㄳ"));
    }
}
