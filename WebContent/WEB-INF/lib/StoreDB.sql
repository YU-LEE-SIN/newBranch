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
create table [user] --user表
(
	pk_id int primary key identity(1,1),
	name varchar(255) not null,
	[password] varchar(100) not null,
)
select * from [user]
select * from [user] where name='2440761470@qq.com' and [password]='qwer'
go
create table store  --商城表
(
	pk_sid int primary key identity(1,1),
	sname varchar(255) not null,
)
go
create table category  --物品分类表
(
	pk_cid int primary key identity(1,1),
	[sid] int foreign key references store(pk_sid),  --外键商城
	cname varchar(255) not null,
)
go
create table product --商品表
(
	pk_pid int primary key identity(1,1),
	pname varchar(255) not null, 
	original_price decimal(10,2) not null, --显示价格
	images varchar(255),
	about varchar(255), --商品简介
	create_time date default(getdate( ))not null,
	remark varchar(255),
)
go
create table category_association  --商品分类关联表
(
	pk_aid int primary key identity(1,1),
	cid int foreign key references category(pk_cid) not null,  -- 分类id
	pid int foreign key references product(pk_pid) not null,  -- 商品id
) 

go
create table product_image --商品图片表
(
	pk_id int primary key identity(1,1),
	pid int foreign key references product(pk_pid) not null,  --商品id --应该外键属性id
	image_src varchar(255) default null,  --展示图片
)
go
--评论，库存，销量，浏览量，评论
create table property --商品属性表
(
	pk_id int primary key identity(1,1) not null,
	pid int foreign key references product(pk_pid) not null,  --商品id
	all_stock int NOT NULL, --总库存
	sales int,  --销量
)
go 
create table specification  --规格表,用来关联类
(
	pk_id int primary key  identity(1,1) not null,
	cid int foreign key references category(pk_cid),
	spec_name varchar(255) not null, --规格名称
)
go
create table spec_property  --规格属性表
(
	pk_id int primary key identity(1,1) not null,
	spid int foreign key references specification(pk_id),  --规格表id
	sp_pr_one_name varchar(255),
	sp_pr_two_name varchar(255),
)
go
create table prt_specification  --商品规格SKU表
(
	pk_id int primary key identity(1,1) not null,
	pid int foreign key references product(pk_pid) not null,  --外键商品表
	prt_sp_one_name varchar(255) default(null),  --规格1  ，白色\黑色....
	prt_sp_two_name varchar(255) default(null),  --规格2
	prt_sp_price decimal(10,2) not null, --商品规格价
	prt_stock int NOT NULL, --库存
	is_prt_state  tinyint default(0), --是否上架默认 0，不上架
)
go
insert into store values('硬件'),('软件')

insert into category values(1,'Surface'),(1,'Xbox')

insert into product(pname,original_price,images,about) values
('全新 Surface Go',2908,'Image\全新 Surface Go.jpg','全新 10 英寸 Surface Go 是完成日常任务的理想伴侣，兼具笔记本电脑的性能和平板电脑的便携性，续航最长可达 9 小时1，且拥有令人惊叹的触摸屏。'),
('全新 Surface Laptop 2',9728,'Image\全新 Surface Laptop 2.jpg','全新 Surface Laptop 2，用色彩彰显风采。美观轻巧，更具提升的速度和性能，轻松装入包中，让每一天都更高效。五色可选2，包括全新典雅黑和灰粉金。'),
('全新 Surface Pro 6',8958,'Image\全新 Surface Pro 6.jpg','无需插电，轻装上阵。全新 Surface Pro 6 搭载新版第 8 代英特尔酷睿处理器，运行速度比以往更快，让你的一天更高效。全新典雅黑可供选择。'),
('Surface Book 2',12068,'Image\Surface Book 2.jpg','可选第 8 代英特尔酷睿四核处理器及 NVIDIA GeForce GTX 1060 独立 GPU，充分发挥专业级软件的功能。现有 13.5 英寸及 15 英寸机型可选。'),
('全新 Surface Studio 2',29108,'Image\全新 Surface Studio 2.jpg','让鲜活的色彩呈现、惊艳的图形显示和更快速的处理器为您的创意赋能。可调节的 28 英寸显示屏和直观化的工具，让您的创意源源不断。')
go

insert into product(pname,original_price,images,about) values
('Xbox One X 1TB 主机',3898,'Image\Xbox One X 1TB 主机.png','Xbox One X 1TB 真4K 60帧高清游戏机 支持所有 Xbox One 游戏2及配件'),
('Xbox One S 1TB 主机',2169,'Image\Xbox One S 1TB 主机.jpg','Xbox One S 1TB 真4K 60帧高清游戏机')

