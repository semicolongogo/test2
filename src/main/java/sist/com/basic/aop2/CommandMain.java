package sist.com.basic.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CommandMain {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/basic/aop2/unit.xml");
		Unit unit=(Unit)context.getBean("marine");
		Unit unit2=(Unit)context.getBean("Scv");
		
		unit.doCommand();
		unit2.doCommand();
	}

}

