package learn.thread;

//ʹ��ͬ�������

public class Demo01RunnableImpl implements Runnable {
	
	private int ticket = 100; //������Դ
	
	Object obj = new Object(); //������,�����߳�Ҫʹ��ͬһ��������
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
					System.out.println(Thread.currentThread().getName() + "�������ڣ�" + ticket + "��Ʊ");
					ticket--;
				}
			}
		}
	}
}