package com.ofjrv.hangultypofix;

import java.util.List;

public record CorrectionResponse(
        String input,
        TypoType type,
        String mapped,
        List<CorrectionCandidate> candidates
) {
}
