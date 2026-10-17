package io.github.repeat;

/**
 * A function that produces a value from the zero-based index of the current iteration.
 * @param <T> return type
 * @param <E> exceptions
 */
@FunctionalInterface
public interface IndexedFunction<T, E extends Throwable> {
    /**
     * applies the function.
     * @param index zero-based index of the current iteration
     * @return the value for this index
     * @throws E exceptions
     */
    T apply(int index) throws E;
}
