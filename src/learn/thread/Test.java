package learn.thread;

//������
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Runnable run = new RunnableImpl();  //�����̰߳�ȫ
//		Runnable run = new Demo01RunnableImpl(); //ʹ��ͬ�������
//		Runnable run = new Demo02RunnableImpl(); //ʹ��ͬ������
		Runnable run = new Demo03RunnableImpl(); //ʹ�þ�̬ͬ������
		
		Thread td1 = new Thread(run);
		Thread td2 = new Thread(run);
		Thread td3 = new Thread(run);
		
		td1.start();
		td2.start();
		td3.start();
	}
}
