package io.github.repeat;

public class Repeat {
    public static RepeatContext<Throwable> repeat(final RepeatCallback<Throwable> repeatCallback) {
        return new RepeatContext<>(repeatCallback);
    }

    private Repeat() {
    }
}
