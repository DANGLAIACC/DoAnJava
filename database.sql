/*
	use master
	go
	drop database ThiTracNghiem
*/

create database ThiTracNghiem
go
use ThiTracNghiem 
go
create table CauHoi(
	MaCauHoi char(10) primary key,
	NoiDung nvarchar(1000),
)