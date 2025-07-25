
import java.sql.ResultSet;
import java.sql.SQLException;

public class Emp {
	
	public int id;
	public String name;
	public String email;
	public String phone;
	public String hireDate;
	public int salary;
	public String deptName;
	public double commissionPct;
	public int years;
	
	@Override
	public String toString() {
		return "Emp [사번: " + id + ", 이름: " + name + ", 이메일: " + email + ", 전화번호: "
				+ phone + ", 입사일: " + hireDate + ", 연봉: " + salary + ", 부서명: " + deptName + "]";
	}

    public static Emp fromResultSet(ResultSet rs) throws SQLException {
        Emp emp = new Emp();
        emp.id = rs.getInt(1);
        emp.name = rs.getString(2);
        emp.email = rs.getString(3);
        emp.phone = rs.getString(4);
        emp.hireDate = rs.getString(5);
        emp.salary = rs.getInt(6);
        emp.deptName = rs.getString(7);
        emp.commissionPct = rs.getDouble(8); // 추가
        return emp;
    }
    // 근속연수 Top 5 직원 랭킹 조회 시 사용(years 변수 포함됨됨)
    public static Emp fromResultSet(ResultSet rs, boolean Years) throws SQLException {
        Emp emp = fromResultSet(rs);
        if (Years) {
            emp.years = rs.getInt(9);
        }
        return emp;
    }
}
