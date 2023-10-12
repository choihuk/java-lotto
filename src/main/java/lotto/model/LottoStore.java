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
        if (lottoAmount % PRICE != 0) {
            throw new IllegalArgumentException("잘못된 로또 금액입니다.");
        }
    }
}
