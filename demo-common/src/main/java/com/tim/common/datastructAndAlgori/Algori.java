package com.tim.common.datastructAndAlgori;

/**
 * 算法大全
 * @author 苏阳华
 * @since 2015-04-30
 *
 */
public class Algori {

	public static void main(String[] args) {
//		buy100Chicken_g();
		System.out.println("the total peach = " + monkeyEatPeach(1));
	}
	
	/**
	 * 百钱买百鸡.  公鸡5文钱一只，母鸡3文钱一只，小鸡3只一文钱，
	 * 用100文钱买一百只鸡,其中公鸡，母鸡，小鸡都必须要有，问公鸡，母鸡，小鸡要买多少只刚好凑足100文钱
	 * 思路：逐步循环，时间复杂度为O(n^2)
	 */
	public static void buy100Chicken(){
		for(int i = 1;i < 20;i++){
			for (int j = 0; j < 32; j++) {
				int z = 100 - i - j;
				if(z % 3 == 0 && ((i * 5 + j * 3 + z / 3) == 100)){
					System.out.println("公鸡=" + i + "，母鸡=" + j + ",小鸡=" + z);
				}
			}
		}
	}
	
	/**
	 * 百钱买百鸡（优化算法）  公鸡5文钱一只，母鸡3文钱一只，小鸡3只一文钱，
	 * 用100文钱买一百只鸡,其中公鸡，母鸡，小鸡都必须要有，问公鸡，母鸡，小鸡要买多少只刚好凑足100文钱
	 * 思路：根据上个方法的结果看出来：购买公鸡的个数都是为4的倍数，所以x=4k，并且x<20,所以k<5
	 * 再根据x+y+z=100 和5x+3y+z/3=100 两个消去z得到7x+4y=100,那么从中也可以得到x一定为4的倍数，y一定是7的倍数。
	 * 起复杂度为O(n),首先是经过数学计算的
	 * 
	 */
	public static void buy100Chicken_g(){
		//定义公鸡，母鸡，小鸡的个数
		int x,y,z;
		for(int k = 1;k <= 3;k++){
			x = 4 * k;
			y = 25 - 7 * k;
			z = 3 * k + 75;
			if((x * 5 + y * 3 + z / 3) == 100){
				System.out.println("公鸡=" + x + "，母鸡=" + y + ",小鸡=" + z);
			}
		}
	}
	
	/**
	 * 猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾就多吃了一个。第二天早上又将剩下的桃子吃了一半，还是不过瘾又多吃了一个。
	 * 以后每天都吃前一天剩下的一半再加一个。到第10天刚好剩一个。问猴子第一天摘了多少个桃子？
	 * 分析：S(n-1) = S(n) * 1/2 + 1得到S(n)=2S(n-1) + 2
	 * 老师说线性递归会将“变量，参数，返回值”在“递”的过程中压栈，如果迟迟“递”不到头的话，
	 * 栈就会越积越多，最后就爆掉了，window中系统默认的堆栈空间是1M,如果MAX_DAY = Integer.MAX时就会报栈溢出错误。所以算法需要改进
	 * @param n
	 * @return
	 */
	private final static int MAX_DAY = 2;
	public static int monkeyEatPeach(int day){
		if(day == MAX_DAY){
			return 1;
		}else {
			return 2 * monkeyEatPeach(day + 1) + 2;
		}
	}

}
