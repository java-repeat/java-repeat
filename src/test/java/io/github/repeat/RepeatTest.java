package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.github.repeat.Repeat.repeat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RepeatTest {
    @Test
    @DisplayName("should create RepeatContext")
    void test() {
        RepeatCallback repeatCallback = index -> {
            return;
        };
        assertTrue(repeat(repeatCallback) instanceof RepeatContext);
    }
}
