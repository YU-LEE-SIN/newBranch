use master
go
if Exists(select * from sysdatabases where name='StoreDB')
	drop database StoreDB
go
create database StoreDB
go 
use StoreDB
go
--drop table [user]
create table [user] --user��
(
	pk_id int primary key identity(1,1),
	name varchar(255) not null,
	[password] varchar(100) not null,
)
select * from [user]
select * from [user] where name='2440761470@qq.com' and [password]='qwer'
go
create table store  --�̳Ǳ�
(
	pk_sid int primary key identity(1,1),
	sname varchar(255) not null,
)
go
create table category  --��Ʒ�����
(
	pk_cid int primary key identity(1,1),
	[sid] int foreign key references store(pk_sid),  --����̳�
	cname varchar(255) not null,
)
go
create table product --��Ʒ��
(
	pk_pid int primary key identity(1,1),
	pname varchar(255) not null, 
	original_price decimal(10,2) not null, --��ʾ�۸�
	images varchar(255),
	about varchar(255), --��Ʒ���
	create_time date default(getdate( ))not null,
	remark varchar(255),
)
go
create table category_association  --��Ʒ���������
(
	pk_aid int primary key identity(1,1),
	cid int foreign key references category(pk_cid) not null,  -- ����id
	pid int foreign key references product(pk_pid) not null,  -- ��Ʒid
) 

go
create table product_image --��ƷͼƬ��
(
	pk_id int primary key identity(1,1),
	pid int foreign key references product(pk_pid) not null,  --��Ʒid --Ӧ���������id
	image_src varchar(255) default null,  --չʾͼƬ
)
go
--���ۣ���棬�����������������
create table property --��Ʒ���Ա�
(
	pk_id int primary key identity(1,1) not null,
	pid int foreign key references product(pk_pid) not null,  --��Ʒid
	all_stock int NOT NULL, --�ܿ��
	sales int,  --����
)
go 
create table specification  --����,����������
(
	pk_id int primary key  identity(1,1) not null,
	cid int foreign key references category(pk_cid),
	spec_name varchar(255) not null, --�������
)
go
create table spec_property  --������Ա�
(
	pk_id int primary key identity(1,1) not null,
	spid int foreign key references specification(pk_id),  --����id
	sp_pr_one_name varchar(255),
	sp_pr_two_name varchar(255),
)
go
create table prt_specification  --��Ʒ���SKU��
(
	pk_id int primary key identity(1,1) not null,
	pid int foreign key references product(pk_pid) not null,  --�����Ʒ��
	prt_sp_one_name varchar(255) default(null),  --���1  ����ɫ\��ɫ....
	prt_sp_two_name varchar(255) default(null),  --���2
	prt_sp_price decimal(10,2) not null, --��Ʒ����
	prt_stock int NOT NULL, --���
	is_prt_state  tinyint default(0), --�Ƿ��ϼ�Ĭ�� 0�����ϼ�
)
go
insert into store values('Ӳ��'),('���')

insert into category values(1,'Surface'),(1,'Xbox')

insert into product(pname,original_price,images,about) values
('ȫ�� Surface Go',2908,'Image\ȫ�� Surface Go.jpg','ȫ�� 10 Ӣ�� Surface Go ������ճ������������£���߱ʼǱ����Ե����ܺ�ƽ����Եı�Я�ԣ�������ɴ� 9 Сʱ1����ӵ�����˾�̾�Ĵ�������'),
('ȫ�� Surface Laptop 2',9728,'Image\ȫ�� Surface Laptop 2.jpg','ȫ�� Surface Laptop 2����ɫ�����Է�ɡ��������ɣ������������ٶȺ����ܣ�����װ����У���ÿһ�춼����Ч����ɫ��ѡ2������ȫ�µ��źںͻҷ۽�'),
('ȫ�� Surface Pro 6',8958,'Image\ȫ�� Surface Pro 6.jpg','�����磬��װ����ȫ�� Surface Pro 6 �����°�� 8 ��Ӣ�ض���������������ٶȱ��������죬�����һ�����Ч��ȫ�µ��źڿɹ�ѡ��'),
('Surface Book 2',12068,'Image\Surface Book 2.jpg','��ѡ�� 8 ��Ӣ�ض�����ĺ˴������� NVIDIA GeForce GTX 1060 ���� GPU����ַ���רҵ������Ĺ��ܡ����� 13.5 Ӣ�缰 15 Ӣ����Ϳ�ѡ��'),
('ȫ�� Surface Studio 2',29108,'Image\ȫ�� Surface Studio 2.jpg','���ʻ��ɫ�ʳ��֡����޵�ͼ����ʾ�͸����ٵĴ�����Ϊ���Ĵ��⸳�ܡ��ɵ��ڵ� 28 Ӣ����ʾ����ֱ�ۻ��Ĺ��ߣ������Ĵ���ԴԴ���ϡ�')
go

insert into product(pname,original_price,images,about) values
('Xbox One X 1TB ����',3898,'Image\Xbox One X 1TB ����.png','Xbox One X 1TB ��4K 60֡������Ϸ�� ֧������ Xbox One ��Ϸ2�����'),
('Xbox One S 1TB ����',2169,'Image\Xbox One S 1TB ����.jpg','Xbox One S 1TB ��4K 60֡������Ϸ��')

insert into product(pname,original_price,images,about) values('Xbox One S 1TB ����',2169,'Image\Xbox One S 1TB ����.jpg','Xbox One S 1TB ��4K 60֡������Ϸ��')select @@IDENTITY
insert into product(pname,original_price,images,about) output inserted.pk_pid values('Xbox One S 1TB ����',2169,'Image\Xbox One S 1TB ����.jpg','Xbox One S 1TB ��4K 60֡������Ϸ��')

