package io.github.repeat;

public interface RepeatCallback<T, E extends Throwable> {
    T doWithRepeat(final int index) throws E;
}
