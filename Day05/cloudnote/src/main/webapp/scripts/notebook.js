//sctipts/notebook.js
//网页加载之后执行
$(function(){
	
	//var id = getCookie('userId');
	//console.log(id);
	
	//调用方法加载笔记本列表
	loadNotebooks();
	
	//利用事件冒泡,绑定li被点击时候执行事件程序
	//绑定笔记本列表中li元素被点击的事件
	$('#pc_part_1').on('click','li',loadNotes);
	
	$('#pc_part_2').on('click','li',loadNote);
	
});

function loadNote(){
	var li = $(this);
	//获取在显示时候绑定到li中的笔记ID值
	var id = li.data('noteId');
	
	//设置选中高亮效果
	li.parent().find('a').removeClass('checked');
	li.find('a').addClass('checked');
	
	var url = 'note/get.do';
	var data= {noteId: id };
	
	$.getJSON(url, data, function(result){
		//console.log(result);
		if(result.state==0){
			var note = result.data;
			showNote(note);
		}else{
			alert(result.message);
		}
	});
}

function showNote(note){
	$('#input_note_title').val(note.title);
	um.setContent(note.body);
}

function loadNotes(){
	//在事件方法中的this就是当前发生事件的对象 li
	var li = $(this);
	console.log(li);
	//获取在显示时候绑定到li中的笔记本ID值
	var id = li.data('notebookId');
	console.log(id);
	
	//设置选中高亮效果
	li.parent().find('a').removeClass('checked');
	li.find('a').addClass('checked');
	
	var url = 'note/list.do';
	var data= {notebookId: id };
	
	$.getJSON(url, data, function(result){
		//console.log(result);
		if(result.state==0){
			var notes = result.data;
			showNotes(notes);
		}else{
			alert(result.message);
		}
	});
}

var noteTemplate = 
	'<li class="online">'+
	'	<a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> [title]<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button></a>'+
	'	<div class="note_menu" tabindex="-1">'+
	'		<dl>'+
	'			<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
	'			<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
	'			<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
	'  		</dl>'+
	'	</div>'+
	'</li>';

function showNotes(notes){
	var ul = $('#pc_part_2 .contacts-list');
	ul.empty();
	for(var i=0; i<notes.length; i++){
		var note = notes[i];
		var li = noteTemplate.replace('[title]', 
				note.title);
		//绑定noteId到li对象
		li = $(li).data('noteId', note.id);
		
		ul.append(li);
	}
}

function loadNotebooks(){
	//请求 notebook/list.do
	//如果成功就将请求结果显示到界面(DOM)上
	var url = 'notebook/list.do';
	var data = {userId:getCookie('userId')};
	console.log(data);
	$.getJSON(url, data, function(result){
		if(result.state==0){
			//console.log(result);
			var list = result.data;
			showNotebooks(list);
		}else{
			alert(result.message);
		}
	});
}

function showNotebooks(list){
	//找到ul对象
	var ul = $('#pc_part_1 .contacts-list');
	ul.empty();
	//为List中每个笔记本对象生成一个li元素, 添加到ul中
	for(var i=0; i<list.length; i++){
		var notebook=list[i];
		var li = notebookTemplate.replace(
				'[name]', notebook.name);
		//JQuery 提供了数据绑定方法, 可以在DOM元素上
		//绑定任何数据. 
		// li.data(key, value) 获取数据 li.data(key)
		li = $(li).data('notebookId', notebook.id);
		//将生成的li元素添加到页面的ul元素中
		ul.append(li);
	}
}

var notebookTemplate=
	'<li class="online">'+
	'<a>'+
	'<i class="fa fa-book" title="online" '+
		' rel="tooltip-bottom">'+
	'</i> [name]</a></li>';





