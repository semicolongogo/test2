package sist.com.basic.aop3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SearchMain {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/basic/aop3/search.xml");
		Search search = (Search)context.getBean("actionDataProcess");
		//search.fileSearch();
		//search.domSaxPasing();
		//search.process();
		//search.hashCode();
		//((ActionDataProcess)context.getBean("actionDataProcess")).process();
		search.xmlaparsing();
	}
}

