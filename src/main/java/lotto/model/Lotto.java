package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6자리 숫자여야 합니다.");
        }
        for (int number : numbers) {
            validLottoNumber(number);
        }
    }

    public static void validLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 숫자는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
