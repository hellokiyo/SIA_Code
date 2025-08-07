use mydb;

create schema mydb;
#은행에 지점이 있고, 고객, 계좌가 있습니다.
#table생성, 프라이머리 키, 포린 키지정

#지점에는 고유번호, 명칭, 주소, 전화번호가 관리되어야 합니다.
create table spot (
	spot_id int auto_increment primary key, #고유번호
    spot_name varchar(20), #명칭
    spot_address varchar(50), #주소
    spot_phone_num int #전화번호
);


#고객은 고객번호, 고객명, 고객전화번호, 주민번호, 주소
#- 고객은 주거래지점이 관리되어야 한다.
create table customer (
	customer_id int, #고객번호
    customer_name varchar(50), #고객명
    customer_phone_num int, #고객전화번호
    customer_resident_id int, #주민번호
    customer_address varchar(50), #주소
    main_spot int, #주거래지점
	primary key(customer_id),
    foreign key(main_spot) references spot(spot_id)
);
select * from customer;

#계좌는 계좌번호, 계좌종류, 잔고
#- 계좌는 개설지점이 표시되어야 한다.

create table account(
	account_id int, #계좌번호
    account_type varchar(20), #계좌종류
    money int, #잔고
    maked_spot int, #개설지점
    primary key(account_id),
    foreign key(maked_spot) references spot(spot_id)
);

select * from account;