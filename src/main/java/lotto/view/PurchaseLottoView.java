package lotto.view;

import java.util.List;

public interface PurchaseLottoView {
    int insertAmount();

    List<List<Integer>> insertLottoNumbers(int lottoCount);

    void showErrorMessage(String message);
}
