package com.ofjrv.hangultypofix;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

// 자모 거리가 가까운 사전 후보를 골라.
@Component
public class Ranker {
    private final DictionaryRepository dictionaryRepository;
    private final JamoDecomposer decomposer;
    private final EditDistance editDistance;

    public Ranker(DictionaryRepository dictionaryRepository, JamoDecomposer decomposer,
                  EditDistance editDistance) {
        this.dictionaryRepository = dictionaryRepository;
        this.decomposer = decomposer;
        this.editDistance = editDistance;
    }

    public List<CorrectionCandidate> rank(String query) {
        String queryJamo = decomposer.decompose(query);
        int maxDistance = Math.max(2, Math.min(3, (queryJamo.length() + 1) / 2));
        return dictionaryRepository.findAll().stream()
                .map(word -> new CorrectionCandidate(
                        word, editDistance.distance(queryJamo, decomposer.decompose(word))))
                .filter(candidate -> candidate.distance() <= maxDistance)
                .sorted(Comparator.comparingInt(CorrectionCandidate::distance)
                        .thenComparing(CorrectionCandidate::word))
                .limit(3)
                .toList();
    }
}