select * from product
delete from product where  pk_pid in (9,10,12,13,14,15,16)
-----------------------------------------
insert into category_association values(1,1),(1,2),(1,3),(1,4),(1,5)
insert into category_association values(2,6),(2,7)
go
insert into product_image values
(1,'Image\ȫ�� Surface Go.jpg'),
(2,'Image\ȫ�� Surface Laptop 2.jpg'),
(3,'Image\ȫ�� Surface Pro 6.jpg'),
(4,'Image\Surface Book 2.jpg'),
(5,'Image\ȫ�� Surface Studio 2.jpg')
insert into product_image values
(6,'Image\Xbox One X 1TB ����.png'),
(7,'Image\Xbox One S 1TB ����.png')

insert into specification values(1,'Surface��')
insert into specification values(2,'Xbox��')
go
insert into spec_property values(1,'Surface��ɫ','Surface����')  --Surface�������
insert into spec_property(spid,sp_pr_one_name) values(2,'Xbox����')  --Xbox�������

insert into prt_specification values
(1,null,'΢�� Surface Go Ӣ�ض� 4415Y/4GB/64GB/WiFi',2908,100,1),
(1,null,'΢�� Surface Go Ӣ�ض� 4415Y/8GB/128GB/WiFi',3888,100,1),
(1,null,'΢�� Surface Go Ӣ�ض� 4415Y/8GB/128GB/�� LTE ��ǿ��',12312,100,1)
insert into prt_specification values
(2,'���ź�','΢�� Surface Laptop 2 ��� i5/8GB/256GB/���ź�',9728,100,1),
(2,'���ź�','΢�� Surface Laptop 2 ��� i7/8GB/256GB/���ź�',11986,100,1),
(2,'���ź�','΢�� Surface Laptop 2 ��� i7/16GB/512GB/���ź�',16458,100,1),
(2,'��ƺ�','΢�� Surface Laptop 2 ��� i5/8GB/256GB/��ƺ�',9728,100,1),
(2,'��ƺ�','΢�� Surface Laptop 2 ��� i7/8GB/256GB/��ƺ�',11986,100,1),
(2,'��ƺ�','΢�� Surface Laptop 2 ��� i7/16GB/512GB/��ƺ�',16458,100,1)

delete product where pk_pid=1

insert into prt_specification values
(6,'΢�� Xbox One X ��ͥ������Ϸ��1TB ��ѩ���ر��',null,3898,50,1),
(6,'΢�� Xbox One X ��ͥ������Ϸ��1TB ������ر��',null,3699,50,1),
(6,'΢�� Xbox One X ��ͥ������Ϸ��1TB �����',null,3799,50,1),
(6,'΢�� Xbox One X ��ͥ������Ϸ��1TB�����޾��� 7����װ',null,3799,50,1)
insert into prt_specification values
(7,'΢�� Xbox One S ��ͥ������Ϸ�� 1TB',null,2199,50,1),
(7,'΢�� Xbox One S ��ͥ������Ϸ�� 1TB ˫�ֱ���װ',null,2399,50,1),
(7,'΢�� Xbox One S ��ͥ������Ϸ�� 1TB ����ð����װ',null,2199,50,1),
(7,'΢�� Xbox One S ��ͥ������Ϸ�� 1TB ��ͥ��װ����������+����ˣ�������',null,2199,50,1)
go
select * from store
select * from category
select * from product
select * from category_association
select * from product_image
select * from property
select * from specification
select * from spec_property
select * from prt_specification

select Count(*) from product

select * from(select ROW_NUMBER() over(order by pk_pid) as rowNo, 
* from product where pname like '%ȫ%') 
as p where rowNo between 1 and 5
--��ѯĳ����Ʒ������Ʒ����
select Count(*) from category_association where 1=1 and cid=1

--���������ѯ
go
select c.cname ��������, a.cid ,a.pid, p.pname ,p.about
from category c Inner Join category_association a on c.pk_cid=a.cid
 inner join product p on p.pk_pid=a.pid where 1=1 and cid=1
 go
--���������ѯ
 select * from (select ROW_NUMBER()over(order by pk_pid) as rowNo,
 c.cname ��������,c.pk_cid, a.cid ,a.pid, p.pk_pid, p.pname , p.original_price ,p.images, p.about ,p.create_time ,p.remark
from category c Inner Join category_association a on c.pk_cid=a.cid
 inner join product p on p.pk_pid=a.pid where 1=1 and cid like 1)
as p where rowNo between 1 and 6

--��ѯ����
select Count(*) from  category_association 
inner join product on pk_pid=pid where 1=1 and cid=1

select Count(*) from  category_association p
inner join product a on p.pid=a.pk_pid where 1=1 and p.cid=2


 select * from (select ROW_NUMBER()over(order by pk_pid) as rowNo,
 c.cname ��������,c.pk_cid, a.cid ,a.pid, p.pk_pid, p.pname , p.original_price ,p.images, p.about ,p.create_time ,p.remark
from category c Inner Join category_association a on c.pk_cid=a.cid
 inner join product p on p.pk_pid=a.pid where 1=1 and pk_pid like 5)
as p where rowNo between 1 and 6


select *
from category_association c inner join specification s on  c.cid=s.cid
inner join spec_property sp on sp.pk_id=s.pk_id
inner join prt_specification p on p.pid=c.pid 
where 1=1 and p.pid like 7

select * from category_association
select * from specification
select * from spec_property
select * from prt_specification


select sp.sp_pr_one_name,sp.sp_pr_two_name
from category_association c inner join specification s on  c.cid=s.cid
inner join spec_property sp on sp.pk_id=s.pk_id
where 1=1 and pid like 1

select * from prt_specification where pk_id=17

