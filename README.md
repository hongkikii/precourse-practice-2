# java-racingcar-precourse

# 기능 목록
- [X]  `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`라는 안내 문구를 출력한다.
- [ ]  자동차 이름을 입력받는다.
    - [ ]  자동차 이름은 쉼표(,)를 기준으로 구분한다.
        - [ ]  자동차 이름이 쉼표를 포함할 경우 예외가 발생한다.
    - [ ]  각 자동차의 이름은 1자 이상 5자 이하만 가능하다.
        - [ ]  자동차의 이름이 0자인 경우 예외가 발생한다.
        - [ ]  자동차의 이름이 6자 이상인 경우 예외가 발생한다.
    - [ ]  자동차 이름이 공백만 포함할 경우 예외가 발생한다.
    - [ ]  자동차 개수는 1개 이상 100개 이하여야 한다.
        - [ ]  자동차 개수가 0개인 경우 예외가 발생한다.
        - [ ]  자동차 개수가 101개 이상인 경우 예외가 발생한다.
- [ ]  `시도할 횟수는 몇 회인가요?` 란 안내 문구를 출력한다.
- [ ]  이동 횟수를 입력받는다.
    - [ ]  이동 횟수는 1 이상 100 이하여야 한다.
        - [ ]  이동 횟수가 0 이하인 경우 예외가 발생한다.
        - [ ]  이동 횟수가 101 이상인 경우 예외가 발생한다.
    - [ ]  이동 횟수는 숫자로만 이루어져야 한다.
        - [ ]  이동 횟수에 문자가 포함될 경우 예외가 발생한다.
- [ ]  `실행 결과` 란 안내 문구를 출력한다.
- [ ]  자동차 경주를 진행한다.
    - [ ]  각 자동차별로 0에서 9 사이에서 무작위 값을 구한다.
        - [ ]  무작위 값이 4 이상일 경우 전진한다.
        - [ ]  무작위 값이 3 이하일 경우 멈춘다.
- [ ]  차수별 실행 결과를 출력한다.
    - [ ]  자동차 이름과 전진 횟수(-)를 출력한다.
    - [ ]  `이름 : -` 형태를 띤다.
- [ ]  입력받은 이동 횟수만큼 자동차 경주와 차수별 실행 결과 출력을 반복한다.
- [ ]  우승자를 출력한다.
    - [ ]  우승자는 한 명 이상일 수 있다.
    - [ ]  우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    - [ ]  최종 우승자 : pobi, jun 형태를 띤다.
