
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
 
 
insert into emp_11mar(id,name,salary) values (1,'Jack',5000);

"insert into emp_11mar(id,name,salary) values ("  + id +",'" + name + "'," salary ")";
Statement st = con.createStatement();
st.exeucteUpdate(sql);



"insert into emp_11mar(id,name,salary) values (?,?,?)"
PreapredSatement ps = con.prepareCall(sql);
ps.setInt(1,id);
...
ps.executeUpdate();

