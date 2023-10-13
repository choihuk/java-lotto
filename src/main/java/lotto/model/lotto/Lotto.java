package lotto.model.lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validBonusNumber(final int lottoBonusNumber) {
        validEachLottoNumber(lottoBonusNumber);
        if (this.numbers.contains(lottoBonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int calculateCorrespondingNumber(final Lotto otherLotto) {
        return (int) otherLotto.numbers.stream()
                                       .filter(this.numbers::contains)
                                       .count();
    }

    public boolean calculateBonusNumber(final int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateLottoNumber(numbers);
        for (int number : numbers) {
            validEachLottoNumber(number);
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6자리 숫자여야 합니다.");
        }
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        Set<Integer> setNumbers = Set.copyOf(numbers);
        if (numbers.size() > setNumbers.size()) {
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다.");
        }
    }

    private void validEachLottoNumber(final int number) {
        if (number < LottoInfo.MIN_LOTTO_NUMBER || number > LottoInfo.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
