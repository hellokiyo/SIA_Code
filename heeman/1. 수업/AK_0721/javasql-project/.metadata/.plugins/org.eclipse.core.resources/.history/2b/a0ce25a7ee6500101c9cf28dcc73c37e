public class DeptSalaryMinMaxStat {
    public int id;
    public String name;
    public int maxSalary;
    public String maxEmpName;
    public int minSalary;
    public String minEmpName;

    @Override
    public String toString() {
        return "부서ID: " + id + ", 부서명: " + name + ", 최고연봉: " + maxSalary + "(" + maxEmpName + ")" + ", 최저연봉: " + minSalary + "(" + minEmpName + ")";
    }

    public static DeptSalaryMinMaxStat fromResultSet(java.sql.ResultSet rs) throws java.sql.SQLException {
        DeptSalaryMinMaxStat stat = new DeptSalaryMinMaxStat();
        stat.id = rs.getInt("department_id");
        stat.name = rs.getString("department_name");
        stat.maxSalary = rs.getInt("max_salary");
        stat.maxEmpName = rs.getString("max_emp_name");
        stat.minSalary = rs.getInt("min_salary");
        stat.minEmpName = rs.getString("min_emp_name");
        return stat;
    }
} 