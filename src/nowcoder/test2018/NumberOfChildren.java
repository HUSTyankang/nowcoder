package nowcoder.test2018;

import java.util.Arrays;
import java.util.Scanner;
//��Դ:ƴ���У����

/*Ҫ��
 * ��һ��ͯ�ڣ���ʦ���˺ܶ�óԵ��ɿ������׶�԰��ÿ���ɿ���j������Ϊw[j]������ÿ��С����i��
 * �����ֵ����ɿ�����С�ﵽh[i] (��w[j]>=h[i])�����Ż���ȥ���ݽ�Ŀ����ʦ��Ŀ���ǽ���
 * �����ַ��������ǣ�ʹ������С����̨���ݡ����Ա�֤ÿ��w[i]> 0�Ҳ��ܽ�����ɿ����ָ�һ��
 * ���ӻ�һ��ָ�������ӡ�
 */

/*��������:
 *��һ�У�n����ʾh����Ԫ�ظ���
 *�ڶ��У�n��h����Ԫ��
 *�����У�m����ʾw����Ԫ�ظ���
 *�����У�m��w����Ԫ��
 */


/*˼·��
 * ����arrayW����w������arrayH����h
 * ��arrayW��arrayH���н���������,��С������С�Ľ��бȽ�
 * ����w�� w >= hʱh=0, break
 * ͳ��arrayH��0�ĸ���
 */

public class NumberOfChildren {

	/*public static void sortArray(int[] array) {//����ð�ݷ���������
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
		Scanner sc = new Scanner(System.in); //��ȡ��������
		String stringN = sc.nextLine();
		String h       = sc.nextLine();
		String stringM = sc.nextLine();
		String w       = sc.nextLine();
		sc.close();
		
		int n = Integer.parseInt(stringN); //�õ�����n
		int m = Integer.parseInt(stringM); //�õ�����m
		
		int[] arrayH = new int[n]; //����arrayH����Ϊn
		int[] arrayW = new int[m]; //����arrayW����Ϊm
		
		String[] stringH = h.split(" "); //ȥ���ո�
		String[] stringW = w.split(" ");
		
		for (int i = 0; i < n; i++) { //��arrayH��ֵ
			arrayH[i] = Integer.parseInt(stringH[i]); //��StringתΪInteger�������arrayH[i]
		}
		
		for (int i = 0; i < m; i++) { //��arrayW��ֵ
			arrayW[i] = Integer.parseInt(stringW[i]); //��StringתΪInteger�������arrayW[i]
		}
		
		Arrays.sort(arrayH); //��arrayH���н�������
		Arrays.sort(arrayW); //��arrayW���н�������
		
		//sortArray(arrayH); //��arrayH���н�������
		//sortArray(arrayW); //��arrayW���н�������
		
		int record = 0;//��¼�Ƚϵ���λ��
		int counter = 0;//��������
		for (int j = 0; j < m; j++) { //����arrayW
			for (int i = record; i < n; i++) { //����arrayH
				if (arrayW[j] >= arrayH[i]) { //w[j] >= h[i]ʱ��̨
					arrayH[i] = 0; //Ϊ0��ʾ����̨
					record++;
					counter++;
					break;
				}
			}
		}
		
		/*int counter = 0;//��������
		for (int i : arrayH) {//����arrayH
			if (i == 0) {
				counter++;//arrayH��0�ĸ���Ϊ��̨��ѧ����
			}
		}*/
		
		System.out.println(counter);
	}

}
