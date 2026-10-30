package com.ofjrv.hangultypofix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistanceTest {
    private final EditDistance editDistance = new EditDistance();
    private final JamoDecomposer decomposer = new JamoDecomposer();

    @Test
    void measuresJamoLevelDistance() {
        assertEquals(1, editDistance.distance(
                decomposer.decompose("아잇패드"),
                decomposer.decompose("아이패드")
        ));
    }

    @Test
    void measuresInsertionsDeletionsAndSubstitutions() {
        assertEquals(2, editDistance.distance("ㄱㅏㅁ", "ㄴㅏ"));
        assertEquals(0, editDistance.distance("", ""));
    }
}
