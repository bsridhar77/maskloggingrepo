package com.demo.services.employee.model;

import java.util.List;

public class Employee {



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", desc=" + desc + ", address=" + address + ", dept=" + dept
				+ "]";
	}
	public Employee(){
		
	}
	private String employeeId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String memberId) {
		this.employeeId = memberId;
	}
	
	public Employee(String employeeId, String desc) {
		super();
		this.employeeId = employeeId;
		this.desc = desc;
	}

	private String desc;

	public String getDesc() {
		return desc;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	List<Address> address;
	
	Department dept;

	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}
	
	