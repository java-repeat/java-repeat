package io.github.repeat;

import java.util.List;

/**
 * Repeats RepeatCallbacks a defined amount of times
 */
public interface RepeatOperations {
    /**
     * repats RepeatCallback a defined amount of times and returns the results.
     * @param repeatCallback method to execute
     * @param times how many times to execute repeatCallback
     * @param <T> return type of repeatCallback
     * @param <E> exceptions for repeatCallback
     * @return a List of values from RepeatCallback
     * @throws E an error if any errors are thrown in RepeatCallback
     */
    <T, E extends Throwable> List<T> repeat(RepeatCallback<T, E> repeatCallback, int times) throws E;
}
