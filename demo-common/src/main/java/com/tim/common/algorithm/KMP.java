package com.tim.common.algorithm;

import java.util.Arrays;

/**
 * KMP算法。
 * 思路：具体见小甲鱼 数据结构的视频。他的数组是从1开始的，我的数组是从0开始
 * @author 苏阳华
 * @since 2015-05-06
 *
 */
public class KMP {

	public static void main(String[] args) {
		String sString = "efsgababaaabawww";
		String tString = "ababaaaba";
		System.out.println("模式串[" + tString + "]在主串[" + sString + "] 的第一次位置=" + kmp(sString, tString));
	}
	
	/**
	 * KMP算法
	 * @param sString  主串
	 * @param tString  模式串
	 * @return
	 */
	private static int kmp(String sString, String tString){
		char[] s = sString.toCharArray();
		char[] t = tString.toCharArray();
		int[] next = getNextVal(tString);
		
		//i控制s,j控制t;
		int i = 0;
		int j = 0;
		
		while(i < sString.length() && j < tString.length()){
			//匹配就自动递增，往后匹配。
			if(j == -1 || s[i] == t[j]){
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		
		if(j == tString.length()){
			return i - tString.length();
		}
		
		return -1;
	}
	
	/**
	 * p0,p1....pk-1         （前缀串）
	 * pj-k,pj-k+1....pj-1   （后缀串)
	 *    		 -1        当j=0时
	 * next[j] = max{k| 0<k<j 且 P0P1..Pk-1=Pj-kPj-k+1...Pj-1}
	 * 			 0         其他情况
	 * @param tString 模式串，就是要找的字符窜
	 * @return
	 */
	private static int[] getNextVal(String tString){
		
		int[] next = new int[tString.length()];
		
		//前缀串起始位置("-1"是方便计算）
		int k = -1;
		//后缀串起始位置（"0"是方便计算）
		int j = 0;
		//公式next[0] = -1
		next[j] = -1;
		
		char[] c = tString.toCharArray();
		
		while(j < tString.length() - 1){
			if(k == -1 || c[k] == c[j]){
				//pk=pj的情况: next[j+1]=k+1 => next[j+1]=next[j]+1
				next[++j] = ++k;
			} else {
				//pk != pj 的情况:我们递推 k=next[k];
				//要么找到，要么k=-1中止
				k = next[k];
			}
		}
		System.out.println("模式串[" + tString + "]的next数组=" + Arrays.toString(next));
		return next;
	}

}
