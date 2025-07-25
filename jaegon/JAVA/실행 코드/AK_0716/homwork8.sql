/*
근속년수에 따른 인원수를 출력합니다.
10년이하 C그룹, 15년이하 B그룹, 20년이하 A그룹, 20년 초과  S그룹 인원수를 출력합니다.
*/

select case 
	when (timestampdiff(year, hire_date, curdate())) <=10 then 'C'
    when (timestampdiff(year, hire_date, curdate())) <=15 then 'B'
    when (timestampdiff(year, hire_date, curdate())) <=20 then 'A'
	else 'S' 
    end 인원수, count(*) cnt
from employees
group by 인원수
;
