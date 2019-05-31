package wangyi.test;

import java.util.*;

//来源：网易校招题

/*题目描述:
 *小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。
 *现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。小易想把他所有的
 *砖块排成一行。如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。请你帮
 *助小易计算有多少种方式将他所有砖块排成漂亮的一行。
 *(如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
 *例如: s = "ABAB",那么小易有六种排列的结果:
 *"AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 *其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。
 */

/*输入描述:
 *输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s中的每一个字符都为一个大写字母(A到Z)。
 */

/*示例：
 * 输入：
 * ABAB
 * 输出：
 * 2
 */

//思路：一种颜色就一种，两种颜色就两种，大于两种颜色就零种，所以直接判断输入的有几种不同的字母即可
public class ColorBrick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray(); 
		sc.close();
		//方法1：利用set去重
		/*
		Set<Character> set = new HashSet<>();
		
		for(char c : s) {
			set.add(c);
		}
		
		int len = set.size();
		
		if (len <= 1) {System.out.println(1);}
		else if (len <= 2) {System.out.println(2);}
		else {System.out.println(0);}
		*/
		
		//方法2
		//将重复的字符置为0，统计0的个数，用数组的长度减掉0的个数，就无重复的字符的个数
		int counter = 0; //用来统计0的个数
		int len = s.length;//数组的长度
		for (int i = 0; i < len - 1; i++) {//遍历数组
			if(s[i] == '0') {continue;}//如果为0就跳过，
			for (int j = len - 1; j > i; j--) {//从末尾开始遍历
				if (s[i] == s[j]) { //重复就置0
					s[j] = '0';
					counter++;//计数器加一
				}
			}
		}
		if (len - counter <= 1) {System.out.println(1);}
		else if (len - counter <= 2) {System.out.println(2);}
		else {System.out.println(0);}

	}
}
