package springdemo.studentManagement.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Encapsulation

@Component
@Scope("prototype")
public class StudentRecord {

	private int rollNo;
	private String name;
	private long contactNo;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	
	@Override
	public String toString() {
		return "StudentRecord [rollNo=" + rollNo + ", name=" + name + ", contactNo=" + contactNo + "]";
	}
	
}
