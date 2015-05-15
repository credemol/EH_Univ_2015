create table EH_USER (
    id integer generated always as identity (START WITH 1, INCREMENT BY 1),
    login_id varchar(50) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    display_name varchar(100) not null,
    email varchar(50) not null,
    mobile varchar(20),
    password varchar(100),
    constraint user_pk primary key (id)
);

insert into EH_USER(login_id, first_name, last_name, display_name, email, password) values('yg.kim@mygoogle.com', 'yg', 'kim', 'yg kim', 'yg.kim@mygoogle.com', 'welcome1');
insert into EH_USER(login_id, first_name, last_name, display_name, email, password) values('yw.kim@mygoogle.com', 'yw', 'kim', 'yw kim', 'yw.kim@mygoogle.com', 'welcome1');

create table EH_FORUM (
    id integer generated always as identity (START WITH 1, INCREMENT BY 1),
    type char(1) default 'A', -- A: all, D: department
    title varchar(200) not null,
    create_userid integer not null,
    create_timestamp timestamp not null,
    last_update_userid integer,
    last_update_timestamp timestamp,
    content long varchar,
    constraint forum_pk primary key (id)
);

insert into EH_FORUM (type, title, create_userid, create_timestamp, content) values ('A', 'title1', 1, current timestamp, 'content 1');
insert into EH_FORUM (type, title, create_userid, create_timestamp, content) values ('A', 'title2', 1, current timestamp, 'content 2');