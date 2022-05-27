package edu.biz.jdbc2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc2.xml");
		EmpDao dao = ctx.getBean("empDao", EmpDao.class);
		Emp emp = new Emp(8000, "javaman", "CLECK", 7902, null, 1000, 0, 20);
//		System.out.println(dao.register(emp));
		
//		System.out.println(dao.get(8000));
//		System.out.println(dao.modify(new Emp(8000, "javaboy", null, 0, null, 2000, 0, 0)));
//		System.out.println(dao.get(8000));
		
		System.out.println(dao.get(8000));
		System.out.println(dao.remove(8000));
		System.out.println(dao.remove(8000));
		
		
//		System.out.println(dao.list());
//		dao.list().forEach(System.out::println);
	}
}
