package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("자동차의 이름이 0자인 경우 예외가 발생한다.")
    @Test
    void zeroNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,mimi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름이 공백만 포함할 경우 예외가 발생한다.")
    @Test
    void blankNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,mimi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 개수가 100개인 경우 경우 정상 동작한다.")
    @Test
    void CarCountTest() {
        StringBuilder carNames = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            carNames.append("a,");
        }
        carNames.deleteCharAt(carNames.length() - 1);
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> runException(carNames.toString(), "1"))
        );
    }

    @DisplayName("자동차 개수가 0개인 경우 예외가 발생한다.")
    @Test
    void minCarTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 개수가 101개 이상인 경우 경우 예외가 발생한다.")
    @Test
    void maxCarTest() {
        StringBuilder carNames = new StringBuilder();
        for (int i = 1; i <= 101; i++) {
            carNames.append("a,");
        }
        carNames.deleteCharAt(carNames.length() - 1);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames.toString(), "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수에 문자가 포함될 경우 예외가 발생한다.")
    @Test
    void countNotNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1&"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수는 1 이상 100 이하여야 한다.")
    @Test
    void countTest() {
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> runException("mimi,pobi", "1"))
        );
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> runException("mimi,pobi", "100"))
        );
    }

    @DisplayName("시도 횟수가 0 이하인 경우 예외가 발생한다.")
    @Test
    void minCountTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @DisplayName("시도 횟수가 101 이상인 경우 예외가 발생한다.")
    @Test
    void maxCountTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "101"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
