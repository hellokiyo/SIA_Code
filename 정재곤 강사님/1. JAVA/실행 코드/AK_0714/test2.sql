use newhr; # newhr의 스키마 사용  -- 스키마 : 테이블을 모아둔 것

select concat('haha','good!'); # concat 함수 : 두개의 데이터 이어붙이기
select concat(first_name,' ', last_name) from employees; #두개의 컬럼의 데이터를 이어붙이기
select substr(first_name, 3) 
		,substr(first_name, 3, 5)
        ,first_name
from employees;
select round(123.456) -- 123
		,round(123.456, 2)
		,round(123.456, -2)
		,truncate(123.456, -2);
        
	
#1380
select salary, round(salary*1380, -4)
from employees;

select now(), sysdate(), curdate(),curtime()
;

select adddate(curdate(),interval 100 day) # 오늘날짜(curdate())로 부터 100일 후(interval 100 day)
	, adddate(curdate(), interval 6 month) # 오늘날짜로부터 6달후
    , year(curdate())
;

# 입사 후 20주년일자
select last_name, hire_date, adddate(hire_date, interval 20 year) 입사후20주년일자
from employees
;

# 근속년수 
select round(datediff(curdate(), hire_date)/ 365.5, 1) 
	 , timestampdiff(year, hire_date, curdate()) 근속년수
from employees
;


# 입사년월일
select last_name, hire_date
	,date_format(hire_date, '%Y-%m-%D') 입사연월일
from employees;


select last_name, job_id,
	case job_id when 'IT_PROG' then salary * 2
		when 'ST_CLERK' then salary * 15
        else salary
	end bonus
from employees
;


# 부서번호가 10이면 급여의 1.2배, 20이면 급여의 2배, 나머지는 급여 그대로
select last_name, department_id, salary,
	case department_id when 10 then salary *1.2
		when 20 then salary * 2
        else salary
    end bonus
from employees
;

# 성, 명, 급여, 근무부서명

# employee id가 100인 항목 출력
select * from employees, departments
where employees.employee_id =100;
;

# 테이블명 간소화 및 각각의 ID가 같은 항목 출력
select e.last_name, d.department_name
from employees e, departments d
where e.employee_id =d.department_id
;

select * from employees;


# 부서번호 90번에 해당하는 부서정보를 조회
select *
from departments
where department_id = 90
;


# 
select * 
from employees e join departments d
	on e.employee_id =d.department_id # on : ansi join라고 부름
;


#where 는 조건문 그자리에서 두번 출력
# on 는 ansi join 그자리에서 두번 출력
# using > 조건을 맨앞으로 빼서 한번만 출력

# where = on = using  다 같지만 취향차이
# join 조건은 테이블갯수-1개 
select * 
from employees e join departments d
	using(department_id)
;

select e.last_name, d.department_name
from employees e left join departments d on e.department_id = d.department_id;

select count(*) -- 106
from employees e left join departments d on e.department_id = d.department_id;
-- left join => outer koin

select count(*) -- 107
from employees e ;


#department_id가 널인경우 => 아직 부서에 배치되지 않은 사원
select *
from  employees
where department_id is null;
;