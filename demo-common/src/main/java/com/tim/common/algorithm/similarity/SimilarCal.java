package com.tim.common.algorithm.similarity;

import com.tim.common.algorithm.similarity.impl.CosineSimilarity;
import com.tim.common.algorithm.similarity.impl.JaccardSimilarity;
import com.tim.common.algorithm.similarity.impl.JaccardSimilaritySpecialCut;
import com.tim.common.algorithm.similarity.impl.JaroWinklerSimilarity;
import com.tim.common.algorithm.similarity.impl.LevenshteinSimilarity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 相似度谓词计算对外接口类。
 * 支持各种类型相似度算法的计算
 *
 * @author suyanghua 从presto项目中拷贝过来
 * @since 2020-11-16
 */
public class SimilarCal {

    private static final Logger logger = LoggerFactory.getLogger(SimilarCal.class);

    private static final Map<String, SimilarityScore> similarityAlgorithm;

    // 编辑距离算法
    public static final String ALGORITHM_LEVENSHTEIN_DISTANCE = "levenshtein";

    // Cosine similarity 算法
    public static final String ALGORITHM_COSINE_SIMILARITY = "cosine";

    // Jaccard Similarity
    public static final String ALGORITHM_JACCARD_SIMILARITY = "jaccard";

    // Jaccard Similarity
    public static final String ALGORITHM_JACCARD_SIMILARITY_SPECIALCUT = "jaccardspecialcut";

    // Jaro Winkler Similarity
    public static final String ALGORITHM_JAROWINKLER_SIMILARITY = "jaro-winkler";


    public static double getSimilarityScore(String name, String left, String right) {
        String lowerName = name.toLowerCase();

        if (!similarityAlgorithm.containsKey(lowerName)) {
            throw new UnsupportedOperationException("Unsupported similarity algorithm: " + name);
        }
        SimilarityScore similarityScore = similarityAlgorithm.get(lowerName);
        return similarityScore.compare(left, right);
    }

    static {
        similarityAlgorithm = new HashMap<>(8);
        similarityAlgorithm.put(ALGORITHM_LEVENSHTEIN_DISTANCE, new LevenshteinSimilarity());
        similarityAlgorithm.put(ALGORITHM_COSINE_SIMILARITY, new CosineSimilarity());
        similarityAlgorithm.put(ALGORITHM_JACCARD_SIMILARITY, new JaccardSimilarity());
        similarityAlgorithm.put(ALGORITHM_JAROWINKLER_SIMILARITY, new JaroWinklerSimilarity());
        similarityAlgorithm.put(ALGORITHM_JACCARD_SIMILARITY_SPECIALCUT, new JaccardSimilaritySpecialCut());
    }
}
