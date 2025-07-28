
public class DeptSalaryStat {
    public int id;
    public String name;
    public double avgSalary;

    @Override
    public String toString() {
        return "Department ID: " + id + ", Department Name: " + name + ", Average Salary: " + String.format("%.2f", avgSalary);
    }

    public static DeptSalaryStat fromResultSet(java.sql.ResultSet rs) throws java.sql.SQLException {
        DeptSalaryStat stat = new DeptSalaryStat();
        stat.id = rs.getInt("department_id");
        stat.name = rs.getString("department_name");
        stat.avgSalary = rs.getDouble("avg_salary");
        return stat;
    }
} 