package com.tim.common.algorithm.similarity.impl;

import org.apache.commons.lang3.StringUtils;

public class LevenshteinDistance implements Distance {

    @Override
    public int compare(String left, String right) {
        // 如果为空，或者字符长度为0，则代表完全相同
        if (StringUtils.isBlank(left) && StringUtils.isBlank(right)) {
            return 0;
        }

        // 如果一个为0或者空，一个不为，那说明完全不相似
        if (StringUtils.isBlank(left) || StringUtils.isBlank(right)) {
            return Math.max(left.length(), right.length());
        }

        // 这个代表如果两个字符串相等那当然返回1了
        if (left.equalsIgnoreCase(right)) {
            return 0;
        }

        return getLevenshteinDistance(left, right);
    }

    private int getLevenshteinDistance(String left, String right) {
        int len1 = left.length();
        int len2 = right.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = left.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = right.charAt(j);
                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i][j])); // 这里不需要递归实现了
                }
            }
        }

        return  dp[len1][len2];
    }
}
