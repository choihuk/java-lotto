package lotto.model.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class WinLottoImpl implements WinLotto {

    private final Lotto winLotto;

    public WinLottoImpl(List<Integer> winNumber) {
        this.winLotto = new Lotto(winNumber);
    }

    @Override
    public List<LottoResult> calculateWinners(final List<Lotto> purchaseLottos, final int lottoBonusNumber) {
        return purchaseLottos.stream()
                             .map(purchaseLotto -> LottoResult.getLottoResult(
                                     winLotto.calculateCorrespondingNumber(purchaseLotto),
                                     purchaseLotto.calculateBonusNumber(lottoBonusNumber))
                             ).collect(Collectors.toList());
    }

    @Override
    public void validBonusNumber(int lottoBonusNumber) {
        this.winLotto.validBonusNumber(lottoBonusNumber);
    }

}
