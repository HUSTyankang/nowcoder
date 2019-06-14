package learn.thread;

//测试类
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Runnable run = new RunnableImpl();  //出现线程安全
//		Runnable run = new Demo01RunnableImpl(); //使用同步代码块
//		Runnable run = new Demo02RunnableImpl(); //使用同步方法
		Runnable run = new Demo03RunnableImpl(); //使用静态同步方法
		
		Thread td1 = new Thread(run);
		Thread td2 = new Thread(run);
		Thread td3 = new Thread(run);
		
		td1.start();
		td2.start();
		td3.start();
	}
}
