package lotto.model.lottostore;

import java.util.List;

import lotto.model.lotto.Lotto;

public interface LottoStore {

    List<Lotto> purchaseLottos(int lottoAmount);
}
