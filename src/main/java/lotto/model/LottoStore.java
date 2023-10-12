package lotto.model;

public class LottoStore {

    private static final int PRICE = 1000;

    public LottoStore() {

    }

    public int purchaseLotto(int lottoAmount) {
        validateLottoAmount(lottoAmount);
        return lottoAmount / PRICE;
    }

    private void validateLottoAmount(int lottoAmount) {
        if (PRICE % lottoAmount != 0) {
            throw new IllegalArgumentException();
        }
    }
}
