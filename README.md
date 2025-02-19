## Intro
객체지향의 사실과 오해, 오브젝트 서적을 읽고 스터디를 진행한지 어느덧 반 년이 넘었지만 협력, 역할, 책임의 관점에서 코드를 짜고 있는지 의구심이 들 때가 많다. 스프링 프레임워크라는 정해진 틀 안에 요구사항을 끼워넣는 코딩을 하다보니 자연스럽게 든 생각인거 같다.

객체지향이 만능은 아니지만, 유지보수의 관점에서 객체지향적으로 코드를 작성했을 때의 이점은 굉장하다. 이 기회에 프리코스 미션을 오브젝트에서 제시한 책임 주도 설계(책임을 갖고 책임을 적절한 객체를 찾아 할당하며 설계)를 바탕으로 작성해보자.

## 요구사항
[요구사항 바로가기](./요구사항.md)

미션은 기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항이 있다. 개인적으로 추가된 프로그래밍 요구사항 중 else 사용 금지가 의아하긴 했으나, 최대한 컨벤션을 지켜가며 코드를 작성할 생각이다.

기능 요구사항은 다음과 같다.

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

## 설계
이번 미션에서 적용해볼 패턴은 MVC 패턴이다.

서적 오브젝트에서 객체지향적으로 설계하는 방법으로 책임 주도 설계라는 개념을 제시했다. 책임 주도 설계 방법은 다음과 같다.

1. 시스템이 사용자에게 제공해야 하는 기능인 시스템 책임 파악
2. 시스템 책임을 더 작은 책임으로 분할
3. 분할된 책임을 수행할 수 있는 적절한 객체 혹은 역할을 찾아 책임 할당
4. 시스템 책임을 완전히 수행할 때까지 2, 3번을 반복

## 프로젝트 구조
```shell
├── Application.java
├── controller
│   └── LottoController.java
├── dto
│   └── LottoResultResponse.java
├── model
│   ├── lotto
│   │   ├── Lotto.java
│   │   ├── LottoFactory.java
│   │   ├── LottoInfo.java
│   │   ├── LottoResult.java
│   │   ├── WinLotto.java
│   │   └── WinLottoImpl.java
│   └── lottostore
│       ├── LottoMachine.java
│       ├── LottoStore.java
│       └── MyLottoStore.java
└── view
    ├── PurchaseLottoTuiView.java
    └── PurchaseLottoView.java
```