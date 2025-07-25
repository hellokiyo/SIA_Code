import java.sql.ResultSet;

public class CountryPeopleCountStat {
    public String name;
    public int peopleCount;
    @Override
    public String toString() {
        return "국가이름 = " + name + ", 인원수 = " + peopleCount + "명";
    }

    public static CountryPeopleCountStat fromResultSet(ResultSet rs) throws java.sql.SQLException {
        CountryPeopleCountStat stat = new CountryPeopleCountStat();
        stat.name = rs.getString("country_id");
        stat.peopleCount = rs.getInt("count");
        return stat;
    }
} 