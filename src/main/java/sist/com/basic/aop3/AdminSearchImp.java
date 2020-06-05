package sist.com.basic.aop3;
import javax.inject.Inject;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
@Component(value="search")
public class AdminSearchImp implements Search{
	@Inject
	private FliProcess file;
	
	@Override
	public void fileSearch() {
		// TODO Auto-generated method stub
		file.fileValidate();
		System.out.println("fileSearch");
		file.fileProperties();
	}

	@Override
	public void xmlaparsing() {
		// TODO Auto-generated method stub
		file.fileValidate();
		System.out.println("xmlaparsing");
	}

	@Override
	public void domSaxPasing() {
		// TODO Auto-generated method stub
		System.out.println("domSaxPasing");
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}
	 

}
