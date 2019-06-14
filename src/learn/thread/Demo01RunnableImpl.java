package learn.thread;

//使用同步代码块

public class Demo01RunnableImpl implements Runnable {
	
	private int ticket = 100; //共享资源
	
	Object obj = new Object(); //所对象,所有线程要使用同一个锁对象
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized(obj) {
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
}