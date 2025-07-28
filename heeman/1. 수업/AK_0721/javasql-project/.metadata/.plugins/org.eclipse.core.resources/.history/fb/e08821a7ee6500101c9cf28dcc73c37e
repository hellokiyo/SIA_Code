public class DeptYearsStat {
    public int id;
    public String name;
    public double avgYears;

    @Override
    public String toString() {
        return "Department ID: " + id + ", Department Name: " + name + ", Average Years: " + String.format("%.2f", avgYears);
    }

    public static DeptYearsStat fromResultSet(java.sql.ResultSet rs) throws java.sql.SQLException {
        DeptYearsStat stat = new DeptYearsStat();
        stat.id = rs.getInt("department_id");
        stat.name = rs.getString("department_name");
        stat.avgYears = rs.getDouble("avg_years");
        return stat;
    }
} 