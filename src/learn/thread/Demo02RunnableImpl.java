package learn.thread;

//使用同步方法

public class Demo02RunnableImpl implements Runnable {

	private int ticket = 100;
	
	//Object obj = new Object();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			//fun();
			fun1();
		}
	}
	
	public synchronized void fun() {
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
	
	public  void fun1() {
		synchronized(this) { //静态代码块的锁对象是本身
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
		}
	}
}