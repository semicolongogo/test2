package sist.com.basic.aop1;

public class MyBatisDaoAop implements Dao{

	@Override
	public void selectData(int a) {
		// TODO Auto-generated method stub
		System.out.println("MyBatisDaoAop selectDao int");
	}

	@Override
	public void selectData() {
		// TODO Auto-generated method stub
		System.out.println("MyBatisDaoAop selectDao no int");
	}

	@Override
	public int insertProcess() {
		// TODO Auto-generated method stub
		System.out.println("MyBatisDaoAop insertProcess");
		return 0;
	}

	@Override
	public String updateProcess() {
		// TODO Auto-generated method stub
		System.out.println("MyBatisDaoAop updateProcess");
		return null;
	}
	

}
