set names utf8;
set foreign_key_checks = 0;

drop database if exists ecsite2;
create database if not exists ecsite2;
use ecsite2;

drop table if exists login_user_transaction;
create table login_user_transaction(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	admin_flg varchar(1),
	insert_date datetime,
	updated_date datetime
);

insert into login_user_transaction(login_id,login_pass,user_name)values("internous","internous01","test");
insert into login_user_transaction(login_id,login_pass,user_name,admin_flg)values("aaa","bbb","ccc","1");
insert into login_user_transaction(login_id,login_pass,user_name)values("bbb","ccc","ddd");

drop table if exists item_info_transaction;
create table item_info_transaction(
	item_id int not null primary key auto_increment comment "ID",
	item_name varchar(100) not null comment "商品名",
	item_name_kana varchar(100) not null comment "商品名かな",
	item_description varchar(255) not null comment "商品説明",
	category_id int not null not null comment "カテゴリID",
	item_price int comment "価格",
	image_file_path varchar(100) comment "画像ファイルパス",
	image_file_name varchar(50) comment "画像ファイル名",
	release_date datetime not null comment "発売年月",
	release_company varchar(50) comment "発売会社",
	item_stock int comment "在庫数",
	insert_date datetime comment "登録日",
	update_date datetime comment "更新日",
	foreign key(category_id) references m_category(category_id)
)default charset=utf8 comment="商品情報テーブル";

insert into item_info_transaction values
(1,"本","ほん","本についての商品説明(長文での例：ああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ)",2,100,"./img","book.jpg",now(),"A株式会社",50,now(),now()),
(2,"鉛筆","えんぴつ","鉛筆についての商品説明",2,50,"./img","pen.jpg",now(),"B株式会社",50,now(),now()),
(3,"消しゴム","けしごむ","消しゴムについての商品説明",2,70,"./img","mono.jpg",now(),"C株式会社",50,now(),now()),
(4,"ズボン","ずぼん","ズボンについての商品説明",3,2900,"./img","bottom.jpg",now(),"D株式会社",50,now(),now()),
(5,"シャツ","しゃつ","シャツについての商品説明",3,1900,"./img","shorts.jpg",now(),"A株式会社",50,now(),now()),
(6,"靴","くつ","靴についての商品説明",3,3900,"./img","shoes.jpg",now(),"A株式会社",50,now(),now()),
(7,"帽子","ぼうし","帽子についての商品説明",3,2000,"./img","hat.png",now(),"A株式会社",50,now(),now()),
(8,"PC","ぱそこん","PCについての商品説明",4,50000,"./img","pc.jpg",now(),"A株式会社",50,now(),now()),
(9,"スマートフォン","すまーとふぉん","スマートフォンについての商品説明",4,20000,"./img","smartphone.jpg",now(),"A株式会社",50,now(),now()),
(10,"キーボード","きーぼーど","キーボードについての商品説明",4,5000,"./img","keyboard.jpg",now(),"A株式会社",50,now(),now()),
(11,"マウス","まうす","マウスについての商品説明",4,3000,"./img","mouse.jpg",now(),"A株式会社",50,now(),now()),
(12,"本2","ほん2","本についての商品説明(長文での例：あああああああああああああああああああああああああああああああああああああ)",2,100,"./img","book.jpg",now(),"A株式会社",50,now(),now()),
(13,"鉛筆2","えんぴつ2","鉛筆についての商品説明",2,50,"./img","pen.jpg",now(),"B株式会社",50,now(),now()),
(14,"消しゴム2","けしごむ2","消しゴムについての商品説明",2,70,"./img","mono.jpg",now(),"C株式会社",50,now(),now()),
(15,"ズボン2","ずぼん2","ズボンについての商品説明",3,2900,"./img","bottom.jpg",now(),"D株式会社",50,now(),now()),
(16,"シャツ2","しゃつ2","シャツについての商品説明",3,1900,"./img","shorts.jpg",now(),"A株式会社",50,now(),now()),
(17,"靴2","くつ2","靴についての商品説明",3,3900,"./img","shoes.jpg",now(),"A株式会社",50,now(),now()),
(18,"帽子2","ぼうし2","帽子についての商品説明",3,2000,"./img","hat.png",now(),"A株式会社",50,now(),now()),
(19,"PC2","ぱそこん2","PCについての商品説明",4,50000,"./img","pc.jpg",now(),"A株式会社",50,now(),now()),
(20,"スマートフォン2","すまーとふぉん2","スマートフォンについての商品説明",4,20000,"./img","smartphone.jpg",now(),"A株式会社",50,now(),now()),
(21,"キーボード2","きーぼーど2","キーボードについての商品説明",4,5000,"./img","keyboard.jpg",now(),"A株式会社",50,now(),now()),
(22,"マウス2","まうす2","マウスについての商品説明",4,3000,"./img","mouse.jpg",now(),"A株式会社",50,now(),now());
create table m_category(
id int primary key not null comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)
default charset=utf8
comment="カテゴリマスタテーブル"
;
insert into m_category values
(1,1,"全てのカテゴリー","本、家電・パソコン、おもちゃ・ゲーム全てのカテゴリーが対象となります",now(), null),
(2,2,"雑貨","雑貨に関するカテゴリーが対象となります",now(),null),
(3,3,"ファッション","ファッションに関するカテゴリーが対象となります",now(),null),
(4,4,"家電・パソコン","家電・パソコンに関するカテゴリーが対象となります",now(),null);

drop table if exists user_buy_item_transaction;
create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
);

drop table if exists basket_transaction;
create table basket_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	item_name varchar(50),
	total_price int,
	total_count int,
	user_master_id varchar(16),
	insert_date datetime
);
