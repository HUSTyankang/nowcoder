package wangyi.test;

import java.util.Arrays;
import java.util.Scanner;

//��Ŀ��Դ������У����

/* ��Ŀ������
 * ���һ������S����������еĺϷ���i,����S[i + 1] = S[i] + d, 
 * �����dҲ�����Ǹ�������,���Ǿͳ�����SΪ�Ȳ����С�
 * С��������һ������Ϊn������x,С�����x��Ϊһ���Ȳ����С�С��������������
 * ��������������λ�õ���ֵ�Ĳ���,���ҽ���������������Ρ�������Щ����ͨ��
 * �������ǲ��ܱ�ɵȲ�����,С����Ҫ�б�һ�������Ƿ���ͨ������������ɵȲ�����
 */

/* ����������
 * �����������,��һ�а�������n(2 �� n �� 50),�����еĳ��ȡ�
 * �ڶ���n��Ԫ��x[i](0 �� x[i] �� 1000),�������е�ÿ��������
 */

/* �������
 * ������Ա�ɵȲ��������"Possible",�������"Impossible"��
 */

/* ʾ����
 * ����:
 * 3
 * 3 1 2
 * �����
 * Possible
 */

/* ˼·��
 * �ȶ����ݽ��������ټ�������������Ԫ�صĲ�ֵ�Ƿ���ȣ��в��ȵ�������ǵȲ�����
 */
public class ArithmeticProgression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//��ȡ���鳤��
		sc.nextLine();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();//�����ݷ���������
		}
		sc.close();
		
		Arrays.sort(array);//��array��������
		boolean flag = true;//��־λ���������Ԫ�صĲ�ֵ�Ƿ����
		for (int i = 0; i < n - 2; i++) {//��������
			if (array[i] - array[i+1] != array[i+1] - array[i+2]) {//�ж�����Ԫ�صĲ�ֵ�Ƿ����
				flag = false;//�������flag���Ϊfalse
				break;//����ѭ��
			}
		}
		
		//ͨ��flag�жϽ����flagΪtrue�����Possible���������Impossible
		if (flag) {System.out.println("Possible");}
		else {System.out.println("Impossible");}
	}
}
