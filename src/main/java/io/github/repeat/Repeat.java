package io.github.repeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kotlin-style functions for running code multiple times.
 * <p>
 * Designed for static import:
 * <pre>{@code
 * import static io.github.repeat.Repeat.*;
 *
 * repeat(3, i -> System.out.println(i));
 * List<Integer> squares = list(5, i -> i * i);
 * }</pre>
 */
public final class Repeat {
    /**
     * Executes the action the given number of times, passing the zero-based index of each iteration.
     * Like Kotlin's {@code repeat}, a zero or negative {@code times} runs nothing.
     * @param times the number of times to execute the action
     * @param action the action to execute
     * @param <E> exceptions
     * @throws E if the action fails; remaining iterations are not executed
     */
    public static <E extends Throwable> void repeat(final int times, final IndexedAction<E> action) throws E {
        for (int i = 0; i < times; i++) {
            action.accept(i);
        }
    }

    /**
     * Creates a read-only list of the given size, where each element is computed by calling init with its index.
     * Like Kotlin's {@code List(size) { init }}.
     * @param size the size of the list
     * @param init the function computing each element
     * @param <T> the element type
     * @param <E> exceptions
     * @return an unmodifiable list of the computed elements
     * @throws IllegalArgumentException if size is negative
     * @throws E if init fails
     */
    public static <T, E extends Throwable> List<T> list(final int size, final IndexedFunction<T, E> init) throws E {
        if (size < 0) {
            throw new IllegalArgumentException("size must not be negative: " + size);
        }
        final List<T> values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            values.add(init.apply(i));
        }
        return Collections.unmodifiableList(values);
    }

    private Repeat() {
    }
}
