package com.ofjrv.hangultypofix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

// 사전 파일을 읽어 후보 단어를 제공해.
@Repository
public class DictionaryRepository {
    private final List<String> words;

    public DictionaryRepository() throws IOException {
        ClassPathResource resource = new ClassPathResource("dictionary.txt");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            words = reader.lines().map(String::trim).filter(word -> !word.isEmpty()).toList();
        }
    }

    public List<String> findAll() {
        return words;
    }
}
