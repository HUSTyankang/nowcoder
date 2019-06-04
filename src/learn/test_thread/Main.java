package learn.test_thread;

public class Main {
	
	public static void mainFun() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "-->" + i);
			
			//故意引入异常
//			int j = 0 / 0;
//			System.out.println(j);
		}
	}

	public static void main(String[] args) {
		
		//第一种方式:使用Thread
		Thread mt = new MyThread();
		mt.start();//开启线程
		
		//第二种方式:使用Runnable
		Runnable run = new RunableImpl();
		Thread rt = new Thread(run);
		rt.start();//开启线程
		mainFun();//主线程
		//使用匿名类
		/*
		   格式：
		new 父类/接口(){
			@override
			方法{}
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
