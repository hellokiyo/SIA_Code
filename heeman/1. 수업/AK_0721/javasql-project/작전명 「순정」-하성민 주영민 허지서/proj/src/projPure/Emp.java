package projPure;

public class Emp {
	
	int employeeId;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	String hireDate;
	String jobId;
	double salary;
	double commissionPct;
	int managerId;
	int departmentId;
	
	@Override
	public String toString() {
		return "- 아이디 : " + employeeId + " | 성 : " + lastName + " | 이름 : " + firstName + " | email : " + email + " "
				+ "| 전화번호 : " + phoneNumber + " | 입사일 : " + hireDate + " | 직무아이디 : " + jobId + " | 급여 : " + salary;
		}
	
}
