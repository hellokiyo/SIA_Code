

use newhr;

# department_id가  널인 경우 => 아직 부서에 배치되지 않은 사원
select *
from employees
where department_id is null;

#Seattle에 근무하는 직원들의 성명, 급여, 입사일자, 부서명을 출력하시오. 
select concat(e.last_name, ' ', e.first_name) 성명, e.salary 급여, e.hire_date, d.department_name
from employees e 
	join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
where l.city = 'Seattle'
;


# 사번, 성명, 급여, 입사일자, 관리자사번, 관리자성명을 출력
select e.employee_id, e.last_name, e.salary, e.hire_date, m.employee_id, m.last_name
from employees e
	join employees m on e.manager_id = m.employee_id
;

#집계함수
select min(salary), max(salary), sum(salary), avg(salary)
from employees;

# Group by
# 같은 가치를 지닌 행동을 그룹화하는 것은 SQL 포럼입니다
# GROUP BY는 COUNT(), MAX ( ), MIN(), SUM(), AVG() 등과 함께 사용됩니다.
#https://velog.io/@dntjd7701/SQL-GROUP-BY
select e.department_id, avg(salary), d.department_name
from employees e 
	join departments d on e.department_id = d.department_id
group by e.department_id, d.department_name
;

# having
# having은 전체 결과, where은 개별 행
# https://velog.io/@ljs7463/SQL-having-%EA%B3%BC-where-%EC%B0%A8%EC%9D%B4

select e.department_id, avg(salary)
from employees e 
# where avg(salary) >= 10000   이거말고 having씀
group by e.department_id
having avg(salary) >= 10000
;


# Neena가 어느부서 부서번호를 출력
select department_id
from employees
where first_name = 'Neena';

# Neena가 근무하는 부서의 부서원 정보를 출력
select *
from employees
where department_id = 90;


# 서브쿼리
#이건 잘못됐다. '='을 in으로 바꿔준다.
select *
from employees 
where department_id = (select department_id
						from employees
						where first_name = 'Neena');
                        
#Steven이 근무하는 부서번호
select *
from employees 
where department_id in (select department_id
						from employees
						where first_name = 'Steven');
                        
# multi-column
# 부서별로 최고급여를 받는 사원을 조회
# '='대신 and이나 in을 넣어줘야함
select department_id, max(salary)
from employees
group by department_id
;

select department_id, last_name, salary
from employees
where (department_id, salary) 
			in (select department_id, max(salary)
				from employees
				group by department_id)
order by department_id;

# 자신의 부서평균 급여보다 많은 급여를 받는 직원을 조회


# 등호안되는데 왜 부등호는 됨?
#1
select last_name, salary, department_id
from employees e
where salary > (select avg(salary) from employees
				where department_id =e.department_id)
;

#2
select department_id, avg(salary) avg_salary
from employees
group by department_id
;


# das = department average salary
#3
select *
from employees e join (select department_id, avg(salary) avg_salary
						from employees
						group by department_id) das 
	on e.department_id = das.department_id
where e.salary > das.avg_salary;


