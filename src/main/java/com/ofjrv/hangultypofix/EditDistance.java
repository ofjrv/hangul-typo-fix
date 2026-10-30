package com.ofjrv.hangultypofix;

// 두 자모 문자열의 편집 거리를 계산해.
public class EditDistance {
    public int distance(String left, String right) {
        int[] leftChars = left.codePoints().toArray();
        int[] rightChars = right.codePoints().toArray();
        int[] previous = new int[rightChars.length + 1];
        int[] current = new int[rightChars.length + 1];

        for (int column = 0; column <= rightChars.length; column++) {
            previous[column] = column;
        }
        for (int row = 1; row <= leftChars.length; row++) {
            current[0] = row;
            for (int column = 1; column <= rightChars.length; column++) {
                int substitution = previous[column - 1]
                        + (leftChars[row - 1] == rightChars[column - 1] ? 0 : 1);
                current[column] = Math.min(
                        Math.min(previous[column] + 1, current[column - 1] + 1),
                        substitution
                );
            }
            int[] swap = previous;
            previous = current;
            current = swap;
        }
        return previous[rightChars.length];
    }
}
