package projPure;

public class Main {

	public static void main(String[] args) {

        int scanResult = -1;
		
		while(scanResult != 0) {
			System.out.println();
            System.out.print("1번: 직원이름으로 직원정보 검색하기\n2번: 입사년도로 직원정보 검색하기\n3번: 부서번호로 직원정보 검색하기\n4번: 직무로 직원정보 검색하기\n5번: 도시이름으로 직원정보 검색하기"
            		+ "\n6번: 통계자료 출력하기\n7번: 부서장 성으로 부서원 검색하기\n8번: 나라이름으로 해당 나라 근무직원 조회하기\n0번: 프로그램을 종료합니다\n숫자를 입력해주세요:  ");
            String scanResultStr= "";


            // 숫자가 들어올 때까지 반복
            while (true) {
                
            	scanResultStr = EmpDAO.setScanResultAsString();

                try {
                    scanResult = Integer.parseInt(scanResultStr);
                    break; // 숫자로 변환되었으면 반복 종료
                } catch (NumberFormatException e) {
                    System.out.print("\n⚠️ 숫자만 입력해주세요.\n 다시 입력: ");
                }
            }
			
			scanResult = Integer.parseInt(scanResultStr);
			
			if(scanResult == 1) {
				try {
					EmpDAO.getEmpListByFirstName();
				} catch(Exception e) {
					System.out.println("올바르지 않은 값을 입력했습니다. 처음으로 돌아갑니다.");
				} 
			} else if(scanResult == 2) {
				try {
					EmpDAO.getEmpListByHireYear();
				} catch(Exception e) {
					System.out.println("올바르지 않은 값을 입력했습니다. 처음으로 돌아갑니다.");
				} 
			} else if(scanResult == 3) {
				try {
					EmpDAO.getEmpListByDepartmentId();
				} catch(Exception e) {
					System.out.println("올바르지 않은 값을 입력했습니다. 처음으로 돌아갑니다.");
				} 
			} else if(scanResult == 4) {
				try {
					EmpDAO.getEmpListByJobId();
				} catch(Exception e) {
					System.out.println("올바르지 않은 값을 입력했습니다. 처음으로 돌아갑니다.");
				} 
			} else if(scanResult == 5) {
				try {
					EmpDAO.getEmpListByCityName();
				} catch(Exception e) {
					System.out.println("올바르지 않은 값을 입력했습니다. 처음으로 돌아갑니다.");
				} 
			} else if(scanResult == 6) {
				try {
					EmpDAO.getYOEStatByDept();
				} catch(Exception e) {
				}				
			} else if(scanResult == 7) {
				try {
					EmpDAO.getEmpListByDepManagerLastName();
				} catch(Exception e) {
					System.out.println("올바르지 않은 값을 입력했습니다. 처음으로 돌아갑니다.");		
				} 
			} else if(scanResult == 8) {
				try {
					EmpDAO.getEmpListByCountryName();
				} catch(Exception e) {
					System.out.println("올바르지 않은 값을 입력했습니다. 처음으로 돌아갑니다.");
				} 
			} else if(scanResult == 0) {
				try {
					System.out.println("--------------------프로그램을 종료합니다");
					EmpDAO.closeScanner();
				} catch(Exception e) {
				}
			} else {
				System.out.println("0부터 8사이의 숫자를 입력해주세요.");
			}
		}
	}
	}


