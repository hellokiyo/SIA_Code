/*
1. 사번, 성명, 급여, 입사일자, 관리자사번, 관리자명, 입사일자를 출력합니다.
  - 관리자가 존재하지 않는 경우 관리자없음을 출력합니다.

2. 부서번호, 부서명, 부서장사번, 부서장명을 출력합니다.
  - 부서장이 없으면 부서장사번, 부서장명을 부서장없음이라고 출력합니다.
*/
  #2번 
select d.department_id 부서번호, d.department_name 부서명, 
	ifnull(d.manager_id,"부서장없음") 부서장사번,
    ifnull(concat(e.last_name,' ',e.first_name),"부서장없음") 부서장명
	from employees e 	
		inner join departments d on e.department_id = d.department_id 
;
  
  
  
  
  
  
  
  
  
  
  
  
  # 1번
  select e.employee_id 사번 ,concat(e.last_name,' ',e.first_name) 성명, e.salary 급여, 
		m.employee_id 관리자사번, ifnull(concat(m.last_name,' ',m.first_name),'관리자없음')  관리자명,m.hire_date 입사일자
    from employees e 
	left join employees m 
    on e.manager_id = m.employee_id
	
  ;
  
  