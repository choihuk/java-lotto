package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PurchaseLottoTuiView implements PurchaseLottoView{

    private final BufferedReader bufferedReader;

    public PurchaseLottoTuiView() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public int insertAmount() {
        System.out.print("로또 구입 금액을 입력해주세요: ");
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
