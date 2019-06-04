package learn.test_thread;

public class Main {
	
	public static void mainFun() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "-->" + i);
			
			//���������쳣
//			int j = 0 / 0;
//			System.out.println(j);
		}
	}

	public static void main(String[] args) {
		
		//��һ�ַ�ʽ:ʹ��Thread
		Thread mt = new MyThread();
		mt.start();//�����߳�
		
		//�ڶ��ַ�ʽ:ʹ��Runnable
		Runnable run = new RunableImpl();
		Thread rt = new Thread(run);
		rt.start();//�����߳�
		mainFun();//���߳�
		//ʹ��������
		/*
		   ��ʽ��
		new ����/�ӿ�(){
			@override
			����{}
		}
		 */
		//Thread
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println(Thread.currentThread().getName() + "-->" + i);
				}
			}
			
		}.start();
		
		//Runnable
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println(Thread.currentThread().getName() + "-->" + i);
				}
			}
		}).start();
	}

}
