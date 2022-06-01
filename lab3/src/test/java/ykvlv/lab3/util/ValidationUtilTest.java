package ykvlv.lab3.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"-0.231", "-0.231748327492384723987432987427374293749", "-5", "3", "0"})
    void checkYTrue(String input) {
        assertTrue(ValidationUtil.checkY(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "-0", "13", "-13", "-", "5.1"})
    void checkYFalse(String input) {
        assertFalse(ValidationUtil.checkY(input));
    }


}
