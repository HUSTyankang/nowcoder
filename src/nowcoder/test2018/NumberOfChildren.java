package nowcoder.test2018;

import java.util.Arrays;
import java.util.Scanner;
//来源:拼多多校招题

/*要求：
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，
 * 当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧
 * 克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个
 * 孩子或将一块分给多个孩子。
 */

/*输入描述:
 *第一行：n，表示h数组元素个数
 *第二行：n个h数组元素
 *第三行：m，表示w数组元素个数
 *第四行：m个w数组元素
 */


/*思路：
 * 利用arrayW保存w，利用arrayH保存h
 * 对arrayW和arrayH进行降序序排序,最小的与最小的进行比较
 * 遍历w当 w >= h时h=0, break
 * 统计arrayH中0的个数
 */

public class NumberOfChildren {

	/*public static void sortArray(int[] array) {//利用冒泡法降序排序
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] <= array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //读取四行数据
		String stringN = sc.nextLine();
		String h       = sc.nextLine();
		String stringM = sc.nextLine();
		String w       = sc.nextLine();
		sc.close();
		
		int n = Integer.parseInt(stringN); //得到整数n
		int m = Integer.parseInt(stringM); //得到整数m
		
		int[] arrayH = new int[n]; //声明arrayH长度为n
		int[] arrayW = new int[m]; //声明arrayW长度为m
		
		String[] stringH = h.split(" "); //去掉空格
		String[] stringW = w.split(" ");
		
		for (int i = 0; i < n; i++) { //对arrayH赋值
			arrayH[i] = Integer.parseInt(stringH[i]); //将String转为Integer并拆箱给arrayH[i]
		}
		
		for (int i = 0; i < m; i++) { //对arrayW赋值
			arrayW[i] = Integer.parseInt(stringW[i]); //将String转为Integer并拆箱给arrayW[i]
		}
		
		Arrays.sort(arrayH); //对arrayH进行降序排序
		Arrays.sort(arrayW); //对arrayW进行降序排序
		
		//sortArray(arrayH); //对arrayH进行降序排序
		//sortArray(arrayW); //对arrayW进行降序排序
		
		int record = 0;//记录比较到的位置
		int counter = 0;//计数变量
		for (int j = 0; j < m; j++) { //遍历arrayW
			for (int i = record; i < n; i++) { //遍历arrayH
				if (arrayW[j] >= arrayH[i]) { //w[j] >= h[i]时上台
					arrayH[i] = 0; //为0表示以上台
					record++;
					counter++;
					break;
				}
			}
		}
		
		/*int counter = 0;//计数变量
		for (int i : arrayH) {//遍历arrayH
			if (i == 0) {
				counter++;//arrayH中0的个数为上台的学生数
			}
		}*/
		
		System.out.println(counter);
	}

}
