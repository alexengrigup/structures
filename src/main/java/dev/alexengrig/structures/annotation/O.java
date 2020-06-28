package dev.alexengrig.structures.annotation;

/**
 * Big O notation.
 */
public @interface O {
    /**
     * 1, log(n), n, n^2, etc.
     */
    String[] value();
}
