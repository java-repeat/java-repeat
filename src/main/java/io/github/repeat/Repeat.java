package io.github.repeat;

/**
 * API to create a new instance of RepeatContext.
 */
public class Repeat {
    /**
     * Creates a new RepeatContext.
     * @return new RepeatContext
     */
    public static RepeatContext of() {
        return new RepeatContext();
    }

    private Repeat() {
    }
}
