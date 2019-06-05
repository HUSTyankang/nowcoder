package wangyi.test;
//题目来源:网易校招题

/*
题目描述:
小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
1、将a_i放入b序列的末尾
2、逆置b序列
小易需要你计算输出操作n次之后的b序列。
 */

/*
输入描述:
输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
输出描述:
在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
 */

/*
输入
4
1 2 3 4
输出
4 2 1 3
 */

import java.util.*;

public class OperateSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] arrayA = sc.nextLine().split(" ");
		sc.close();
		
		//方法一:根据要求的操作规则做,但复杂度太高:用到多次Collections.reverse(listB)
		/*
		
		LinkedList<String> listB = new LinkedList<>();
		
		for (String str : arrayA) {
			listB.add(str); //加到末尾
			Collections.reverse(listB); //反转
		}
		
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				System.out.print(listB.get(i));
			}else {System.out.print(listB.get(i) + " ");}
		}
		*/
		
		/*方法二:根据规则可以看出,输入的最后一个元素操作结束后索引为:0
		 * 输入的倒数第二个元素操作结束后索引为:n-1
		 *  输入的倒数第三个元素操作结束后索引为:1
		 *  输入的倒数第四个元素操作结束后索引为:n-2
		 *  。。。
		 *  看出第偶数次为正序,第奇数次为倒序
		 * 则可以对arrayA进行倒序遍历,
		 */
		String[] arrayB = new String[n]; //空序列b
		int counter = 0; 
		for (int i = n - 1, j = 0; i >= 0; i--, j++) { //i做为反转的索引,j用来判断此次循环次数的奇偶
			if (j % 2 == 0) {arrayB[counter] = arrayA[i];counter++;} //偶数次,正序
			else {arrayB[n-counter] = arrayA[i];} //奇数次,倒序
		}
		
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				System.out.print(arrayB[i]);
			}else {System.out.print(arrayB[i] + " ");}
		}
	}
}
