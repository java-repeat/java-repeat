package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

class RepeatTest {
    @Test
    @DisplayName("should create RepeatContext")
    void test() {
        assertTrue(Repeat.of() instanceof RepeatContext);
    }
}
