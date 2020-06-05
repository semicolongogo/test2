package sist.com.basic.aop1;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeAdvice {//Advice[What, When] around, before, after, after returning
	public void timeCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		joinPoint.proceed();//핵심코드 호출 MyBatisDaoAop의 코드를 부르는거 위에 있는지 아래에 있는지에 따라 우선순위가 부여 됨
		long start=System.currentTimeMillis();
		//핵심코드 call
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		for (int i = 0; i < (int)(Math.random()*100000000); i++) {
		}
		
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "밀리초 소요");
		System.out.println(((int)(Math.random()*100)%90)+"초 소요");
	}
}
