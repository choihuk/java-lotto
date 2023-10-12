package lotto.controller;

import java.util.List;

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
        final int lottoAmount = purchaseLottoView.insertAmount();
        final int lottoCount = lottoStore.purchaseLotto(lottoAmount);
        List<List<Integer>> lottoNumbers = purchaseLottoView.insertLottoNumbers(lottoCount);
    }
}
