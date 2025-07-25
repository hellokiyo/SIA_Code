/*
2000년1월1일 이후 입사자입니다. //완

- 연봉은 커미션을 반영한 급여의 12배입니다. //완
- 연봉은 원화로 표시합니다.(환율 : 1389)//완
- 연봉은 천원 단위로 반올림합니다.//완
- 연봉은 천원 단위로 콤마를 부여합니다. //완
- 근속년수는 소수2째자리까지 표시합니다. //완
- 성-명은 성과 명을 합하여 출력합니다. 각 첫글자를 대문자로 합니다. //완
*/

select concat(last_name,first_name) 성명
	,round(datediff(curdate(), hire_date)/ 365.5, 2) 근속년수 
	,format((round(salary,-3) * (1 + ifnull(commission_pct, 0)) * 12)*1389,0) 연봉
from employees
where 1 =1
	and hire_date >= '2000-01-01'
;