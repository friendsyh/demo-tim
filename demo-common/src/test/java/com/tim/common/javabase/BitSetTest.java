package com.tim.common.javabase;

import com.tim.common.algorithm.similarity.impl.JaccardSimilaritySpecialCut;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.BitSet;

/**
 * BitSet类型的测试。
 * 比如bit.set(0);set(2);set(10);之后就设置第0,2,10位的值为1,就是10000000101
 * 1.位保存。每一位只有0和1。初始化的时候都为0，set(index)方法设置index位为1。
 * 2.默认toString方法打印为1的index值。比如bit打印就是{0,2,10}
 * 3.底层存储为long[]类型。java一个long类型可以保存下64个位。bit从左边起第0,2,10位为1，就是10000000101,转成long类型就是1024+4+1=1029。long[]数组里面就只有一个值就是1029。
 * 如果set(64)。那么65位的值也为1，第一个取前面64位，第二个取后面的值。那么long[]={1029,1}。数组里面有两个值
 * 4.bitset遍历所有为1的方式如下: for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i+1)) { // operate on index i here }
 * Created by tim.syh on 2021/7/15.
 */
public class BitSetTest {

    private static final Logger logger = LoggerFactory.getLogger(BitSetTest.class);

    @Test
    public void initBitSet() {
        BitSet bs = new BitSet();
        bs.set(0);
        bs.set(2);
        bs.set(10);
//        bitset1.set(64);
        logger.info(bs.toString());
        long[] longs = bs.toLongArray();

        String str = "this is a name";
        BitSet bitset2 = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            bitset2.set(str.charAt(i));
        }
    }

    @Test
    public void foreachBitset() {
        BitSet bs = new BitSet();
        bs.set(0);
        bs.set(2);
        bs.set(10);
        bs.set(64);
        logger.info(bs.toString());

        //打印真实值，也就是bit=1的索引值
        for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i+1)) {
            logger.info(i + "--");
        }
    }
}

