package com.tim.common.algorithm.similarity.impl;

public interface Distance {

    /**
     * Compares two String.
     *
     * @param left the first String
     * @param right the second String
     * @return The distance between two String
     */
    int compare(String left, String right);
}
