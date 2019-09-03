package edu.jspiders.employeeproject.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.jspiders.employeeproject.dto.EmployeeDTO;
import edu.jspiders.singletonfactory.classes.SingletonFactory;

public class EmployeeDAO
{
	Scanner sc = new Scanner(System.in);
	
	//Create Operation -------------->>
	public void create()
	{	
		SessionFactory factory = SingletonFactory.getFactory();
		
		Session session = factory.openSession();
		
		session.save(readEmpDetails());
		
		Transaction tx = session.beginTransaction();
		tx.commit();
		System.out.println("Record added Successfully........!!!");
		
		session.close();	
	}
	
	//Read details for Create  -------------->>
	public EmployeeDTO readEmpDetails()
	{
		System.out.println("Enter Employee Id : ");
		int employeeId = sc.nextInt();
		System.out.println("Enter First Name: ");
		String firstName = sc.next();
		System.out.println("Enter Last Name : ");
		String lastName = sc.next();
		System.out.println("Enter Employee Salary : ");
		double salary = sc.nextDouble();
		
		return new EmployeeDTO(employeeId, firstName, lastName, salary);
	}
	
	//Read Operation -------------->>
	public EmployeeDTO readById()
	{
		SessionFactory factory = SingletonFactory.getFactory();
		
		Session session = factory.openSession();
		
		System.out.println("Enter Employee Id to fetch details : ");
		int employeeId = sc.nextInt();
		
			EmployeeDTO dto=session.get(EmployeeDTO.class, employeeId);
			if(dto == null)
			{
				System.out.println("Employee doesn't Exist  !!");
			}
			else
			{
				System.out.println(dto);
			}
		
		session.close();
		
		return dto;	
	}
	// Update Operation--------------->>
	public void updateById()
	{
		SessionFactory factory = SingletonFactory.getFactory();
		
		Session session = factory.openSession();
		
		System.out.println("Enter Employee Id to be Updated : ");
		int employeeId = sc.nextInt();
		
		EmployeeDTO dto=session.get(EmployeeDTO.class, employeeId);
		
		if(dto == null)
			{
				System.out.println("Employee doesn't Exist  !!");
			}
		else
		{
			Transaction transaction = session.beginTransaction();
			
				if(employeeId==dto.getEmployeeId())
				{
					System.out.println("What do you want to update : ");
					
					
								System.out.println("1.First Name\n2.Last Name\n3.Salary\n4.Exit");
								
								System.out.println("Enter Your Choice");
								int ch = sc.nextInt();
								
								switch(ch)
								{
										case 1: dto.setFirstName(updateFirstName());
													System.out.println("First Name Updated");
													break;
													
													
										case 2: dto.setLastName(updateLastName());
													System.out.println("Last Name Updated");
													break;
													
										case 3: dto.setSalary(updateSalary());
													System.out.println("Salary Updated");
													break;
													
										case 4: System.exit(0);
										
										default : System.out.println("Invalid option");				
							}
								session.update(dto);	
								
								transaction.commit();
							
					}
			}
	}
	
	public String updateFirstName()
	{
		System.out.println("Enter new First Name : ");
		String firstname = sc.next();
		
		return firstname;
	}
	public String updateLastName()
	{
		System.out.println("Enter new Last Name : ");
		String lastname = sc.next();
		return lastname;
	}
	public double updateSalary()
	{
		 System.out.println("Enter new Salary : ");
			double salary = sc.nextDouble();

			return salary;
	}
	
	//Delete Operation ---------->>
	public void deleteById()
	{	
			SessionFactory factory = SingletonFactory.getFactory();
		
			Session session = factory.openSession();
		
			System.out.println("Enter Employee Id to delete : ");
			int employeeId = sc.nextInt();
			
			EmployeeDTO dto=session.get(EmployeeDTO.class, employeeId);
			
			if(dto == null)
			{
				System.out.println("Employee with id"+employeeId+" doesn't Exist  !!");
			}
			else
			{
				if(employeeId ==dto.getEmployeeId())
				{
					session.delete(dto);
					System.out.println("Record Deleted Successfully");
				}
			}
			Transaction transaction=session.beginTransaction();
			transaction.commit();
	}

}
