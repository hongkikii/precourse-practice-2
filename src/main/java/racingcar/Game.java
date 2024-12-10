package racingcar;

public class Game {
    private final int count;

    public Game(String count) {
        validate(count);
        this.count = Integer.parseInt(count);
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
}
