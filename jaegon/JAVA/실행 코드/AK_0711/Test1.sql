use newhr;

# 한줄 주석
-- 한줄 주석
/*
	여러줄 주석
*/

# 부서번호 100번에 근무하는 직원들의 이름을 출력하시오.
-- 부서번호 100번에 존재하는 직원들 
SELECT first_name last_name, email, salary  
/*
SELECT first_name last_name, email, salary   
first_name 다음에 콤마가 없어도 실행은 된다
하지만 이건 first_name의 컬럼에 last_name이라는 이름을 지정해준것이다. 
해당 값엔 fist_name의 출력이되고 컬럼엔 last_name이 출력된다.
이걸 Alias(표현이름)이라고 한다.
*/
                                               
from employees 
where department_id = 80;
/*
claus (~절)
실행되는 순서
From -> select -> 이후 claus절
*/

select * from employees; 

select department_id
from employees;

select last_name, salary, (salary +200) * 12  급여  #select에 수식을 넣을 수 있다.
from employees;


select last_name, commission_pct
	, salary * (1 + ifnull(commission_pct, 0)) * 12 "커미션반영급여" 
    # 윗줄이 전체가 NULL : 데이터가 없는데 연산이 되서 
    # NULL : 정해지지 않은 값
    
from employees;


# 성이 King인 직원 조회
select * 
from employees
#where last_name = "King";
#where hire_date = '2013-06-17'
#where salary = 8000
#where department_id in (80,100)
#where commission_pct = null -- 커미션을 받지 않는 직원
# where commission_pct is null -- 커미션을 받지 않는 직원
#where last_name like 'K%'
# where employee_id like '%8'
where salary > 10000
	and hire_date >= '2010                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    '

;


select *
from  employees
where job_id = 'IT+PROG'
    or department_id = 100
    or department_id = 80
	and first_name like 'D&'
;


select count(*)
from employees
where 1=1
	and job_id = 'IT_PROG'
	or department_id = 100
    or department_id = 80
    and first_name like 'D%'
order by 3;
;


