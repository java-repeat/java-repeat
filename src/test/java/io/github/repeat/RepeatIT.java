package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepeatIT {
    @Test
    @DisplayName("simple repeat example")
    void simpleRepeat() {
        final AtomicInteger count = new AtomicInteger();
        final int times = 3;

        Repeat.of().times(times).repeat((index -> count.getAndIncrement()));

        assertEquals(times, count.intValue());
    }

    @Test()
    @DisplayName("repeat error example")
    void throwError() {
        assertThrows(Exception.class, ()-> Repeat.of().times(100).repeat(index -> {
            throw new Exception("ERROR!");
        }));
    }
}
