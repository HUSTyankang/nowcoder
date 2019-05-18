package nowcoder.test2018;
//来源:拼多多校招题
//有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。

//输入:空格分隔的两个字符串，代表输入的两个大整数
//输出:输入的乘积，用字符串表示
import java.util.*;

public class TwoBigNumMulti {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] tmp = s.split("\\ "); //将两个字符串大整数分开
		sc.close();
		String[] s1 = tmp[0].split(""); //将每个数字都分开
		String[] s2 = tmp[1].split("");
		int[] num1 = new int[s1.length];
		int[] num2 = new int[s2.length];
		for (int i = num1.length - 1; i >= 0 ; i--) { //保存在整型数组中,倒序保存
			num1[num1.length - 1-i] = Integer.parseInt(s1[i]);
		}
		for (int i = num2.length - 1; i >= 0 ; i--) {
			num2[ num2.length - 1-i] = Integer.parseInt(s2[i]);
		}
		
		int[][] num = new int[num2.length][num1.length + num2.length];
		for (int i = 0; i < num2.length; i++) {//模拟不做进位的手算
			for (int j = 0; j < num1.length; j++) {
				int temp = num2[i] * num1[j];
				num[i][i+j] = temp;
			}
			
		}
		
		for (int i = 0; i < num2.length; i++) {//进位调整
			for (int j = 0; j < num1.length; j++) {
				int temp = num[i][j];
				int c = temp / 10;
				int r = temp % 10;
				num[i][j] = r;
				num[i][j+1] += c;
			}
			int temp = num[num2.length-1][num1.length + num2.length-2];
			int c = temp / 10;
			int r = temp % 10;
			num[num2.length-1][num1.length + num2.length-2] = r;
			num[num2.length-1][num1.length + num2.length-1] += c;
		}

		int[] result = new int[num1.length + num2.length];
		
		for (int i = 0; i < num1.length + num2.length; i++) {//不考虑进位的竖式相加
			int temp = 0;
			for (int j = 0; j < num2.length; j++ ) {
				temp += num[j][i]; 
			}
			result[i] = temp;
		}
		
		for (int i = 0; i< result.length - 1; i++) {//对进为做调整
			int temp = result[i];
			int c = temp / 10;
			int r = temp % 10;
			result[i] = r;
			result[i+1] += c;
		}
		
		if (result[result.length -1] == 0) {//判断最高位是否为0
			for (int i = result.length - 2; i >= 0; i--) {
				System.out.print(result[i]);
			}
		}else {
			for (int i = result.length - 1; i >= 0; i--) {
				System.out.print(result[i]);
			}
		}
	}

}
