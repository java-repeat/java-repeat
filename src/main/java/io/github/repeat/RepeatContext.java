package io.github.repeat;

import java.util.List;

public class RepeatContext {
    private int times;

    public RepeatContext times(final int times) {
        this.times = times;
        return this;
    }

    public <T, E extends Throwable> List<T> repeat(RepeatCallback<T, E> teRepeatCallback) throws E {
        return new RepeatTemplate().repeat(teRepeatCallback, times);
    }
}
