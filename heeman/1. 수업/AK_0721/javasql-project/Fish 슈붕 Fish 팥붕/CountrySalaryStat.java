import java.sql.ResultSet;

public class CountrySalaryStat {
    public String name;
    public double avgSalary;
    @Override
    public String toString() {
        return "국가이름 = " + name + ", 평균연봉 = " + avgSalary;
    }

    public static CountrySalaryStat fromResultSet(ResultSet rs) throws java.sql.SQLException {
        CountrySalaryStat stat = new CountrySalaryStat();
        stat.name = rs.getString("country_id");
        stat.avgSalary = rs.getDouble("avg_salary");
        return stat;
    }
} 