package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.github.repeat.Repeat.repeat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepeatTest {
    @Test
    @DisplayName("repeat should run the action with each index")
    void repeatRunsWithIndex() {
        final List<Integer> indexes = new ArrayList<>();
        repeat(3, indexes::add);
        assertEquals(Arrays.asList(0, 1, 2), indexes);
    }

    @Test
    @DisplayName("repeat should accept void lambdas")
    void repeatAcceptsVoidLambda() {
        final StringBuilder out = new StringBuilder();
        repeat(2, i -> out.append("x"));
        assertEquals("xx", out.toString());
    }

    @Test
    @DisplayName("repeat should run nothing for zero or negative times")
    void repeatZeroOrNegative() {
        final List<Integer> indexes = new ArrayList<>();
        repeat(0, indexes::add);
        repeat(-1, indexes::add);
        assertEquals(Collections.emptyList(), indexes);
    }

    @Test
    @DisplayName("repeat should propagate checked exceptions and stop")
    void repeatThrows() {
        final List<Integer> indexes = new ArrayList<>();
        assertThrows(IOException.class, () -> repeat(5, i -> {
            indexes.add(i);
            if (i == 1) {
                throw new IOException("ERROR!");
            }
        }));
        assertEquals(Arrays.asList(0, 1), indexes);
    }
}
