package wangyi.test;
//��Ŀ��Դ:����У��

/*
 ��Ŀ����:
 ���һ��01��������������λ�õ��ַ����ǲ�һ����,���Ǿͽ����01��Ϊ����01��������: "1","10101","0101010"���ǽ���01����
С��������һ��01��s,С�����ҳ�һ����������Ӵ�,��������Ӵ���һ������01����С����Ҫ����æ�������������Ӵ��ĳ����Ƕ��١�
 */

/*
��������:
��������ַ���s,s�ĳ���length(1 �� length �� 50),�ַ�����ֻ����'0'��'1'
�������:
���һ������,��ʾ�������Ҫ����Ӵ����ȡ�
 */

/*
 ����:
111101111
���:
3
 */

/*
˼·:
�������飬��len��¼����Ԫ�ز�ͬ�ĳ���,��max��¼��󳤶�,��ǰ��Ԫ�ز���ʱlen++,�ٱȽ�len��max�Ĵ�С
len����maxʱ��max=len,����len=1.
 */
import java.util.Scanner;

public class LenOfZeroOneArr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] array = sc.nextLine().toCharArray();//����������ݱ�����������
		sc.close();
		
		int len = 1;//������¼�Ӵ��ĳ���
		int max = 1;//�����������ĳ���
	
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != array[i+1]) {//ǰ��ͬʱlen++
				len++;
				if (max <= len) {//�ж�max��len�Ĵ�С
					max = len;//����max,����maxһֱ�����ֵ
				}
			}else {//ǰ��ͬʱlen��1
				len = 1;
			}
		}
		System.out.println(max);//max�б���������ֵ,���max
	}

}
