package org.spring.interfaces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInterface {
	private Drawer drawer;

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("springInterfaces.xml");
		context.getBean(TestInterface.class).workflow();
	}
	
	public void workflow() {
		drawer.draw();
	}
	
	public Drawer getDrawer() {
		return drawer;
	}

	public void setDrawer(Drawer drawer) {
		this.drawer = drawer;
	}

}
