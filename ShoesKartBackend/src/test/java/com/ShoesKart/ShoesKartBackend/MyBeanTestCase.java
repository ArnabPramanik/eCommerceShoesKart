package com.ShoesKart.ShoesKartBackend;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ShoesKart.ShoesKartBackend.MyBean;

public class MyBeanTestCase 
{
	public static void main(String arg[])
	{
		System.out.println("---Test Case - AnnotationConfigApplication Context Object Created---");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.Arnab.Backend");
		
		context.refresh();
		
		System.out.println("---My Bean Created---");
		
		MyBean myBean=(MyBean)context.getBean("myBean");
		
		myBean.display();
		
	}
}












