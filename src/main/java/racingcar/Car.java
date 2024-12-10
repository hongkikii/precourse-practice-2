package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class Car {
    private final List<String> carNames;

    public Car(String input) {
        validate(input);
        String[] carNameCandidates = getCarNameCandidates(input);
        this.carNames = new ArrayList<>();
        carNames.addAll(Arrays.asList(carNameCandidates));
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    private void validate(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
        String[] carNameCandidates = getCarNameCandidates(input);
        if (carNameCandidates.length < 1 || carNameCandidates.length > 100) {
            throw new IllegalArgumentException();
        }
        for(String carNameCandidate: carNameCandidates) {
            if (carNameCandidate.isEmpty() || carNameCandidate.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (isSpaceContained(carNameCandidate)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private String[] getCarNameCandidates(String input) {
        return input.split(",");
    }

    private boolean isSpaceContained(String carNameCandidate) {
        return StringUtils.containsWhitespace(carNameCandidate);
    }
}
