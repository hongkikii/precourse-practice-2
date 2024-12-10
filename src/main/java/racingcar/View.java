package racingcar;

import java.util.List;

public class View {
    public void showNameRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showCountRequest() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void show(List<String> winners) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for(String winner : winners) {
            result.append(winner).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        System.out.print(result);
    }
}
