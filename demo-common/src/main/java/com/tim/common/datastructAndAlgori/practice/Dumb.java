package com.tim.common.datastructAndAlgori.practice;

/**
 * 关灯的习题
 * 题目：
 大厅里有100盏灯，每盏灯都编了号码，分别为1-100。每盏灯由一个开关来控制。
 （开关按一下，灯亮，再按一下灯灭。开关的编号与被控制的灯相同。）开始时，灯是全灭的。现在按照以下规则按动开关。
 第一次，将所有的灯点亮。
 第二次，将所有2的倍数的开关按一下。
 第三次，将所有3的倍数的开关按一下。
 以此类推。第N次，将所有N的倍数的开关按一下。
 问第N次（N大于等于2，且小于等于100）按完以后，大厅里还有几盏灯是亮的。

 解答: 比如6=1*6=2*3，原始状态是关，1和6都转换一次之后又是关（因为两次开就是关嘛），2和3转换之后也都是关。
 所有的数都是两个成对出现都会关。只有比如4=1*4=2*2 这种平方数，因为2只出现一次，所以会开。
 */
public class Dumb {

	public void theLessDumb(final int maxOpNum){
		boolean[] result = new boolean[101];
        //原始状态100盏灯都是熄灭的。
		for(int i = 1;i < result.length;i++){
			result[i] = false;
		}
		//i 表示灯的序号，j表示多少的倍数
		for(int i = 1;i <= 100; i++){
			for(int j = 1; j <= maxOpNum; j++){
				if(i % j == 0){
					result[i] = !result[i];
				}
			}
		}

		String allNightNum = "";
		for(int i = 1;i < result.length;i++){
			if(result[i]){
                allNightNum += i + ",";
			}
        }
        System.out.println("the " + allNightNum + " lab is light!");
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//输入100，输出：the 1,4,9,16,25,36,49,64,81,100, lab is light!发现都是平方数
	    new Dumb().theLessDumb(100);
        //输入99，输出：the 1,4,9,16,25,36,49,64,81, lab is light!发现都是平方数
        new Dumb().theLessDumb(99);
	}

}
