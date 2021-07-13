package io.github.repeat;

public interface RepeatCallback<E extends Throwable> {
    void doWithRepeat(final int index) throws E;
}
