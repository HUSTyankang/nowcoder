package learn.test_thread;

public class RunableImpl implements Runnable {
	@Override
	public void run() {//实现接头的方法
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "-->" + i);
		}
	}
}
