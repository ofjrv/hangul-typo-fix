package com.ofjrv.hangultypofix;

import org.springframework.stereotype.Component;

// 한글 음절을 초성, 중성, 종성으로 풀어.
@Component
public class JamoDecomposer {
    private static final char[] INITIALS = {
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ',
            'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };
    private static final char[] VOWELS = {
            'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ',
            'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'
    };
    private static final char[] FINALS = {
            ' ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ',
            'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ',
            'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };

    public String decompose(String input) {
        StringBuilder result = new StringBuilder();
        input.codePoints().forEach(codePoint -> {
            if (codePoint >= 0xAC00 && codePoint <= 0xD7A3) {
                int syllableIndex = codePoint - 0xAC00;
                result.append(INITIALS[syllableIndex / 588]);
                result.append(VOWELS[(syllableIndex % 588) / 28]);
                char finalJamo = FINALS[syllableIndex % 28];
                if (finalJamo != ' ') {
                    result.append(finalJamo);
                }
            } else {
                result.appendCodePoint(codePoint);
            }
        });
        return result.toString();
    }
}
