package com.tim.common.algorithm.similarity.impl;

import com.tim.common.algorithm.similarity.SimilarityScore;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本相似度计算。和Jaccard算法一样，唯一不同的对传入的字符串如果是特殊字符替换成#符号
 * 判定方式：Jaccard相似性系数（Jaccard similarity coefficient） ，通过计算两个集合交集的大小除以并集的大小来评估他们的相似度
 * 算法步骤描述：
 * 1、分词
 * 2、词干提取
 * 3.去停用词
 * 4、求交集（去重），计算交集的不重复词的个数 intersectionSize
 * 5、求并集（去重），计算并集的不重复词的个数 unionSize
 * 6、2中的值除以3中的值 intersectionSize/(double)unionSize
 */
public class JaccardSimilaritySpecialCut implements SimilarityScore {

    protected static final Logger logger = LoggerFactory.getLogger(JaccardSimilaritySpecialCut.class);

    private static final Pattern pattern = Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");


    @Override
    public double compare(String left1, String right1) {
        String left = getSpecialCharacter(left1);
        String right = getSpecialCharacter(right1);
        //如果wei空，或者字符长度为0，则代表完全相同
        if (StringUtils.isBlank(left) && StringUtils.isBlank(right)) {
            return 1.0;
        }
        //如果一个为0或者空，一个不为，那说明完全不相似
        if (StringUtils.isBlank(left) || StringUtils.isBlank(right)) {
            return 0.0;
        }
        //这个代表如果两个字符串相等那当然返回1了
        if (left.equalsIgnoreCase(right)) {
            return 1.0;
        }
        return getSimilarity(left, right);
    }

    protected static double getSimilarity(String document1, String document2) {
        //获取词干对应的文本，封装成集合
        List<String> wordslist1 = getlema(document1);
        List<String> wordslist2 = getlema(document2);
        Set<String> words2Set = new HashSet<>();
        words2Set.addAll(wordslist2);
        //求交集
        Set<String> intersectionSet = new ConcurrentSkipListSet<>();
        wordslist1.parallelStream().forEach(word -> {
            if (words2Set.contains(word)) {
                intersectionSet.add(word);
            }
        });
        //交集的大小
        int intersectionSize = intersectionSet.size();
        //求并集
        Set<String> unionSet = new HashSet<>();
        wordslist1.forEach(word -> unionSet.add(word));
        wordslist2.forEach(word -> unionSet.add(word));
        //并集的大小
        int unionSize = unionSet.size();
        //相似度分值
        double score = intersectionSize / (double) unionSize;
        if (logger.isDebugEnabled()) {
            logger.debug("交集的大小：" + intersectionSize);
            logger.debug("并集的大小：" + unionSize);
            logger.debug("相似度分值=" + intersectionSize + "/(double)" + unionSize + "=" + score);
        }
        return score;
    }


    private static List<String> getlema(String text){
        return Tokenizer.segment4(text, 1);
    }

    public static void main(String[] args) {
        JaccardSimilarity similarity = new JaccardSimilarity();

        double f = similarity.compare("str2 ster1234", "str2 ster1");
        System.out.println("compare: " + f);
    }

    public static String getSpecialCharacter(String character) {
        Matcher m = pattern.matcher(character);
        return m.replaceAll("#").trim();
    }


}
