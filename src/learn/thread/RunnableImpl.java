package learn.thread;
//�����̰߳�ȫ

//���̹߳��ù�����Դʱ�Ϳ��ܳ����̰߳�ȫ����

//���ܳ��ֲ����ڵ�Ʊ���ظ���Ʊ


public class RunnableImpl implements Runnable {
	
	private int ticket = 100; //������Դ
	
	@Override
	public void run() { //��дrun����
		// TODO Auto-generated method stub
		while (true) { 
			if (ticket > 0) { //�ж��Ƿ���Ʊ
				try {
					Thread.sleep(10); //�߳�˯��10ms,���ӳ����̰߳�ȫ�Ŀ�����
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
