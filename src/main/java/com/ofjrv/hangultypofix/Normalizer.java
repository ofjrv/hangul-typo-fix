package com.ofjrv.hangultypofix;

import java.util.Locale;

import org.springframework.stereotype.Component;

// 검색어 공백과 영문 대소문자를 정리해.
@Component
public class Normalizer {
    public String normalize(String input) {
        return input.trim().replaceAll("\\s+", " ").toLowerCase(Locale.ROOT);
    }
}
