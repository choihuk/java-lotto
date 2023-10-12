package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.view.PurchaseLottoView;

public class LottoController {

    private final PurchaseLottoView purchaseLottoView;
    private final LottoStore lottoStore;


    public LottoController(PurchaseLottoView purchaseLottoView) {
        this.purchaseLottoView = purchaseLottoView;
        this.lottoStore = new LottoStore();
    }

    public void run() {
        try {
            final int lottoAmount = purchaseLottoView.insertAmount();
            final int lottoCount = lottoStore.purchaseLotto(lottoAmount);
            final List<List<Integer>> lottoNumbers = purchaseLottoView.insertLottoNumbers(lottoCount);
            List<Lotto> lottos = lottoNumbers.stream()
                                              .map(Lotto::new)
                                              .collect(Collectors.toList());
            final int lottoBonusNumber = purchaseLottoView.insertLottoBonusNumber();
            Lotto.validLottoNumber(lottoBonusNumber);

            purchaseLottoView.returnLottoNumbers(lottoNumbers);
        } catch (IllegalArgumentException e) {
            purchaseLottoView.returnErrorMessage(e.getMessage());
        }
    }
}
