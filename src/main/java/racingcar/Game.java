package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Game {
    private final int count;
    private final Map<String, StringBuilder> result;

    public Game(String count, Car car) {
        validate(count);
        this.count = Integer.parseInt(count);
        this.result = new LinkedHashMap<>();
        for (String carName : car.getCarNames()) {
            result.put(carName, new StringBuilder());
        }
    }

    private void validate(String count) {
        int number;
        try {
            number = Integer.parseInt(count);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (number <= 0 || number >= 101) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        for(int i=1; i<=count; i++) {
            playPerRound();
            printRoundResult();
        }
    }

    private void playPerRound() {
        for (String carName : result.keySet()) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                result.put(carName, result.get(carName).append("-"));
            }
        }
    }

    private void printRoundResult() {
        for (String carName : result.keySet()) {
            System.out.println(carName + " : " + result.get(carName));
        }
        System.out.println();
    }
}
