package edu.biz.jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Setter @Service
public class EmpDao {
	// CRUD
	@Autowired
	private JdbcTemplate template;
	
	public int register(Emp emp) {
		return template.update("INSERT INTO EMP VALUES "
				+ "(?, ?, ?, ?, SYSDATE, ?, ?, ?)"
				, emp.getEmpno()
				, emp.getEname()
				, emp.getJob()
				, emp.getMgr()
				, emp.getSal()
				, emp.getComm()
				, emp.getDeptno()
				);
	}
	
	public Emp get(int empno) {
//		return template.queryForObject("SELECT * FROM EMP WHERE EMPNO = ?", Emp.class, empno);
		return template.queryForObject("SELECT * FROM EMP WHERE EMPNO = ?", new MyMapper(), empno);
	}
	
	public List<Emp> list() {
		return template.query("SELECT * FROM EMP", new MyMapper());
	}
	
	public int modify(Emp emp) {
		return template.update("UPDATE EMP SET ENAME = ?, SAL = ? WHERE EMPNO = ?",
				emp.getEname(), emp.getSal(), emp.getEmpno());
	}
	
	public int remove(int empno) {
		return template.update("DELETE EMP WHERE EMPNO = ?", empno);
	}
}

class MyMapper implements RowMapper<Emp> {

	@Override
	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		int idx = 1;
		Emp emp = new Emp(rs.getInt(idx++), rs.getString(idx++), rs.getString(idx++), rs.getInt(idx++),
				rs.getString(idx++), rs.getInt(idx++), rs.getInt(idx++), rs.getInt(idx++));
		return emp;
	}
	
}