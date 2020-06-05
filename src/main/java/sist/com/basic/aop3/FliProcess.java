package sist.com.basic.aop3;

import org.springframework.stereotype.Component;

@Component
public class FliProcess {
	public void fileValidate() {
		System.out.println("FliProcess  fileValidate"); 
	}
	public void fileProperties() {
		System.out.println("FliProcess  fileProperties"); 
	}
}
