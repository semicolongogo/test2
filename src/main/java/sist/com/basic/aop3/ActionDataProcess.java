package sist.com.basic.aop3;

import org.springframework.stereotype.Component;

@Component
public class ActionDataProcess implements Search{
	
	@Override
	public void fileSearch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xmlaparsing() {
		// TODO Auto-generated method stub
		System.out.println("<<ActionDataProcess xmlaparsing>>");
	}

	@Override
	public void domSaxPasing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("테스트 프로세스");
	}
	

	
}
