select cn_user_id
from cn_notebook;

select cn_notebook_id as id,
		cn_notebook_name as name
from cn_notebook
where cn_user_id='333c6d0b-e4a2-4596-9902-a5d98c2f665a';
