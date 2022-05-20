package ykvlv.lab3.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void checkY() {
        assertFalse(ValidationUtil.checkY("a"));
        assertFalse(ValidationUtil.checkY("-0"));
        assertFalse(ValidationUtil.checkY("13"));
        assertFalse(ValidationUtil.checkY("-13"));
        assertFalse(ValidationUtil.checkY("-"));
        assertFalse(ValidationUtil.checkY("5.1"));

        assertTrue(ValidationUtil.checkY("-0.231"));
        assertTrue(ValidationUtil.checkY("-0.231748327492384723987432987427374293749"));
        assertTrue(ValidationUtil.checkY("-5"));
        assertTrue(ValidationUtil.checkY("3"));
        assertTrue(ValidationUtil.checkY("0"));
    }
}
