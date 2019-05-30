package learn.bfs_and_bfs;

/* BFS�㷨
 * �ַ�'0'Ϊǽ�������Ŀ���ͨ��
 * �ַ�'2'������㣬�ַ�'3'�����յ�
 * ����ʾ��
5 5
02111
01a0A
01003
01001
01111
 * �����5
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsTest {
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
		
		int dis[][] = new int[row][col];//���������߹��Ĳ�����0��ʾδ��ǹ�
		
		Queue<Node> queue = new LinkedList<>();//ʵ����һ��queue
		queue.offer(new Node(startX,startY));//���������ж�
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();//��������
			
			if (node.getX() == endX && node.getY() == endY) {
				System.out.println("��С������" + dis[endX][endY]);	
				break;
			}//�ж��Ƿ񵽴��յ�
			
			for (int i = 0; i < 4; i++) {
				//��ȡ�����ĵ������
				int x = dirX[i] + node.getX();
				int y = dirY[i] + node.getY();
				//�ж��Ƿ�Խ�磬�Ƿ��ߵ�ͨ���Ƿ񱻱��
				if(x >= 0 && y >= 0 && x < row && y < col && graph[x][y] != '0' && dis[x][y] == 0) {
					queue.offer(new Node(x, y));//�»�õĵ�����ж�
                    dis[x][y] = dis[node.getX()][node.getY()] + 1;//������룬��ǰһ��ľ����ϼ�һ
				}
			}
			
		}
		
		//System.out.println("��С������" + dis[endX][endY]);	
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
		
		bfs(graph,'2','3');
	}

}
