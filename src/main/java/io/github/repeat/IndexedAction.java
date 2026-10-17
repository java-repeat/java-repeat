package io.github.repeat;

/**
 * An action that receives the zero-based index of the current iteration.
 * @param <E> exceptions
 */
@FunctionalInterface
public interface IndexedAction<E extends Throwable> {
    /**
     * performs the action.
     * @param index zero-based index of the current iteration
     * @throws E exceptions
     */
    void accept(int index) throws E;
}
