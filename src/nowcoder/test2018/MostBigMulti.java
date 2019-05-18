package nowcoder.test2018;
 
import java.util.*;
//��Դ:ƴ���У����
//����һ����������,��������,������0,Ҫ������ҳ�3�����ĳ˻�,ʹ�ó˻����,Ҫ��ʱ�临�Ӷ�:O(n),�ռ临��:O(1)

//����:������������A[n]
//���:�������������˻�

//˼·:���ֵ�϶���������������˻�����������������С����������
//����ԱȽ������������ĳ˻�������������С���������ĳ˻��Ĵ�С,ȡ���ĳ˻�

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
