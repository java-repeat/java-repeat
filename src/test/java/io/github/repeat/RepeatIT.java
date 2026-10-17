package io.github.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static io.github.repeat.Repeat.list;
import static io.github.repeat.Repeat.repeat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepeatIT {
    @Test
    @DisplayName("simple repeat example")
    void simpleRepeat() {
        final AtomicInteger count = new AtomicInteger();
        final int times = 3;

        repeat(times, i -> count.incrementAndGet());

        assertEquals(times, count.intValue());
    }

    @Test
    @DisplayName("simple list example")
    void simpleList() {
        final List<String> names = list(3, i -> "item-" + i);

        assertEquals("item-2", names.get(2));
    }

    @Test
    @DisplayName("repeat error example")
    void throwError() {
        assertThrows(Exception.class, () -> repeat(100, i -> {
            throw new Exception("ERROR!");
        }));
    }
}
