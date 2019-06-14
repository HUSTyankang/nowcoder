package learn.thread;

//静态代同步方法

public class Demo03RunnableImpl implements Runnable {

	private static int ticket = 100;
	
	//Object obj = new Object();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			fun();
		}
	}
	
	public static synchronized void fun() {
		//synchronized(obj) {
		if (ticket > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "正在卖第：" + ticket + "张票");
			ticket--;
		}
	//}
	}

}
