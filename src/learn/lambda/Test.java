package learn.lambda;

public class Test {
	
	public static void invokeTestImpl(TestImpl impl) {
		impl.test();
	}
	
	public static int invokeImplDemo01(ImplDemo01 impl) {
		return impl.test();
	}
	
	public static String invokeImplDemo02(String str,ImplDemo02 impl) {
		return impl.test(str);
	}
	
	public static int invokeImplDemo03(int a,int b,ImplDemo03 impl) {
		return impl.test(a,b);
	}
	
	public static void main(String[] args) {
		
		//�޲��޷���ֵ
		invokeTestImpl(()->System.out.println("OK!"));
		
		//�з���ֵ
		int in = invokeImplDemo01(()->1);
		System.out.println(in);
		
		//�в��з���ֵ
		String s1 = "ok!";
		String str1 = invokeImplDemo02(s1,(t)->t);
		System.out.println(str1);
		
		String s2 = "OK!";
		String str2 = invokeImplDemo02(s2,t->t); //һ������ʱ���Բ���()
		System.out.println(str2);
		
		int a = 1, b = 2;
		int c = invokeImplDemo03(a,b,(t,x)->t + x);
		System.out.println(c);
		
	}

}
