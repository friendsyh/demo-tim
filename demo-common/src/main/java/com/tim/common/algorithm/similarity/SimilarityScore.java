package com.tim.common.algorithm.similarity;

public interface SimilarityScore {

    /**
     * Compares two String.
     *
     * @param left the first String
     * @param right the second String
     * @return The similarity score between two CharSequences
     */
    double compare(String left, String right);
}
