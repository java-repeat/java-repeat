package io.github.repeat;

/**
 * Kotlin-style function for running code multiple times.
 * <p>
 * Designed for static import:
 * <pre>{@code
 * import static io.github.repeat.Repeat.*;
 *
 * repeat(3, i -> System.out.println(i));
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

    private Repeat() {
    }
}
