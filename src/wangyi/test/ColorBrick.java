package wangyi.test;

import java.util.*;

//��Դ������У����

/*��Ŀ����:
 *С����һЩ��ɫ��ש�顣ÿ����ɫ��һ����д��ĸ��ʾ��������ɫש�鿴��������ȫһ����
 *������һ���������ַ���s,s��ÿ���ַ�����С�׵�ĳ��ש�����ɫ��С����������е�
 *ש���ų�һ�С����������һ�Բ�ͬ��ɫ������ש��,��ô����ש��ͺ�Ư���ġ������
 *��С�׼����ж����ַ�ʽ��������ש���ų�Ư����һ�С�
 *(������ַ�ʽ����Ӧ��ש����ɫ��������ͬ��,��ô��Ϊ�����ַ�ʽ��һ���ġ�)
 *����: s = "ABAB",��ôС�����������еĽ��:
 *"AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 *����ֻ��"AABB"��"BBAA"�������ֻ��һ�Բ�ͬ��ɫ������ש�顣
 */

/*��������:
 *�������һ���ַ���s,�ַ���s�ĳ���length(1 �� length �� 50),s�е�ÿһ���ַ���Ϊһ����д��ĸ(A��Z)��
 */

/*ʾ����
 * ���룺
 * ABAB
 * �����
 * 2
 */

//˼·��һ����ɫ��һ�֣�������ɫ�����֣�����������ɫ�����֣�����ֱ���ж�������м��ֲ�ͬ����ĸ����
public class ColorBrick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray(); 
		sc.close();
		//����1������setȥ��
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
		
		//����2
		//���ظ����ַ���Ϊ0��ͳ��0�ĸ�����������ĳ��ȼ���0�ĸ����������ظ����ַ��ĸ���
		int counter = 0; //����ͳ��0�ĸ���
		int len = s.length;//����ĳ���
		for (int i = 0; i < len - 1; i++) {//��������
			if(s[i] == '0') {continue;}//���Ϊ0��������
			for (int j = len - 1; j > i; j--) {//��ĩβ��ʼ����
				if (s[i] == s[j]) { //�ظ�����0
					s[j] = '0';
					counter++;//��������һ
				}
			}
		}
		if (len - counter <= 1) {System.out.println(1);}
		else if (len - counter <= 2) {System.out.println(2);}
		else {System.out.println(0);}

	}
}
