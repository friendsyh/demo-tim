package com.tim.common.practice;

/**
 * Created by suyh on 2021/4/2.
 */
public class TestAll {
    public static void main(String[] args) {
        System.out.println(isSimilarUDF("jaccard"));
    }

    public static boolean isSimilarUDF(String name) {
        switch (name) {
            case "cosine":
            case "jaccard":
            case "levenshtein":
            case "jaro-winkler":
                return true;
            default:
                return false;
        }
    }
}
