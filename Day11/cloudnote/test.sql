select cn_user_id
from cn_notebook;

-- 查询笔记本列表
select cn_notebook_id as id,
		cn_notebook_name as name
from cn_notebook
where cn_user_id='333c6d0b-e4a2-4596-9902-a5d98c2f665a';

-- 查询笔记列表
select
	cn_note_id as id,
	cn_note_title as title
from
	cn_note
where 
	cn_notebook_id='0b11444a-a6d6-45ff-8d46-282afaa6a655'
	
-- 查询笔记本id
select 
	cn_notebook_id 
from 
	cn_note
	
-- findNotebookById

select 
	cn_notebook_id 			as id,
	cn_user_id 					as userId,
	cn_notebook_type_id 		as typeId,
	cn_notebook_name 			as name,
	cn_notebook_desc 			as "desc",
	cn_notebook_createtime 	as createtime
from
	cn_notebook
where 
	cn_notebook_id='0b11444a-a6d6-45ff-8d46-282afaa6a655'


select * from cn_note;

-- 分页查询SQL
select cn_notebook_id as id, cn_notebook_name as name
from cn_notebook
where cn_user_id='333c6d0b-e4a2-4596-9902-a5d98c2f665a'
order by cn_notebook_createtime desc
limit 3, 3


create table p_person(
    id int not null AUTO_INCREMENT,
    name varchar(100),
    primary key(id)
);

insert into p_person (name) values ('李老师');
insert into p_person (id, name) values (null,'李老师');

select * from p_person;


create table p_comment(
    id int not null AUTO_INCREMENT,
    title varchar(100),
    post_id int,
    primary key(id)
);

create table p_post(
    id int not null AUTO_INCREMENT, 
    title varchar(100),
    person_id int,
    primary key(id)
);

insert into p_post (id, title, person_id)
    values (null, '今天天气不错', 1);
    
insert into p_post (id, title, person_id)
    values (null, '高考又来了', 1);
    
insert into p_comment(id, title, post_id)
    values ( null, '少穿了哪一件呀?', 1);
    
insert into p_comment(id, title, post_id)
    values (null, '冻成狗', 1);
insert into p_comment(id, title, post_id)
    values (null, '喜欢下雪', 1);