insert into product(pname,original_price,images,about) values('Xbox One S 1TB 主机',2169,'Image\Xbox One S 1TB 主机.jpg','Xbox One S 1TB 真4K 60帧高清游戏机')select @@IDENTITY
insert into product(pname,original_price,images,about) output inserted.pk_pid values('Xbox One S 1TB 主机',2169,'Image\Xbox One S 1TB 主机.jpg','Xbox One S 1TB 真4K 60帧高清游戏机')

select * from product
delete from product where  pk_pid in (9,10,12,13,14,15,16)
-----------------------------------------
insert into category_association values(1,1),(1,2),(1,3),(1,4),(1,5)
insert into category_association values(2,6),(2,7)
go
insert into product_image values
(1,'Image\全新 Surface Go.jpg'),
(2,'Image\全新 Surface Laptop 2.jpg'),
(3,'Image\全新 Surface Pro 6.jpg'),
(4,'Image\Surface Book 2.jpg'),
(5,'Image\全新 Surface Studio 2.jpg')
insert into product_image values
(6,'Image\Xbox One X 1TB 主机.png'),
(7,'Image\Xbox One S 1TB 主机.png')

insert into specification values(1,'Surface类')
insert into specification values(2,'Xbox类')
go
insert into spec_property values(1,'Surface颜色','Surface配置')  --Surface规格属性
insert into spec_property(spid,sp_pr_one_name) values(2,'Xbox配置')  --Xbox规格属性

insert into prt_specification values
(1,null,'微软 Surface Go 英特尔 4415Y/4GB/64GB/WiFi',2908,100,1),
(1,null,'微软 Surface Go 英特尔 4415Y/8GB/128GB/WiFi',3888,100,1),
(1,null,'微软 Surface Go 英特尔 4415Y/8GB/128GB/带 LTE 增强版',12312,100,1)
insert into prt_specification values
(2,'典雅黑','微软 Surface Laptop 2 酷睿 i5/8GB/256GB/典雅黑',9728,100,1),
(2,'典雅黑','微软 Surface Laptop 2 酷睿 i7/8GB/256GB/典雅黑',11986,100,1),
(2,'典雅黑','微软 Surface Laptop 2 酷睿 i7/16GB/512GB/典雅黑',16458,100,1),
(2,'深酒红','微软 Surface Laptop 2 酷睿 i5/8GB/256GB/深酒红',9728,100,1),
(2,'深酒红','微软 Surface Laptop 2 酷睿 i7/8GB/256GB/深酒红',11986,100,1),
(2,'深酒红','微软 Surface Laptop 2 酷睿 i7/16GB/512GB/深酒红',16458,100,1)

delete product where pk_pid=1

insert into prt_specification values
(6,'微软 Xbox One X 家庭娱乐游戏机1TB 冰雪白特别版',null,3898,50,1),
(6,'微软 Xbox One X 家庭娱乐游戏机1TB 渐变金特别版',null,3699,50,1),
(6,'微软 Xbox One X 家庭娱乐游戏机1TB 消光黑',null,3799,50,1),
(6,'微软 Xbox One X 家庭娱乐游戏机1TB《极限竞速 7》套装',null,3799,50,1)
insert into prt_specification values
(7,'微软 Xbox One S 家庭娱乐游戏机 1TB',null,2199,50,1),
(7,'微软 Xbox One S 家庭娱乐游戏机 1TB 双手柄套装',null,2399,50,1),
(7,'微软 Xbox One S 家庭娱乐游戏机 1TB 动作冒险套装',null,2199,50,1),
(7,'微软 Xbox One S 家庭娱乐游戏机 1TB 家庭套装（核心重铸+索尼克：力量）',null,2199,50,1)
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
* from product where pname like '%全%') 
as p where rowNo between 1 and 5
--查询某个商品类型商品总数
select Count(*) from category_association where 1=1 and cid=1

--多表条件查询
go
select c.cname 类型名称, a.cid ,a.pid, p.pname ,p.about
from category c Inner Join category_association a on c.pk_cid=a.cid
 inner join product p on p.pk_pid=a.pid where 1=1 and cid=1
 go
--多表条件查询
 select * from (select ROW_NUMBER()over(order by pk_pid) as rowNo,
 c.cname 类型名称,c.pk_cid, a.cid ,a.pid, p.pk_pid, p.pname , p.original_price ,p.images, p.about ,p.create_time ,p.remark
from category c Inner Join category_association a on c.pk_cid=a.cid
 inner join product p on p.pk_pid=a.pid where 1=1 and cid like 1)
as p where rowNo between 1 and 6

--查询总数
select Count(*) from  category_association 
inner join product on pk_pid=pid where 1=1 and cid=1

select Count(*) from  category_association p
inner join product a on p.pid=a.pk_pid where 1=1 and p.cid=2


 select * from (select ROW_NUMBER()over(order by pk_pid) as rowNo,
 c.cname 类型名称,c.pk_cid, a.cid ,a.pid, p.pk_pid, p.pname , p.original_price ,p.images, p.about ,p.create_time ,p.remark
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

