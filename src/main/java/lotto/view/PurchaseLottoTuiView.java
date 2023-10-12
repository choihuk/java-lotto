package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Override
    public List<List<Integer>> insertLottoNumbers(int lottoCount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(insertLottoNumber());
        }
        return lottoNumbers;
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("[ERROR]: " + message);
    }

    private List<Integer> insertLottoNumber() {
        System.out.println("당첨 번호를 입력해주세요. 번호는 쉼표(,)를 기준으로 구분해주세요.");
        try {
            String[] split = bufferedReader.readLine().split(",");
            return Arrays.stream(split)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
