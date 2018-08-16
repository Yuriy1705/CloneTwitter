 create table message (
 id int not null primary key auto_increment,
 filename varchar(255),
 tag varchar(255),
 text varchar(255) not null,
 user_id int);


 create table user_role (
 user_id int not null,
 roles varchar(255));


 create table usr (
 id int not null primary key auto_increment,
 activation_code varchar(255),
 active bit not null,
 email varchar(255),
 password varchar(255) not null,
 username varchar(255) not null);


 alter table message
 add constraint message_user_fk
 foreign key (user_id) references usr (id);

 alter table user_role
 add constraint user_user_role_fk
 foreign key (user_id) references usr (id);