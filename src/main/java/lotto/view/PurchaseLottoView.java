package lotto.view;

import java.util.List;

import lotto.dto.LottoResultResponse;
import lotto.model.lotto.Lotto;

public interface PurchaseLottoView {
    int insertAmount();

    void returnErrorMessage(String message);

    int insertLottoBonusNumber();

    void returnLottos(List<Lotto> lottos);

    List<Integer> insertLottoWinNumber();

    void returnLottoResults(LottoResultResponse lottoResultResponse);
}
