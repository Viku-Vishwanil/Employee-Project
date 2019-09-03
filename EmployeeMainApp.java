package edu.jspiders.employeeproject.util;

import java.util.Scanner;

import edu.jspiders.employeeproject.dao.EmployeeDAO;

public class EmployeeMainApp 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		EmployeeDAO dao = new EmployeeDAO();
		
		System.out.println("Welcome To Employee Application : ");
		System.out.println("_____________________________");
		
		while(true)
		{
			System.out.println("\t"+"1.Add\n"+"\t"+"2.Display\n"+"\t"+"3.Delete\n"+"\t"+"4.Update\n"+"\t"+"5.Exit\n");
			
			System.out.println("Enter Your Choice :- \n");
			int ch = sc.nextInt();
			
			switch(ch)
			{
					case 1: dao.create();
								 break;
					case 2: dao.readById();
								 break;
					case 3: dao.deleteById();
								 break;
					case 4: dao.updateById();
								break;
					case 5: System.out.println("Thanks For Visiting.........!!!");
								System.exit(0);
	
					default : System.out.println("Invalid choice...........!!!!!!!!!");
			}
		}
	}
}
