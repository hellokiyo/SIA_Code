/*
사번, 성명, 급여, 입사일자, 이메일주소를 출력하시오.

결과가 존재하지 않을 수도 있습니다!

단,
- 급여가 10000이상이어야 합니다.
- 커미션지급대상이어야 합니다.
- 부서가 80이거나 100이어야 합니다.
- 그리고 관리자가 있어야 합니다.
- 그리고 직무가 'P'로 시작되는 이름이어야 합니다.

입사일자가 빠른 순서로 정렬하시오!

*/
-- describe 뒤집기


select employee_id, first_name, last_name, salary, hire_date, email
from employees
where salary >= 10000 
	and commission_pct is not null
	and (department_id = 80 
	or department_id = 100)
    and manager_id is not null
    and job_id = 'P%'
    order by hire_date ASC
;

