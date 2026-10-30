package com.ofjrv.hangultypofix;

import java.util.List;

import org.springframework.stereotype.Service;

// 교정 파이프라인 단계를 순서대로 연결해.
@Service
public class TypoCorrectionService {
    private final Normalizer normalizer;
    private final TypoClassifier classifier;
    private final KeyMapper keyMapper;
    private final Ranker ranker;

    public TypoCorrectionService(Normalizer normalizer, TypoClassifier classifier,
                                 KeyMapper keyMapper, Ranker ranker) {
        this.normalizer = normalizer;
        this.classifier = classifier;
        this.keyMapper = keyMapper;
        this.ranker = ranker;
    }

    public CorrectionResponse correct(String input) {
        String normalized = normalizer.normalize(input);
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("검색어가 비어 있어.");
        }

        TypoType type = classifier.classify(normalized);
        String mapped = type == TypoType.KEYBOARD ? keyMapper.map(normalized) : normalized;
        List<CorrectionCandidate> candidates = ranker.rank(mapped);
        return new CorrectionResponse(input, type, mapped, candidates);
    }
}
