package sist.com.basic.aop2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class Medic implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		Marine marine =(Marine)args[0];
		Scv scv = (Scv)args[1];
		if(marine.getCommand() instanceof CommandAttack) {
			System.out.println("치료중 ... MapBeforeProcess");
		} else if(scv.getCommand() instanceof CommandAttack) {
			System.out.println("치료중 ...");
		}
	}

}
