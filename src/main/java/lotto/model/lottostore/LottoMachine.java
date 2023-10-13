package lotto.model.lottostore;

import static lotto.model.lotto.LottoInfo.LOTTO_NUMBER_SIZE;
import static lotto.model.lotto.LottoInfo.MAX_LOTTO_NUMBER;
import static lotto.model.lotto.LottoInfo.MIN_LOTTO_NUMBER;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoFactory;

public class LottoMachine {

    public Lotto createLotto() {
        return LottoFactory.createLotto(pickLottoNumbers());
    }

    private List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
    }
}
