package nowcoder.test2018;
//��Դ:ƴ���У����
//���������ַ�����ʾ�ķǳ���Ĵ�����,������ǵĳ˻���Ҳ�����ַ�����ʾ��������ϵͳ�Դ��Ĵ��������͡�

//����:�ո�ָ��������ַ������������������������
//���:����ĳ˻������ַ�����ʾ
import java.util.*;

public class TwoBigNumMulti {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] tmp = s.split("\\ "); //�������ַ����������ֿ�
		sc.close();
		String[] s1 = tmp[0].split(""); //��ÿ�����ֶ��ֿ�
		String[] s2 = tmp[1].split("");
		int[] num1 = new int[s1.length];
		int[] num2 = new int[s2.length];
		for (int i = num1.length - 1; i >= 0 ; i--) { //����������������,���򱣴�
			num1[num1.length - 1-i] = Integer.parseInt(s1[i]);
		}
		for (int i = num2.length - 1; i >= 0 ; i--) {
			num2[ num2.length - 1-i] = Integer.parseInt(s2[i]);
		}
		
		int[][] num = new int[num2.length][num1.length + num2.length];
		for (int i = 0; i < num2.length; i++) {//ģ�ⲻ����λ������
			for (int j = 0; j < num1.length; j++) {
				int temp = num2[i] * num1[j];
				num[i][i+j] = temp;
			}
			
		}
		
		for (int i = 0; i < num2.length; i++) {//��λ����
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
		
		for (int i = 0; i < num1.length + num2.length; i++) {//�����ǽ�λ����ʽ���
			int temp = 0;
			for (int j = 0; j < num2.length; j++ ) {
				temp += num[j][i]; 
			}
			result[i] = temp;
		}
		
		for (int i = 0; i< result.length - 1; i++) {//�Խ�Ϊ������
			int temp = result[i];
			int c = temp / 10;
			int r = temp % 10;
			result[i] = r;
			result[i+1] += c;
		}
		
		if (result[result.length -1] == 0) {//�ж����λ�Ƿ�Ϊ0
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
