//sctipts/notebook.js
//网页加载之后执行
$(function(){
	
	//var id = getCookie('userId');
	//console.log(id);
	
	//调用方法加载笔记本列表
	loadNotebooks();
});

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





