package team3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import pj1.Emp;

public class Job {

    // 직무 ID를 입력받아 해당 직원 목록을 조회하는 메서드
    public static void searchByJobId() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("직무 ID를 입력하세요 (예: IT_PROG, 종료: 0): ");
            String jobId = scanner.nextLine();

            if (jobId.equals("0")) {
                System.out.println("직무 검색을 종료합니다.");
                break;
            }

            try {
                List<Emp> empList = getEmployeesByJobId(jobId);
                if (empList.isEmpty()) {
                    System.out.println("해당 직무 ID에 해당하는 직원이 없습니다.");
                } else {
                    for (Emp emp : empList) {
                        System.out.println(emp);
                    }
                }
            } catch (Exception e) {
                System.err.println("직무 검색 중 오류 발생: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // DB에서 job_id로 직원 리스트를 가져오는 메서드
    private static List<Emp> getEmployeesByJobId(String jobId) throws Exception {
        List<Emp> result = new ArrayList<>();
        
        // department_name 컬럼을 가져오기 위해 쿼리 수정
        String sql = "SELECT CONCAT(e.first_name, ' ', e.last_name) AS full_name, " +
                "e.salary, e.hire_date, d.department_name " + // d.department_name으로 변경
                "FROM employees e " + 
                "JOIN departments d ON e.department_id = d.department_id " + 
                "WHERE e.job_id = ?"; 

        // JDBC 연결 및 자원 관리를 위한 try-with-resources 사용
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, jobId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Emp emp = new Emp();
                    emp.fullName = rs.getString("full_name");
                    emp.salary = rs.getInt("salary");
                    emp.hireDate = rs.getDate("hire_date");
                    emp.deptName = rs.getString("department_name"); // 부서번호 => 부서명 수정
                    result.add(emp);
                }
            }
        }

        return result;
    }
}
