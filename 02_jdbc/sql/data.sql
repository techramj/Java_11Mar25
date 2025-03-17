
--mysql
create table emp_11mar
(id integer primary key,
name varchar(20),
salary double
);

--oracle
create table emp_11mar
(id number(5) primary key,
 name varchar2(20),
 salary number
 );
 
 
create procedure add_num(a in number, b in number, c out number)
is
begin
  c := a + b;
end;
/






