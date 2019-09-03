package edu.jspiders.employeeproject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="employee_details")
@Entity
public class EmployeeDTO
{
	@Id
	@Column(name ="emp_id")
	private int employeeId;
	@Column(name ="emp_first_name")
	private String firstName;
	@Column(name ="emp_last_name")
	private String lastName;
	@Column(name ="emp_salary")
	private double salary;
	
	public EmployeeDTO()
	{
		
	}
	public EmployeeDTO(int employeeId, String firstName, String lastName, double salary) 
	{
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + "]";
	}
	
}
