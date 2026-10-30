# hangul-typo-fix

한글 검색어의 두벌식 자판 실수와 자모 단위 오타를 교정하는 Spring Boot 포트폴리오 프로젝트입니다.

![demo](docs/demo.gif)

## 파이프라인

1. **정규화**: 앞뒤 공백과 연속 공백을 정리하고 영문을 소문자로 바꿉니다.
2. **오타 유형 판별**: 영문 입력은 `KEYBOARD`, 한글 입력은 `SPELLING`으로 분류합니다.
3. **유형별 교정**: 자판 오타는 두벌식 자판 매핑과 한글 조합을 거치고, 한글 오타는 입력을 그대로 사용합니다.
4. **점수화·순위화**: 한글을 초성·중성·종성으로 분해해 사전 단어와 편집거리를 계산하고 가까운 후보 최대 3개를 반환합니다.
5. **로그 재학습(향후 계획)**: 교정 결과 로그를 모아 사전과 점수 기준을 개선할 계획입니다.

## 한글 특화가 필요한 이유

- 영문 자판 상태에서 입력한 `dkdlvoem`은 두벌식 자판 기준으로 `아이패드`가 됩니다.
- 한글 음절 단위 비교는 `아잇패드`와 `아이패드`의 차이를 세밀하게 구분하기 어렵습니다. 자모 단위로 비교하면 불필요한 받침 하나의 차이를 거리 1로 계산할 수 있습니다.
- 이 프로젝트는 네이버 검색어 오타 교정 방식에서 아이디어를 얻어 기본 원리를 직접 구현한 데모이며, 네이버의 내부 구현을 재현한 것은 아닙니다.

## 실행

```bash
./gradlew bootRun
```

브라우저에서 [http://localhost:8080](http://localhost:8080)을 열면 데모 화면을 사용할 수 있습니다.

## API

`GET /api/correct?q={검색어}`

```bash
curl "http://localhost:8080/api/correct?q=dkdlvoem"
```

```json
{
  "input": "dkdlvoem",
  "type": "KEYBOARD",
  "mapped": "아이패드",
  "candidates": [
    {
      "word": "아이패드",
      "distance": 0
    }
  ]
}
```

검색어가 비어 있으면 `400 Bad Request`를 반환합니다. 후보 사전은 [`src/main/resources/dictionary.txt`](src/main/resources/dictionary.txt)에서 관리합니다.