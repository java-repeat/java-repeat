package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static io.github.repeat.Repeat.repeat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepeatIT {
    @Test
    @DisplayName("simple repeat example")
    void simpleRepeat() throws Throwable {
        final AtomicInteger count = new AtomicInteger();
        final int times = 3;

        repeat((index -> {
            count.getAndIncrement();
        })).times(times);

        assertEquals(times, count.intValue());
    }

    @Test()
    @DisplayName("repeat error example")
    void throwError() {
        assertThrows(Exception.class, ()->{
            repeat((index -> {
                throw new Exception("ERROR!");
            })).times(100);
        });
    }
}
