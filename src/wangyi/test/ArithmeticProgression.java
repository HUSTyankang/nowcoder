package wangyi.test;

import java.util.Arrays;
import java.util.Scanner;

//题目来源：网易校招题

/* 题目描述：
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 
 * 这里的d也可以是负数和零,我们就称数列S为等差数列。
 * 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上
 * 做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过
 * 交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
 */

/* 输入描述：
 * 输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。
 * 第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数。
 */

/* 输出描述
 * 如果可以变成等差数列输出"Possible",否则输出"Impossible"。
 */

/* 示例：
 * 输入:
 * 3
 * 3 1 2
 * 输出：
 * Possible
 */

/* 思路：
 * 先对数据进行排序，再计算两个相连的元素的差值是否都相等，有不等的情况则不是等差数列
 */
public class ArithmeticProgression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//读取数组长度
		sc.nextLine();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();//将数据放入数组中
		}
		sc.close();
		
		Arrays.sort(array);//对array进行排序
		boolean flag = true;//标志位，标记相连元素的差值是否相等
		for (int i = 0; i < n - 2; i++) {//遍历数组
			if (array[i] - array[i+1] != array[i+1] - array[i+2]) {//判断相连元素的差值是否相等
				flag = false;//不相等是flag标记为false
				break;//结束循环
			}
		}
		
		//通过flag判断结果，flag为true就输出Possible，否则输出Impossible
		if (flag) {System.out.println("Possible");}
		else {System.out.println("Impossible");}
	}
}
