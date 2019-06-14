package learn.thread;
//出现线程安全

//在线程共用公共资源时就可能出现线程安全问题

//可能出现不存在的票和重复的票


public class RunnableImpl implements Runnable {
	
	private int ticket = 100; //共享资源
	
	@Override
	public void run() { //重写run方法
		// TODO Auto-generated method stub
		while (true) { 
			if (ticket > 0) { //判断是否还有票
				try {
					Thread.sleep(10); //线程睡眠10ms,增加出现线程安全的可能性
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
