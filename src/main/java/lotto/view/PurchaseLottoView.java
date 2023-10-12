package lotto.view;

import java.util.List;

public interface PurchaseLottoView {
    int insertAmount();

    List<List<Integer>> insertLottoNumbers(int lottoCount);

    void returnErrorMessage(String message);

    int insertLottoBonusNumber();

    void returnLottoNumbers(List<List<Integer>> lottoAmount);
}
