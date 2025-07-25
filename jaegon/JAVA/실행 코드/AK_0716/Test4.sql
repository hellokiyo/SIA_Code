use newhr;
select * from newhr.employees;


select* 
from employees
order by salary desc
limit 3
;

select last_name, salary
	, rank() over(order by salary desc) sal_rank
from employees
;

#5000이하는 C, 10000이하는 B, 15000이하는 A, 그 이상은 S
select last_name, salary
	,case when salary <= 5000 then 'C'
		when salary <= 10000 then 'B'
        when salary <= 15000 then 'C'
        else 'S'
    end sal_grade
from employees
;





select case when salary <= 5000 then 'C'
		when salary <= 10000 then 'B'
        when salary <= 15000 then 'C'
        else 'S'
    end sal_grade, count(*) cnt
from employees
group by(case when salary <= 5000 then 'C'
		when salary <= 10000 then 'B'
        when salary <= 15000 then 'C'
        else 'S'
    end)
order by (case sal_grade when 'S' then 1
			when 'A' then 2
            when 'B' then 2
            else 4
		end) 
;
# 부서번호 부서원 조회
select * from employees where salary >15000;

select * from employees where department_id =100;

select * from employees where year(hire_date) =2012;

select job_id employees;