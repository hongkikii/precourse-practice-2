package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        view.showNameRequest();

        String carNames = Console.readLine();
        Car car = new Car(carNames);

        view.showCountRequest();

        String count = Console.readLine();

        view.showResultHeader();
        Game game = new Game(count, car);
        game.play();

        List<String> winners = game.getWinners();
        view.show(winners);
    }
}
