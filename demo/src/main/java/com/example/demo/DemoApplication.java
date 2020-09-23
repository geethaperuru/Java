package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(DemoApplication.class, args);
		
		//No need of below creation of object as spring has ability to create the object and give it to yoo
		//Employee e = new Employee();
		
		//By the below call all the components are initiated with singleton object inside the container but not the prototype ones
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		//This gets the required object if it is added as the bean component in the spring container
		Employee e = context.getBean(Employee.class);
		
		e.display();
		
		//Independent of how many times the getBean is called only once the object is created as by default the spring creates a singleton object
		Employee e1 = context.getBean(Employee.class);
		
		e1.display();
		
		
		//Object is created each time when the getBean is called or instantiated
		Company c = context.getBean(Company.class);
		
		c.display();
		
		Company c1 = context.getBean(Company.class);
		
		c1.display();
		
		Laptop l1 = context.getBean(Laptop.class);
		
		l1.setLid(1);
		l1.setBrand("Dell");
		
		e1.setAid(1);
		e1.setEname("xyz");
		e1.setLaptop(l1);
		
		e1.show();
		
	}

}
