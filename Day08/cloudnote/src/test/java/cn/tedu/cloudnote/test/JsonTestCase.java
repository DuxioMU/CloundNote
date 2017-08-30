package cn.tedu.cloudnote.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 测试: 将各种数据序列化为JSON对象
 * 结论:
 *   1. 数组与List序列化为JSON是一样的
 *   2. JavaBean和Map序列化为JSON是一样的
 *   3. List<bean> 和 List<map> 序列化为JSON是一样的
 *   
 *   可以Map作为Json对象
 *   值对象
 */
public class JsonTestCase {

	@Test
	public void testArray() 
			throws JsonProcessingException{
		//测试数组是如何序列化为 json 对象
		String[] ary = {"Tom", "Jerry"};
		//将数组序列化为JSON
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(ary);
		//输出JSON结果
		System.out.println(json);
	}
	
	@Test 
	public void testList() throws JsonProcessingException{
		//将List序列化为JSON
		List<String> list = new ArrayList<String>();
		list.add("范萌萌");
		list.add("李大湿");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		System.out.println(json); 
	}
	
	@Test
	public void testJavaBean() throws JsonProcessingException{
		//JavaBean 序列化为 JSON
		Foo foo = new Foo(5, "Tom");
		ObjectMapper mapper= new ObjectMapper();
		String json = mapper.writeValueAsString(foo);
		System.out.println(json);
	}
	@Test
	public void testMap() throws Exception{
		//将Map序列化为JSON
		
		Map<String, Object> map = 
				new HashMap<String, Object>();
		map.put("id", 5);
		map.put("name", "Tom");
		ObjectMapper mapper= new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		System.out.println(json);
	}
	
	@Test
	public void testList1() throws Exception{
		//将List<bean> 序列化为 JSON
		List<Foo> list = new ArrayList<Foo>();
		list.add(new Foo(2, "Tom"));
		list.add(new Foo(3, "Jerry"));
		list.add(new Foo(4, "Andy"));
		ObjectMapper mapper= new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		System.out.println(json);
	}
	
	@Test
	public void testList2() throws Exception{
		//将List<Map> 序列化为 JSON
		
		List<Map<String, Object>> list=
			new ArrayList<Map<String,Object>>();
		Map<String, Object> map = 
				new HashMap<String, Object>();
		map.put("id", 5);
		map.put("name", "Tom");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", 2);
		map.put("name", "Jerry");
		list.add(map);
		ObjectMapper mapper= new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		System.out.println(json);
	}
}

class Foo{
	
	int id;
	String name;
	
	public Foo() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Foo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}








