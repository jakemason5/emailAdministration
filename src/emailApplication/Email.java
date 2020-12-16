package emailApplication;

import java.util.Scanner;


public class Email {
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 11;
	private String department;
	private int mailboxCapacity;
	private String alternateEmail;
	private String orgSuffix = "company.com";
	
	//Constructor for first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL ADDRESS CREATED FOR " + this.firstName + " " + this.lastName);
	
		//Call method asking for department 
		this.department = setDepartment();
		System.out.println("Department set to " + this.department);
		
		//Call method for generating random password
		this.password = randPassword(defaultPasswordLength);
		System.out.println("Your password is " + this.password);
		
		//Generate email address
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + orgSuffix;
		System.out.println("Your Email Address is " + this.email);
	}
	
	//Ask for users department
	private String setDepartment() {
		System.out.print("Enter the department code\n1 for Sales\n2 for Administration\n3 for Accounting\n");
		Scanner dep = new Scanner(System.in);
		int choice = dep.nextInt();
		if(choice == 1) {return "Sales";}
		else if(choice == 2) {return "Admin";}
		else if(choice == 3) {return "Acct";}
		else {return "";}
	}
	
	//Generate random password
	private String randPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%^&*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set alternate email address
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public int getMailboxCapacity() { return this.mailboxCapacity; }
	public String getAlternateEmail() {return this.alternateEmail;}
	public String getPassword() {return this.password;}

}
