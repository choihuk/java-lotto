package lotto.dto;

import java.util.List;

import lotto.model.lotto.LottoResult;

public class LottoResultResponse {

    private final List<LottoResult> lottoResults;
    private int firstPlaceCount;
    private int secondPlaceCount;
    private int thirdPlaceCount;
    private int fourthPlaceCount;
    private int fifthPlaceCount;
    private final double yieldRate;

    public LottoResultResponse(final List<LottoResult> lottoResults, final int lottoAmount) {
        this.lottoResults = lottoResults;
        calculateCount();
        long totalLottoPrize = calculateTotalLottoPrize();
        yieldRate = (double) Math.round(((double) totalLottoPrize / lottoAmount) * 1000) / 10;
    }

    private void calculateCount() {
        for (LottoResult lottoResult : lottoResults) {
            if (lottoResult == LottoResult.FIRST_PLACE) {
                firstPlaceCount++;
            } else if (lottoResult == LottoResult.SECOND_PLACE) {
                secondPlaceCount++;
            } else if (lottoResult == LottoResult.THIRD_PLACE) {
                thirdPlaceCount++;
            } else if (lottoResult == LottoResult.FOURTH_PLACE) {
                fourthPlaceCount++;
            } else if (lottoResult == LottoResult.FIFTH_PLACE) {
                fifthPlaceCount++;
            }
        }
    }

    private long calculateTotalLottoPrize() {
        return this.lottoResults.stream()
                .mapToLong(LottoResult::getPrize)
                .sum();
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }

    public int getFirstPlaceCount() {
        return firstPlaceCount;
    }

    public int getSecondPlaceCount() {
        return secondPlaceCount;
    }

    public int getThirdPlaceCount() {
        return thirdPlaceCount;
    }

    public int getFourthPlaceCount() {
        return fourthPlaceCount;
    }

    public int getFifthPlaceCount() {
        return fifthPlaceCount;
    }

    public double getYieldRate() {
        return yieldRate;
    }
}
