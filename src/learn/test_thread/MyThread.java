package learn.test_thread;
//����Thread
public class MyThread extends Thread  {

	@Override
	public void run() {//��дrun()
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "-->" + i);
		}
	}
}
