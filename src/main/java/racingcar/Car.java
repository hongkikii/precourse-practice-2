package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class Car {
    private final List<String> cars;

    public Car(String input) {
        validate(input);
        String[] carCandidates = getCarCandidates(input);
        this.cars = new ArrayList<>();
        cars.addAll(Arrays.asList(carCandidates));
    }

    private void validate(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
        String[] carCandidates = getCarCandidates(input);
        if (carCandidates.length < 1 || carCandidates.length > 100) {
            throw new IllegalArgumentException();
        }
        for(String carCandidate: carCandidates) {
            if (carCandidate.isEmpty() || carCandidate.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (isSpaceContained(carCandidate)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private String[] getCarCandidates(String input) {
        return input.split(",");
    }

    private boolean isSpaceContained(String carCandidate) {
        return StringUtils.containsWhitespace(carCandidate);
    }
}
