package wangyi.test;
//��Ŀ��Դ:����У����

/*
��Ŀ����:
С����һ������Ϊn����������,a_1,...,a_n��Ȼ������һ��������b�Ͻ���n�����²���:
1����a_i����b���е�ĩβ
2������b����
С����Ҫ������������n��֮���b���С�
 */

/*
��������:
�����������,��һ�а���һ������n(2 �� n �� 2*10^5),�����еĳ��ȡ�
�ڶ��а���n������a_i(1 �� a_i �� 10^9),������a�е�ÿ������,�Կո�ָ
�������:
��һ�����������n��֮���b����,�Կո�ָ�,��ĩ�޿ո�
 */

/*
����
4
1 2 3 4
���
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
		
		//����һ:����Ҫ��Ĳ���������,�����Ӷ�̫��:�õ����Collections.reverse(listB)
		/*
		
		LinkedList<String> listB = new LinkedList<>();
		
		for (String str : arrayA) {
			listB.add(str); //�ӵ�ĩβ
			Collections.reverse(listB); //��ת
		}
		
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				System.out.print(listB.get(i));
			}else {System.out.print(listB.get(i) + " ");}
		}
		*/
		
		/*������:���ݹ�����Կ���,��������һ��Ԫ�ز�������������Ϊ:0
		 * ����ĵ����ڶ���Ԫ�ز�������������Ϊ:n-1
		 *  ����ĵ���������Ԫ�ز�������������Ϊ:1
		 *  ����ĵ������ĸ�Ԫ�ز�������������Ϊ:n-2
		 *  ������
		 *  ������ż����Ϊ����,��������Ϊ����
		 * ����Զ�arrayA���е������,
		 */
		String[] arrayB = new String[n]; //������b
		int counter = 0; 
		for (int i = n - 1, j = 0; i >= 0; i--, j++) { //i��Ϊ��ת������,j�����жϴ˴�ѭ����������ż
			if (j % 2 == 0) {arrayB[counter] = arrayA[i];counter++;} //ż����,����
			else {arrayB[n-counter] = arrayA[i];} //������,����
		}
		
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				System.out.print(arrayB[i]);
			}else {System.out.print(arrayB[i] + " ");}
		}
	}
}
