package lotto.model.lotto;

import java.util.List;

public class LottoFactory {

    public static WinLotto createWinLotto(final List<Integer> lottoWinNumbers) {
        return new WinLottoImpl(lottoWinNumbers);
    }

    public static Lotto createLotto(final List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}
