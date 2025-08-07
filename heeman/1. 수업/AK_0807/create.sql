use newhr;

select * from employees;

# my_order, my_order_item
create table my_order(
	id int auto_increment primary key,
    order_date date
);
drop table my_order;

insert into my_order(order_date) values(curdate());
select * from my_order;

create table my_order_item(
	order_id int,
    item_id varchar(50),
    amount int,
    primary key(order_id, item_id),
    foreign key(order_id) references my_order(id)
);
insert into my_order_item(order_id, item_id, amount) values(1, 'GAL25',100);

select * from my_order_item;





select CONCAT(first_name, last_name) from employees where job_id = "HR_REP";

