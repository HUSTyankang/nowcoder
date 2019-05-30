package nowcoder.test2018;
//题目来源：拼多多校招

/* 题目描述：
 * 假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。迷宫可以用一个二维矩阵组成，
 * 有的部分是墙，有的部分是路。迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙
 * 才能打开门。请设计一个算法，帮助探险家找到脱困的最短路径。如前所述，迷宫是通过一个二维矩阵表示的，每个元素的
 * 值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门
 * 的钥匙
 */

/* 输入描述：
 * 迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N
 * 后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。M和N都不超过100, 门不超过10扇。
 */

/* 输入示例：
5 5
02111
01a0A
01003
01001
01111

*结果：7
 */

/* 思路：
 * 就是在BFS的基础上添加了钥匙与门，因为钥匙有10把，所以用10位的二进制数表示key，用flag[x][y][key]来
 * 标记是否被访问，
 */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class FindRoad {
	
	static class Node {//Node类有四个属性，分别是x坐标，y坐标，钥匙状态，钥匙数量
		private int x;//x坐标
		private int y;//y坐标
		private int key;//钥匙
		public  int level;//树的层数

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
		
		boolean[][][] flag = new boolean[row][col][1024];//用来保存走过的步数，0表示未标记过
		
		Queue<Node> queue = new LinkedList<>();//实例化一个queue
		queue.offer(new Node(startX,startY,0,0));//将起点进入列队
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();//起点出队列
			
			if (node.getX() == endX && node.getY() == endY) {//判断是否到达终点
				System.out.println("最小步数：" + node.level);	
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				//获取相连的点的坐标
				int x = dirX[i] + node.getX();
				int y = dirY[i] + node.getY();
				int key = node.getKey();//获取钥匙状态
				int level = node.level;//获取层数
			
				if (x < 0 || y < 0 || x >= row || y >= col) {continue;}//越界
				else if (graph[x][y] == '0') {continue;}//通
				else if (flag[x][y][key]) {continue;}//被标记过
				else if (('A' <= graph[x][y] && graph[x][y] <= 'Z') && (key & (1 << (graph[x][y] - 'A'))) == 0) {//遇门但是无钥匙
					continue;
				}else if ('a' <= graph[x][y] && graph[x][y] <= 'z') {//遇钥匙
					key = key|(1<<(graph[x][y]-'a'));//拿上钥匙
				}
				
				if (!flag[x][y][key]) {//此路未标记过
					flag[x][y][key] = true;//将走过的路进行标注
					queue.offer(new Node(x, y,key,level+1));//新获得的点进入列队
				}			
			}
		}
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
		
		bfs(graph,'2','3');//start:'2' end:'3'

	}

}



