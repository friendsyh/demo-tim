package com.tim.common.algorithm.similarity.impl;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.dictionary.stopword.Filter;
import com.hankcs.hanlp.seg.common.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 中文分词工具类*/
public class Tokenizer {

    /**
     * 分词*/
    public static List<Word> segment(String sentence) {

        //1、 采用HanLP中文自然语言处理中标准分词进行分词
        List<Term> termList = HanLP.segment(sentence);

        //System.out.println(termList.toString());

        //2、重新封装到Word对象中（term.word代表分词后的词语，term.nature代表改词的词性）
        return termList.stream().map(term -> new Word(term.word, term.nature.toString())).collect(Collectors.toList());
    }

    /**
     * 标准分词, 并去掉停用词
     * */
    public static List<String> segment2(String sentence) {
        CoreStopWordDictionary.FILTER = new Tokenizer.MyFilter();

        //1、 采用HanLP中文自然语言处理中标准分词进行分词
        List<Term> termList = CoreStopWordDictionary.apply(HanLP.segment(sentence));
//        List<Term> termList = HanLP.segment(sentence);

//        System.out.println(termList.toString());
        // 2/ 输出分词后的词语列表
        return termList.stream().map(term -> term.word).collect(Collectors.toList());
    }


    /**
     * 标准分词, 并去掉停用词，并且对重复的词语进行添加序号，比如分词后有两个am那么就是am，am_1
     * */
    public static List<String> segment3(String sentence) {
        CoreStopWordDictionary.FILTER = new Tokenizer.MyFilter();

        //1、 采用HanLP中文自然语言处理中标准分词进行分词
        List<Term> termList = CoreStopWordDictionary.apply(HanLP.segment(sentence));

        List<String> wordList = new ArrayList<>();
        Map<String, Long> tokenizerCountMap = termList.stream().map(term -> term.word).collect(Collectors.groupingBy(item -> item,Collectors.counting()));
        for(Map.Entry<String, Long> entry : tokenizerCountMap.entrySet()) {
            wordList.add(entry.getKey());
            if(entry.getValue() > 1) {
                for(int i = 1; i < entry.getValue(); i++) {
                    wordList.add(entry.getKey() + "_" + i);
                }
            }
        }

        return wordList;
    }

    /**
     * 标准分词, 并去掉停用词，并且对重复的词语进行添加序号，比如分词后有两个am那么就是am，am_1
     * */
    public static List<String> segment4(String sentence, int wordLength) {
        List<String> wordList = new ArrayList<>();
        for(int i = 0; i < sentence.length(); i++) {
            int endIndex = (i + wordLength) > sentence.length() ? sentence.length() : i + wordLength;
            wordList.add(sentence.substring(i, endIndex));
        }

        List<String> rltList = new ArrayList<>();
        Map<String, Long> tokenizerCountMap = wordList.stream().collect(Collectors.groupingBy(item -> item,Collectors.counting()));
        for(Map.Entry<String, Long> entry : tokenizerCountMap.entrySet()) {
            rltList.add(entry.getKey());
            if(entry.getValue() > 1) {
                for(int i = 1; i < entry.getValue(); i++) {
                    rltList.add(entry.getKey() + "_" + i);
                }
            }
        }

        return rltList;
    }

    public static class MyFilter implements Filter {

        public boolean shouldInclude(Term term) {
            if (term.nature.startsWith('m')) return true;       // 数词过滤
            if (term.nature.startsWith('q')) return true;      // 量词过滤
            if (term.nature.startsWith('t')) return true;       // 时间词过滤
            if (term.nature.startsWith("w")) return false;      // 过滤标点符号
            return !CoreStopWordDictionary.contains(term.word); // 停用词过滤
        }
    }

    public static void main(String[] args) {
        List<String> words1 = segment3("广东省深圳市南山区粤海街道36号广东省南山区广东省 测试人员棒棒哒 棒棒哒");
        List<String> words2 = segment4("南京农业大学工学院", 3);

        System.out.println("segment3: " + words1);
    }
}
