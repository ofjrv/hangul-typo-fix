package com.ofjrv.hangultypofix;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// 검색어 교정 API를 제공해.
@RestController
@RequestMapping("/api")
public class CorrectionController {
    private final TypoCorrectionService correctionService;

    public CorrectionController(TypoCorrectionService correctionService) {
        this.correctionService = correctionService;
    }

    @GetMapping("/correct")
    public CorrectionResponse correct(@RequestParam(required = false) String q) {
        if (q == null || q.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "검색어를 입력해.");
        }
        return correctionService.correct(q);
    }
}
