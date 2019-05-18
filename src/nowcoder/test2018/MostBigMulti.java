package nowcoder.test2018;
 
import java.util.*;
//来源:拼多多校招题
//给定一个无序数组,包含正数,负数和0,要求从中找出3个数的乘积,使得乘积最大,要求时间复杂度:O(n),空间复杂:O(1)

//输入:无序整数数组A[n]
//输出:满足条件的最大乘积

//思路:最大值肯定是三个最大的正相乘或者是最大的正数乘最小的两个负数
//则可以比较最大的三个数的乘积和最大的数与最小的两个数的乘积的大小,取最大的乘积

public class MostBigMulti {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] temp = s.split("\\ ");
		long[] num = new long[temp.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(temp[i]);
		}
		sc.close();
		
		long max1 = 0; 
		long max2 = 0; 
		long max3 = 0;
		long min1 = 0; 
		long min2 = 0;
		
		for (int i = 0 ; i < num.length; i++) {
			if (num[i] >= max1) { 
				max3 = max2;
				max2 = max1;
				max1 = num[i];
			}else if(num[i] >= max2) {
				max3 = max2;
				max2 = num[i];
			}else if(num[i] >= max3) {
				max3 = num[i];
			}else if(num[i] <= min2) {
				min1 = min2;
				min2 = num[i];
			}else if(num[i] <= min1) {
				min1 = num[i];
			}
		}
		
		long max = max1 * max2 * max3 >= max1 * min2 * min1 ? max1 * max2 * max3:max1 * min2 * min1;
		
		System.out.println(max);
	}

}
