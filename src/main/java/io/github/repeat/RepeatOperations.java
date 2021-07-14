package io.github.repeat;

import java.util.List;

public interface RepeatOperations {
    <T, E extends Throwable> List<T> repeat(RepeatCallback<T, E> repeatCallback, int times) throws E;
}
