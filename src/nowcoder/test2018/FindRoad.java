package nowcoder.test2018;
//��Ŀ��Դ��ƴ���У��

/* ��Ŀ������
 * ����һ��̽�ռұ������˵ص׵��Թ�֮�У�Ҫ�ӵ�ǰλ�ÿ�ʼ�ҵ�һ��ͨ���Թ����ڵ�·�����Թ�������һ����ά������ɣ�
 * �еĲ�����ǽ���еĲ�����·���Թ�֮���е�·�ϻ����ţ�ÿ���Ŷ����Թ���ĳ���ط�����֮ƥ���Կ�ף�ֻ�����õ�Կ��
 * ���ܴ��š������һ���㷨������̽�ռ��ҵ����������·������ǰ�������Թ���ͨ��һ����ά�����ʾ�ģ�ÿ��Ԫ�ص�
 * ֵ�ĺ������� 0-ǽ��1-·��2-̽�ռҵ���ʼλ�ã�3-�Թ��ĳ��ڣ���д��ĸ-�ţ�Сд��ĸ-��Ӧ��д��ĸ���������
 * ��Կ��
 */

/* ����������
 * �Թ��ĵ�ͼ���ö�ά�����ʾ����һ���Ǳ�ʾ���������������M��N
 * �����M���Ǿ�������ݣ�ÿһ�ж�Ӧ������һ�У��м�û�пո񣩡�M��N��������100, �Ų�����10�ȡ�
 */

/* ����ʾ����
5 5
02111
01a0A
01003
01001
01111

*�����7
 */

/* ˼·��
 * ������BFS�Ļ����������Կ�����ţ���ΪԿ����10�ѣ�������10λ�Ķ���������ʾkey����flag[x][y][key]��
 * ����Ƿ񱻷��ʣ�
 */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class FindRoad {
	
	static class Node {//Node�����ĸ����ԣ��ֱ���x���꣬y���꣬Կ��״̬��Կ������
		private int x;//x����
		private int y;//y����
		private int key;//Կ��
		public  int level;//���Ĳ���

		/**
		 * @param x
		 * @param y
		 * @param key
		 * @param level
		 */
		public Node(int x, int y, int key, int level) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.level = level;
		}

		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}

		/**
		 * @param x the x to set
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}

		/**
		 * @param y the y to set
		 */
		public void setY(int y) {
			this.y = y;
		}

		/**
		 * @return the key
		 */
		public int getKey() {
			return key;
		}

		/**
		 * @param key the key to set
		 */
		public void setKey(int key) {
			this.key = key;
		}
	}
	

	//�����б��Թ�ͼ����㣬�յ�
	public static int[][] findStartAndEnd(char[][] graph, char startFlag, char endFlag) {
		int[][] result = new int[2][2];//��һ�д�ſ�ʼ���꣬�ڶ��д�Ž������ꡣ
		int counter = 0;//�ҵ������յ�ʱcounter�ͼ�һ,counter == 2ʱ����ѭ����
		for (int x = 0; x < graph.length; x++) {//������
			for (int y = 0; y < graph[x].length; y++) {//������
				if (graph[x][y] == startFlag) {//�ж��Ƿ�Ϊ���
					result[0][0] = x;//result[0][0]��������x����
					result[0][1] = y;//result[0][1]��������y����
					counter++;
				}else if (graph[x][y] == endFlag) {//�ж��Ƿ�Ϊ�յ�
					result[1][0] = x;//result[1][0]��������x����
					result[1][1] = y;//result[1][1]��������y����
					counter++;
				}
					
				if (counter == 2) {break;}//counter == 2 ����ѭ��
			}
		}
			
		return result;//���ؽ������һ�д�ſ�ʼ���꣬�ڶ��д�Ž������ꡣ
	}

	public static void bfs(char[][] graph, char startFlag, char endFlag) {
		/* ��ǰλ��(x,y)
		 * up:    x + 0, y - 1
		 * down:  x + 0, y + 1
		 * left:  x - 1, y + 0
		 * right: x + 1, y + 0
		 */
		int[] dirX = new int[] {0,-1,0,1};
		int[] dirY = new int[] {1,0,-1,0};
		
		int[][] label = new int[2][2];//��������������յ������
		label = findStartAndEnd(graph,startFlag,endFlag);//��ȡ������յ������
		int startX = label[0][0];//����x����
		int startY = label[0][1];//����y����
		int endX   = label[1][0];//�յ��x����
		int endY   = label[1][1];//�յ��y����
		int col = graph[0].length;//����
		int row = graph.length;//����
		
		boolean[][][] flag = new boolean[row][col][1024];//���������߹��Ĳ�����0��ʾδ��ǹ�
		
		Queue<Node> queue = new LinkedList<>();//ʵ����һ��queue
		queue.offer(new Node(startX,startY,0,0));//���������ж�
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();//��������
			
			if (node.getX() == endX && node.getY() == endY) {//�ж��Ƿ񵽴��յ�
				System.out.println("��С������" + node.level);	
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				//��ȡ�����ĵ������
				int x = dirX[i] + node.getX();
				int y = dirY[i] + node.getY();
				int key = node.getKey();//��ȡԿ��״̬
				int level = node.level;//��ȡ����
			
				if (x < 0 || y < 0 || x >= row || y >= col) {continue;}//Խ��
				else if (graph[x][y] == '0') {continue;}//ͨ
				else if (flag[x][y][key]) {continue;}//����ǹ�
				else if (('A' <= graph[x][y] && graph[x][y] <= 'Z') && (key & (1 << (graph[x][y] - 'A'))) == 0) {//���ŵ�����Կ��
					continue;
				}else if ('a' <= graph[x][y] && graph[x][y] <= 'z') {//��Կ��
					key = key|(1<<(graph[x][y]-'a'));//����Կ��
				}
				
				if (!flag[x][y][key]) {//��·δ��ǹ�
					flag[x][y][key] = true;//���߹���·���б�ע
					queue.offer(new Node(x, y,key,level+1));//�»�õĵ�����ж�
				}			
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//��ȡn
		int m = sc.nextInt();//��ȡm
		sc.nextLine();//����һ��
		char[][] graph = new char[n][m];//����һ��n*m�Ķ�ά����
		for (int i = 0; i < n; i++) {
			graph[i] = sc.nextLine().toCharArray();//��ȡÿһ�е�Ԫ��
		}
		sc.close();
		
		bfs(graph,'2','3');//start:'2' end:'3'

	}

}



