package lotto.model.lotto;

import java.util.List;

public interface WinLotto {

    List<LottoResult> calculateWinners(List<Lotto> purchaseLottos, int lottoBonusNumber);

    void validBonusNumber(int lottoBonusNumber);
}
