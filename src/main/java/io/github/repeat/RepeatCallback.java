package io.github.repeat;

/**
 * Functional Interface to wrap repeat methods for RepeatOperations.
 * @param <T> return type
 * @param <E> exceptions
 */
public interface RepeatCallback<T, E extends Throwable> {
    /**
     * method to be repeated by RepeatOperations
     * @param index index of repeated method
     * @return result of repeated method
     * @throws E exceptions
     */
    T doWithRepeat(final int index) throws E;
}
