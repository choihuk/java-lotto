package lotto.controller;

import java.util.List;

import lotto.dto.LottoResultResponse;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoFactory;
import lotto.model.lotto.LottoResult;
import lotto.model.lottostore.LottoStore;
import lotto.model.lotto.WinLotto;
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
            final List<Lotto> purchaseLottos = purchaseLottos(lottoAmount);
            final WinLotto winLotto = getWinLotto();
            final int lottoBonusNumber = getLottoBonusNumber(winLotto);

            final List<LottoResult> lottoResults = winLotto.calculateWinners(purchaseLottos, lottoBonusNumber);
            purchaseLottoView.returnLottoResults(new LottoResultResponse(lottoResults, lottoAmount));

        } catch (IllegalArgumentException e) {
            purchaseLottoView.returnErrorMessage(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos(int lottoAmount) {
        List<Lotto> purchaseLottos = lottoStore.purchaseLottos(lottoAmount);
        purchaseLottoView.returnLottos(purchaseLottos);
        return purchaseLottos;
    }

    private WinLotto getWinLotto() {
        final List<Integer> lottoWinNumbers = purchaseLottoView.insertLottoWinNumber();
        return LottoFactory.createWinLotto(lottoWinNumbers);
    }

    private int getLottoBonusNumber(WinLotto winLotto) {
        final int lottoBonusNumber = purchaseLottoView.insertLottoBonusNumber();
        winLotto.validBonusNumber(lottoBonusNumber);
        return lottoBonusNumber;
    }
}
