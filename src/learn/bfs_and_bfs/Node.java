package learn.bfs_and_bfs;
/*
 * 用于保存坐标
 */
public class Node {
	private int x;
	private int y;
	
	/**
	 * @param x
	 * @param y
	 */
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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

}
