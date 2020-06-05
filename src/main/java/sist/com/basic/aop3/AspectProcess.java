package sist.com.basic.aop3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectProcess {
	/*
	@Before("execution(public * sist.com.basic.aop3.S*.*(..))")
	public void dataAttributeSearch(JoinPoint jPoint) {
		System.out.println("BeforDataProcess");
		Signature sg = jPoint.getSignature();
		System.out.println("Name : "+sg.getName());
		if(sg.getName().equals("fileSearch")) {
			System.out.println("            파일을 찾아보렴");
		} else if(sg.getName().equals("xmlaparsing")) {
			System.out.println("            xml를 parsing 하렴");
		} else if(sg.getName().equals("domSaxPasing")) {
			System.out.println("            domSax를 parsing 하렴");
		} else {
			System.out.println("쉬어라!!");
		}
	}
	@After("execution(public * sist.com.basic.aop3.s*.*(..))")
	public void dataAttributeSearch2(JoinPoint jPoint) {
		System.out.println("AfterDataProcess");
		
	}*/
	@Around("execution(public * sist.com.basic.aop3.Search*.*(..))")
	public void dataAttributeSearch3(ProceedingJoinPoint jp) {
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("자바 공통단");
		
	}
	/*@AfterReturning("execution(public * sist.com.basic.aop3.Search*.*(..))")
	public void data() {
		System.out.println("@AfterReturning");
	}*/
}
