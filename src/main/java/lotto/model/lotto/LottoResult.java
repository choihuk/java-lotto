package lotto.model.lotto;

import java.util.List;

public enum LottoResult {

    FIRST_PLACE(6, 2_000_000_000L),
    SECOND_PLACE(5, 30_000_000L),
    THIRD_PLACE(5, 1_500_000L),
    FOURTH_PLACE(4, 50_000L),
    FIFTH_PLACE(3, 5_000L),
    LOST(-1, 0L);

    private final int correspondingNumber;
    private final long prize;
    LottoResult(int correspondingNumber, long prize) {
        this.correspondingNumber = correspondingNumber;
        this.prize = prize;
    }

    public static LottoResult getLottoResult(final int correspondingNumber, final boolean isCorrespondingBonus) {
        if (correspondingNumber == 6) {
            return FIRST_PLACE;
        } else if (correspondingNumber == 5) {
            if (isCorrespondingBonus) {
                return SECOND_PLACE;
            }
            return THIRD_PLACE;
        } else if (correspondingNumber == 4) {
            return FOURTH_PLACE;
        } else if (correspondingNumber == 3) {
            return FIFTH_PLACE;
        }
        return LOST;
    }

    public int getCorrespondingNumber() {
        return correspondingNumber;
    }

    public long getPrize() {
        return prize;
    }
}
