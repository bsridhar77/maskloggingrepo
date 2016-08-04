package com.demo.services.employee.model;

public class Department {

	String deptno;
	String deptName;
	
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptName=" + deptName + "]";
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
