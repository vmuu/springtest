-- 登录数据库
mysql -h 127.0.0.1 -P 3306 -u root -p
-- 创建数据库
create database emp character set utf8mb4;
-- 查看数据库
show databases;
-- 选择数据库
use emp;
-- 创建数据表employee
create table employee(id int primary key auto_increment,name varchar(50),age int,position varchar(60));
-- 一次性插入多条数据
insert into employee(name,age,position) values('张三',20,'员工'),('李四',18,'员工'),('王五',35,'经理');