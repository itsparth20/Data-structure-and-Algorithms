--PostgreSQL 9.6
--'\\' is a delimiter


DROP TABLE IF EXISTS department1;
DROP TABLE IF EXISTS employee1;

create table department1(dept_id integer not null,
                        dept_name varchar(30) not null, 
                        dept_location varchar(30) not null
                       );

create table employee1(emp_id integer not null,
                     emp_name varchar(50) not null,
                     dept_id integer not null,
                     salary integer not null
                     );

insert into department1 values(10, 'Accounts', 'Delhi');
insert into department1 values(20, 'Marketing', 'Delhi');
insert into department1 values(40, 'IT', 'Warsaw');
insert into department1 values(30, 'Production', 'Hyderabad');
insert into department1 values(50, 'Sales', 'Bengaluru');

insert into employee1 values(1, 'Jojo', 20, 5000);
insert into employee1 values(2, 'Popat Lal', 30, 15000);
insert into employee1 values(3, 'Santa Singh', 40, 25000);
insert into employee1 values(4, 'Banta Singh', 20, 7500);
insert into employee1 values(5, 'Sohan Lal', 20, 15000);
insert into employee1 values(6, 'KK', 10, 1200);
insert into employee1 values(7, 'Bob', 20, 35000);
insert into employee1 values(8, 'John', 30, 25000);
insert into employee1 values(9, 'Smith', 40, 5000);

select * from department1;
select * from employee1;

SELECT 

    department1.dept_id,

    COUNT(employee1.dept_id), 

    SUM(employee1.salary) 

FROM employee1 LEFT JOIN department1

    ON employee1.dept_id=department1.dept_id

GROUP BY department1.dept_id

ORDER BY department1.dept_id;
