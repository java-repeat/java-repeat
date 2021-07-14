package io.github.repeat;

import java.util.List;

/**
 * API for configuring and executing a RepeatCallback with a RepeatTemplate
 */
public class RepeatContext {
    private int times;

    /**
     * set the number of times to execute the RepeatCallback.
     * @param times the number of times to execute the RepeatCallback
     * @return this
     */
    public RepeatContext times(final int times) {
        this.times = times;
        return this;
    }

    /**
     * execute the RepeatCallback using a RepeatTemplate
     * @param repeatCallback the RepeatCallback to execute.
     * @param <T> the return type of the RepeatCallback
     * @param <E> exceptions
     * @return a List of results from each RepeatCallback
     * @throws E if RepeatCallback fails
     */
    public <T, E extends Throwable> List<T> repeat(RepeatCallback<T, E> repeatCallback) throws E {
        return new RepeatTemplate().repeat(repeatCallback, times);
    }
}
