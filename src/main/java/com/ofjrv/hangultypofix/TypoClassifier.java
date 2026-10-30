package com.ofjrv.hangultypofix;

import org.springframework.stereotype.Component;

// 영문만 있으면 자판 오타로 판단해.
@Component
public class TypoClassifier {
    public TypoType classify(String input) {
        return input.matches("[a-z]+") ? TypoType.KEYBOARD : TypoType.SPELLING;
    }
}
