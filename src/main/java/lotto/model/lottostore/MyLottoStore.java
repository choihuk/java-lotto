package lotto.model.lottostore;

import static lotto.model.lotto.LottoInfo.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.model.lotto.Lotto;

public class MyLottoStore implements LottoStore{
    private final LottoMachine lottoMachine;

    public MyLottoStore() {
        this.lottoMachine = new LottoMachine();
    }

    @Override
    public List<Lotto> purchaseLottos(int lottoAmount) {
        validateLottoAmount(lottoAmount);
        final int lottoCount = lottoAmount / LOTTO_PRICE;
        return IntStream.range(0, lottoCount)
                        .mapToObj(i -> lottoMachine.createLotto())
                        .collect(Collectors.toList());
    }

    private void validateLottoAmount(int lottoAmount) {
        if (lottoAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("잘못된 로또 금액입니다.");
        }
    }
}
