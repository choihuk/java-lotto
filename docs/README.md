**입력**
- 로또 구입 금액을 입력받는다.(로또 1장의 가격은 1000원)
- 당첨번호를 입력받는다.
- 보너스 번호를 입력받는다.

**출력**
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- 당첨 내역을 출력한다.
- 수익률은 소수점 둘째 자리에서 반올림한다.
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

**검증**
- 구입 금액이 1000원 단위로 안 나누어지면 에러 반환
- 로또 번호를 1~45 사이의 숫자 범위로 입력 안 하면 에러 반환