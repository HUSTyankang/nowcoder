package learn.thread;

//ʹ��ͬ������

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
			System.out.println(Thread.currentThread().getName() + "�������ڣ�" + ticket + "��Ʊ");
			ticket--;
		}
	//}
	}
	
	public  void fun1() {
		synchronized(this) { //��̬�������������Ǳ���
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
		}
	}
}