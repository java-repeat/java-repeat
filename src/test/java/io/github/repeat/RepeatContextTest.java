package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatContextTest {

    @Test
    @DisplayName("should repeat RepeatCallback")
    void testTimes() throws Throwable {
        final AtomicInteger count = new AtomicInteger();
        final int times = 3;
        RepeatContext repeatContext = new RepeatContext((index -> {
            count.getAndIncrement();
        }));
        repeatContext.times(times);
        assertEquals(times, count.intValue());
    }
}
