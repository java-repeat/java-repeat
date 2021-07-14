package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepeatTemplateTest {
    @Test
    @DisplayName("should repeat and return values")
    void repeat() {
       List<Integer> expectedValues = Arrays.asList(0, 1, 2, 3, 4);
       RepeatTemplate repeatTemplate = new RepeatTemplate();
       List<Integer> values = repeatTemplate.repeat(index -> index, 5);
       assertEquals(expectedValues, values);
    }

    @Test
    @DisplayName("should throw error")
    void throwError() {
        RepeatTemplate repeatTemplate = new RepeatTemplate();
        assertThrows(IOException.class, () -> repeatTemplate.repeat(index -> {
            throw new IOException("ERROR!");
        }, 100));
    }
}
