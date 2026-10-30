package com.ofjrv.hangultypofix;

import java.util.Map;

// 두벌식 자판 입력을 한글로 조합해.
public class KeyMapper {
    private static final Map<Character, Character> KEY_MAP = Map.ofEntries(
            Map.entry('r', 'ㄱ'), Map.entry('R', 'ㄲ'), Map.entry('s', 'ㄴ'),
            Map.entry('e', 'ㄷ'), Map.entry('E', 'ㄸ'), Map.entry('f', 'ㄹ'),
            Map.entry('a', 'ㅁ'), Map.entry('q', 'ㅂ'), Map.entry('Q', 'ㅃ'),
            Map.entry('t', 'ㅅ'), Map.entry('T', 'ㅆ'), Map.entry('d', 'ㅇ'),
            Map.entry('w', 'ㅈ'), Map.entry('W', 'ㅉ'), Map.entry('c', 'ㅊ'),
            Map.entry('z', 'ㅋ'), Map.entry('x', 'ㅌ'), Map.entry('v', 'ㅍ'),
            Map.entry('g', 'ㅎ'), Map.entry('k', 'ㅏ'), Map.entry('o', 'ㅐ'),
            Map.entry('O', 'ㅒ'), Map.entry('i', 'ㅑ'), Map.entry('j', 'ㅓ'),
            Map.entry('p', 'ㅔ'), Map.entry('P', 'ㅖ'), Map.entry('u', 'ㅕ'),
            Map.entry('h', 'ㅗ'), Map.entry('y', 'ㅛ'), Map.entry('n', 'ㅜ'),
            Map.entry('b', 'ㅠ'), Map.entry('m', 'ㅡ'), Map.entry('l', 'ㅣ')
    );
    private static final Map<String, Character> VOWEL_COMBINATIONS = Map.of(
            "ㅗㅏ", 'ㅘ', "ㅗㅐ", 'ㅙ', "ㅗㅣ", 'ㅚ',
            "ㅜㅓ", 'ㅝ', "ㅜㅔ", 'ㅞ', "ㅜㅣ", 'ㅟ',
            "ㅡㅣ", 'ㅢ', "ㅏㅣ", 'ㅐ', "ㅓㅣ", 'ㅔ',
            "ㅑㅣ", 'ㅒ', "ㅕㅣ", 'ㅖ'
    );
    private static final Map<String, Character> FINAL_COMBINATIONS = Map.ofEntries(
            Map.entry("ㄱㅅ", 'ㄳ'), Map.entry("ㄴㅈ", 'ㄵ'), Map.entry("ㄴㅎ", 'ㄶ'),
            Map.entry("ㄹㄱ", 'ㄺ'), Map.entry("ㄹㅁ", 'ㄻ'), Map.entry("ㄹㅂ", 'ㄼ'),
            Map.entry("ㄹㅅ", 'ㄽ'), Map.entry("ㄹㅌ", 'ㄾ'), Map.entry("ㄹㅍ", 'ㄿ'),
            Map.entry("ㄹㅎ", 'ㅀ'), Map.entry("ㅂㅅ", 'ㅄ')
    );
    private static final Map<Character, Integer> INITIAL_INDEX = Map.ofEntries(
            Map.entry('ㄱ', 0), Map.entry('ㄲ', 1), Map.entry('ㄴ', 2),
            Map.entry('ㄷ', 3), Map.entry('ㄸ', 4), Map.entry('ㄹ', 5),
            Map.entry('ㅁ', 6), Map.entry('ㅂ', 7), Map.entry('ㅃ', 8),
            Map.entry('ㅅ', 9), Map.entry('ㅆ', 10), Map.entry('ㅇ', 11),
            Map.entry('ㅈ', 12), Map.entry('ㅉ', 13), Map.entry('ㅊ', 14),
            Map.entry('ㅋ', 15), Map.entry('ㅌ', 16), Map.entry('ㅍ', 17),
            Map.entry('ㅎ', 18)
    );
    private static final Map<Character, Integer> VOWEL_INDEX = Map.ofEntries(
            Map.entry('ㅏ', 0), Map.entry('ㅐ', 1), Map.entry('ㅑ', 2),
            Map.entry('ㅒ', 3), Map.entry('ㅓ', 4), Map.entry('ㅔ', 5),
            Map.entry('ㅕ', 6), Map.entry('ㅖ', 7), Map.entry('ㅗ', 8),
            Map.entry('ㅘ', 9), Map.entry('ㅙ', 10), Map.entry('ㅚ', 11),
            Map.entry('ㅛ', 12), Map.entry('ㅜ', 13), Map.entry('ㅝ', 14),
            Map.entry('ㅞ', 15), Map.entry('ㅟ', 16), Map.entry('ㅠ', 17),
            Map.entry('ㅡ', 18), Map.entry('ㅢ', 19), Map.entry('ㅣ', 20)
    );
    private static final Map<Character, Integer> FINAL_INDEX = Map.ofEntries(
            Map.entry(' ', 0), Map.entry('ㄱ', 1), Map.entry('ㄲ', 2),
            Map.entry('ㄳ', 3), Map.entry('ㄴ', 4), Map.entry('ㄵ', 5),
            Map.entry('ㄶ', 6), Map.entry('ㄷ', 7), Map.entry('ㄹ', 8),
            Map.entry('ㄺ', 9), Map.entry('ㄻ', 10), Map.entry('ㄼ', 11),
            Map.entry('ㄽ', 12), Map.entry('ㄾ', 13), Map.entry('ㄿ', 14),
            Map.entry('ㅀ', 15), Map.entry('ㅁ', 16), Map.entry('ㅂ', 17),
            Map.entry('ㅄ', 18), Map.entry('ㅅ', 19), Map.entry('ㅆ', 20),
            Map.entry('ㅇ', 21), Map.entry('ㅈ', 22), Map.entry('ㅊ', 23),
            Map.entry('ㅋ', 24), Map.entry('ㅌ', 25), Map.entry('ㅍ', 26),
            Map.entry('ㅎ', 27)
    );

