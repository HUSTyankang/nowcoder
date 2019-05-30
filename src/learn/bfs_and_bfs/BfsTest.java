package learn.bfs_and_bfs;

/* BFS算法
 * 字符'0'为墙，其他的可以通过
 * 字符'2'代表起点，字符'3'代表终点
 * 输入示例
5 5
02111
01a0A
01003
01001
01111
 * 输出：5
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsTest {
	//参数列表：迷宫图，起点，终点
	public static int[][] findStartAndEnd(char[][] graph, char startFlag, char endFlag) {
		int[][] result = new int[2][2];//第一行存放开始坐标，第二行存放结束坐标。
		int counter = 0;//找到起点或终点时counter就加一,counter == 2时结束循环。
		for (int x = 0; x < graph.length; x++) {//遍历行
			for (int y = 0; y < graph[x].length; y++) {//遍历列
				if (graph[x][y] == startFlag) {//判断是否为起点
					result[0][0] = x;//result[0][0]保存起点的x坐标
					result[0][1] = y;//result[0][1]保存起点的y坐标
					counter++;
				}else if (graph[x][y] == endFlag) {//判断是否为终点
					result[1][0] = x;//result[1][0]保存起点的x坐标
					result[1][1] = y;//result[1][1]保存起点的y坐标
					counter++;
				}
				
				if (counter == 2) {break;}//counter == 2 结束循环
			}
		}
		
		return result;//返回结果，第一行存放开始坐标，第二行存放结束坐标。
	}
	
	public static void bfs(char[][] graph, char startFlag, char endFlag) {
		/* 当前位置(x,y)
		 * up:    x + 0, y - 1
		 * down:  x + 0, y + 1
		 * left:  x - 1, y + 0
		 * right: x + 1, y + 0
		 */
		int[] dirX = new int[] {0,-1,0,1};
		int[] dirY = new int[] {1,0,-1,0};
		
		int[][] label = new int[2][2];//用来接收起点与终点的坐标
		label = findStartAndEnd(graph,startFlag,endFlag);//获取起点与终点的坐标
		int startX = label[0][0];//起点的x坐标
		int startY = label[0][1];//起点的y坐标
		int endX   = label[1][0];//终点的x坐标
		int endY   = label[1][1];//终点的y坐标
		int col = graph[0].length;//列数
		int row = graph.length;//行数
		
		int dis[][] = new int[row][col];//用来保存走过的步数，0表示未标记过
		
		Queue<Node> queue = new LinkedList<>();//实例化一个queue
		queue.offer(new Node(startX,startY));//将起点进入列队
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();//起点出队列
			
			if (node.getX() == endX && node.getY() == endY) {
				System.out.println("最小步数：" + dis[endX][endY]);	
				break;
			}//判断是否到达终点
			
			for (int i = 0; i < 4; i++) {
				//获取相连的点的坐标
				int x = dirX[i] + node.getX();
				int y = dirY[i] + node.getY();
				//判断是否越界，是否走的通，是否被标记
				if(x >= 0 && y >= 0 && x < row && y < col && graph[x][y] != '0' && dis[x][y] == 0) {
					queue.offer(new Node(x, y));//新获得的点进入列队
                    dis[x][y] = dis[node.getX()][node.getY()] + 1;//保存距离，在前一点的距离上加一
				}
			}
			
		}
		
		//System.out.println("最小步数：" + dis[endX][endY]);	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//获取n
		int m = sc.nextInt();//获取m
		sc.nextLine();//读下一行
		char[][] graph = new char[n][m];//声明一个n*m的二维数组
		for (int i = 0; i < n; i++) {
			graph[i] = sc.nextLine().toCharArray();//获取每一行的元素
		}
		sc.close();	
		
		bfs(graph,'2','3');
	}

}
