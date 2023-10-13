package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.dto.LottoResultResponse;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoResult;

public class PurchaseLottoTuiView implements PurchaseLottoView{

    private final BufferedReader bufferedReader;

    public PurchaseLottoTuiView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
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
    public int insertLottoBonusNumber() {
        System.out.print("보너스 번호를 입력해주세요: ");
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void returnLottos(final List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            returnLottoNumber(lotto);
        }
    }

    @Override
    public List<Integer> insertLottoWinNumber() {
        System.out.println("당첨 번호를 입력해주세요. 번호는 쉼표(,)를 기준으로 구분해주세요.");
        try {
            String[] numbers = bufferedReader.readLine().split(",");
            return Arrays.stream(numbers)
                         .map(String::trim)
                         .map(Integer::parseInt)
                         .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void returnLottoResults(LottoResultResponse lottoResultResponse) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("당첨 통계 \n ---");
        stringBuilder.append(LottoResult.FIFTH_PLACE.getCorrespondingNumber()).append("개 일치 (")
                     .append(LottoResult.FIFTH_PLACE.getPrize()).append("원) - ")
                     .append(lottoResultResponse.getFifthPlaceCount()).append("개\n")
                     .append(LottoResult.FOURTH_PLACE.getCorrespondingNumber()).append("개 일치 (")
                     .append(LottoResult.FOURTH_PLACE.getPrize()).append("원) - ")
                     .append(lottoResultResponse.getFourthPlaceCount()).append("개\n")
                     .append(LottoResult.THIRD_PLACE.getCorrespondingNumber()).append("개 일치 (")
                     .append(LottoResult.THIRD_PLACE.getPrize()).append("원) - ")
                     .append(lottoResultResponse.getThirdPlaceCount()).append("개\n")
                     .append(LottoResult.SECOND_PLACE.getCorrespondingNumber()).append("개 일치 , 보너스 볼 일치 (")
                     .append(LottoResult.SECOND_PLACE.getPrize()).append("원) - ")
                     .append(lottoResultResponse.getSecondPlaceCount()).append("개\n")
                     .append(LottoResult.FIRST_PLACE.getCorrespondingNumber()).append("개 일치 (")
                     .append(LottoResult.FIRST_PLACE.getPrize()).append("원) - ")
                     .append(lottoResultResponse.getFirstPlaceCount()).append("개\n")
                    .append("총 수익률은 ").append(lottoResultResponse.getYieldRate()).append("% 입니다.");
        System.out.println(stringBuilder.toString());
    }

    private void returnLottoNumber(final Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        lotto.getLottoNumbers()
             .stream()
             .sorted(Integer::compareTo)
             .forEach(number -> stringBuilder.append(number).append(", "));
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void returnErrorMessage(final String message) {
        System.out.println("[ERROR]: " + message);
    }
}
