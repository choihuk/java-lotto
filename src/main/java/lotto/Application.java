package lotto;

import lotto.controller.LottoController;
import lotto.model.lottostore.LottoStore;
import lotto.model.lottostore.MyLottoStore;
import lotto.view.PurchaseLottoTuiView;
import lotto.view.PurchaseLottoView;

public class Application {
    public static void main(String[] args) {
        PurchaseLottoView purchaseLottoView = new PurchaseLottoTuiView();
        LottoStore lottoStore = new MyLottoStore();
        LottoController lottoController = new LottoController(purchaseLottoView, lottoStore);

        lottoController.run();
    }
}
