use newhr;
/*
1. 20번 부서의 이름과 그 부서에 근무하는 사원의 이름을 출력하시오. 단, 급여로 오름차순 정렬하시오.

2. 1400,1500 번 위치의 도시 이름과 그곳에 있는 부서의 이름을 출력하시오.

3. IT_PROG가 직무인 직원들의 다음 정보를 출력.
   - 입사일자를 일/월/년으로 출력
   - 부서명, 도시명도 출력합니다.
*/

# 문제 1
select d.department_name 부서이름, e.last_name 사원이름
from employees e join departments d
using(department_id)
where e.department_id =20
order by e.salary ASC
;

# 문제 2
select l.city 도시이름, d.department_name 부서이름
from locations l join departments d
on l.location_id = d.location_id
where (l.location_id =1400 
	or l.location_id =1500)
;

#문제 3
select date_format(hire_date,("%d-%m-%Y")) 입사일자 , department_name 부서명, city 도시명
from employees e join departments d
on e.department_id = d.department_id
	join locations l
on d.location_id = l.location_id
where e.job_id = 'IT_PROG'
;