package learn.test_thread;

public class RunableImpl implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "-->" + i);
		}
	}
}