    public String map(String input) {
        StringBuilder jamo = new StringBuilder();
        for (char character : input.toCharArray()) {
            jamo.append(KEY_MAP.getOrDefault(character, character));
        }

        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < jamo.length()) {
            char initial = jamo.charAt(index++);
            if (!INITIAL_INDEX.containsKey(initial)) {
                result.append(initial);
                continue;
            }

            if (index < jamo.length() && initial == jamo.charAt(index)
                    && isTenseInitial(initial)) {
                initial = toTenseInitial(initial);
                index++;
            }
            if (index >= jamo.length() || !VOWEL_INDEX.containsKey(jamo.charAt(index))) {
                result.append(initial);
                continue;
            }

            char vowel = jamo.charAt(index++);
            if (index < jamo.length() && VOWEL_COMBINATIONS.containsKey(
                    "" + vowel + jamo.charAt(index))) {
                vowel = VOWEL_COMBINATIONS.get("" + vowel + jamo.charAt(index++));
            }

            char finalJamo = ' ';
            if (index < jamo.length() && INITIAL_INDEX.containsKey(jamo.charAt(index))) {
                char next = jamo.charAt(index);
                if (index + 1 < jamo.length() && VOWEL_INDEX.containsKey(jamo.charAt(index + 1))) {
                    // 다음 모음이 있으면 이 자음은 다음 음절 초성이야
                } else if (index + 1 < jamo.length()
                        && FINAL_COMBINATIONS.containsKey("" + next + jamo.charAt(index + 1))) {
                    char second = jamo.charAt(index + 1);
                    boolean secondStartsVowel = index + 2 < jamo.length()
                            && VOWEL_INDEX.containsKey(jamo.charAt(index + 2));
                    if (secondStartsVowel) {
                        finalJamo = next;
                        index++;
                    } else {
                        finalJamo = FINAL_COMBINATIONS.get("" + next + second);
                        index += 2;
                    }
                } else {
                    finalJamo = next;
                    index++;
                }
            }
            result.append(compose(initial, vowel, finalJamo));
        }
        return result.toString();
    }

    private char compose(char initial, char vowel, char finalJamo) {
        int codePoint = 0xAC00 + (INITIAL_INDEX.get(initial) * 21 + VOWEL_INDEX.get(vowel)) * 28
                + FINAL_INDEX.get(finalJamo);
        return (char) codePoint;
    }

    private boolean isTenseInitial(char initial) {
        return initial == 'ㄱ' || initial == 'ㄷ' || initial == 'ㅂ'
                || initial == 'ㅅ' || initial == 'ㅈ';
    }

    private char toTenseInitial(char initial) {
        return switch (initial) {
            case 'ㄱ' -> 'ㄲ';
            case 'ㄷ' -> 'ㄸ';
            case 'ㅂ' -> 'ㅃ';
            case 'ㅅ' -> 'ㅆ';
            case 'ㅈ' -> 'ㅉ';
            default -> initial;
        };
    }
}
