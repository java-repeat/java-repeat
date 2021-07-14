package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatContextTest {

    @Test
    @DisplayName("should execute with repeat")
    void repeat() {
        List<Integer> expectedValues = Arrays.asList(0, 1);
        RepeatContext repeatContext = new RepeatContext();
        repeatContext.times(2);
        List<Integer> values = repeatContext.repeat(index -> index);
        assertEquals(expectedValues, values);
    }
}
