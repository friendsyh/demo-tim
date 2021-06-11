package com.tim.common.algorithm.similarity.impl;

import com.tim.common.algorithm.similarity.SimilarityScore;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class LevenshteinSimilarity implements SimilarityScore {

    @Override
    public double compare(String left, String right) {
        //如果wei空，或者字符长度为0，则代表完全相同
        if (StringUtils.isBlank(left) && StringUtils.isBlank(right)) {
            return 1.0;
        }
        //如果一个为0或者空，一个不为，那说明完全不相似
        if (StringUtils.isBlank(left) || StringUtils.isBlank(right)) {
            return 0.0;
        }

        LevenshteinDistance distance = new LevenshteinDistance();

        int dp = distance.compare(left, right);
        BigDecimal decimal = new BigDecimal(1.0 - ((double)dp) / Math.max(left.length(), right.length()));

        return decimal.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        LevenshteinSimilarity similarity = new LevenshteinSimilarity();

        double f = similarity.compare("str2 ster1", "str2 ster1");
        System.out.println("compare: " + f);
    }
}
