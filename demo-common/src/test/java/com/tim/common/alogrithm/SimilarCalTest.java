package com.tim.common.alogrithm;

import com.tim.common.algorithm.similarity.SimilarCal;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimilarCalTest {

    private static final Logger logger = LoggerFactory.getLogger(SimilarCalTest.class);

    private static final String compareStr1 = "南京农业大学工学院";
    private static final String compareStr2 = "南京农业大学农学院";

    @Test
    public void testCosine() {
        double similarRlt = SimilarCal.getSimilarityScore("cosine", compareStr1, compareStr2);
        logger.info("cosine similarRlt:{}", similarRlt);
        Assert.assertTrue("验证cosine相似度函数正确", similarRlt > 0);
    }

    @Test
    public void testJaccard() {
        double similarRlt = SimilarCal.getSimilarityScore("jaccard", compareStr1, compareStr2);
        logger.info("jaccard similarRlt:{}", similarRlt);
        Assert.assertTrue("验证Jaccard相似度函数正确", similarRlt > 0);
    }

    @Test
    public void testJaccardSpecialCut() {
        double similarRlt = SimilarCal.getSimilarityScore("jaccardspecialcut", compareStr1, compareStr2);
        logger.info("jaccardspecialcut similarRlt:{}", similarRlt);
        Assert.assertTrue("验证Jaccard相似度函数正确", similarRlt > 0);
    }

    @Test
    public void testLevenshtein() {
        double similarRlt = SimilarCal.getSimilarityScore("levenshtein", compareStr1, compareStr2);
        logger.info("levenshtein similarRlt:{}", similarRlt);
        Assert.assertTrue("验证levenshtein相似度函数正确", similarRlt > 0);
    }

    @Test
    public void testJaroWinkler() {
        double similarRlt = SimilarCal.getSimilarityScore("jaro-winkler", compareStr1, compareStr2);
        logger.info("jaro-winkler similarRlt:{}", similarRlt);
        Assert.assertTrue("验证jaro-winkler相似度函数正确", similarRlt > 0);
    }
}
