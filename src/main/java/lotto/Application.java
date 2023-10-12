package lotto;

import lotto.controller.LottoController;
import lotto.view.PurchaseLottoTuiView;
import lotto.view.PurchaseLottoView;

public class Application {
    public static void main(String[] args) {
        PurchaseLottoView purchaseLottoView = new PurchaseLottoTuiView();
        LottoController lottoController = new LottoController(purchaseLottoView);
        lottoController.run();
    }
}
