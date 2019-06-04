package wangyi.test;
//题目来源:网易校招

/*
 题目描述:
 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 */

/*
输入描述:
输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'
输出描述:
输出一个整数,表示最长的满足要求的子串长度。
 */

/*
 输入:
111101111
输出:
3
 */

/*
思路:
遍历数组，用len记录相连元素不同的长度,用max记录最大长度,当前后元素不等时len++,再比较len与max的大小
len大于max时，max=len,否则将len=1.
 */
import java.util.Scanner;

public class LenOfZeroOneArr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] array = sc.nextLine().toCharArray();//将输入的数据保存在数组中
		sc.close();
		
		int len = 1;//用来记录子串的长度
		int max = 1;//用来接收最大的长度
	
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != array[i+1]) {//前后不同时len++
				len++;
				if (max <= len) {//判断max与len的大小
					max = len;//更新max,保持max一直是最大值
				}
			}else {//前后不同时len置1
				len = 1;
			}
		}
		System.out.println(max);//max中保存的是最大值,输出max
	}

}
