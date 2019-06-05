package learn.test_thread;
//ÀûÓÃThread
public class MyThread extends Thread  {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "-->" + i);
		}
	}
}
