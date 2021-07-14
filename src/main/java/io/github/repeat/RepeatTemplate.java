package io.github.repeat;

import java.util.ArrayList;
import java.util.List;

/**
 * Repeats RepeatCallbacks a defined amount of times
 */
public class RepeatTemplate implements RepeatOperations {
    @Override
    public <T, E extends Throwable> List<T> repeat(final RepeatCallback<T, E> repeatCallback, final int times) throws E {
        final List<T> returnValues = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            returnValues.add(repeatCallback.doWithRepeat(i));
        }
        return returnValues;
    }
}
