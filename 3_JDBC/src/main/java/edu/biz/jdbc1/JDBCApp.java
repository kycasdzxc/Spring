package edu.biz.jdbc1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCApp {
	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc1.xml");
//		DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
//		Connection connection = dataSource.getConnection();
		
		JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		
		String result = template.queryForObject("SELECT SYSDATE FROM DUAL", String.class);
//		System.out.println(result);
		
		List<?> list = template.queryForList("SELECT * FROM EMP");
//		list.forEach(System.out::println);
		
		Object obj = template.queryForObject(
				"SELECT EMPNO FROM EMP WHERE ENAME = ? AND EMPNO = ?", new String[]{"SMITH", "7369"}, Object.class);
		System.out.println(obj);
	}
}
