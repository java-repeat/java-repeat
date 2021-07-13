package io.github.repeat;

public class RepeatContext<E extends Throwable> {
    private final RepeatCallback<E> repeatCallback;

    public RepeatContext(final RepeatCallback<E> repeatCallback) {
        this.repeatCallback = repeatCallback;
    }

    public void times(final int times) throws E {
        for(int i = 0; i < times; i++) {
            repeatCallback.doWithRepeat(i);
        }
    }
}
