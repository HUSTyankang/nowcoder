package learn.thread;

//��̬��ͬ������

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
			System.out.println(Thread.currentThread().getName() + "�������ڣ�" + ticket + "��Ʊ");
			ticket--;
		}
	//}
	}

}
