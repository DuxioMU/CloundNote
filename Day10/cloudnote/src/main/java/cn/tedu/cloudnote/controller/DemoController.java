package cn.tedu.cloudnote.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	
	@RequestMapping("/upload.do")
	@ResponseBody
	public String upload(
			MultipartFile userfile1,
			MultipartFile userfile2) throws Exception{
		//Spring MVC 会自动解析文件上载流, 将上载信息
		// 保存到 MultipartFile 对象中, 注入控制器
		//前提:导入Apache 文件上载包和配置上载解析器
		System.out.println(userfile1);
		System.out.println(userfile2);
		//显示原始文件名
		System.out.println(
				userfile1.getOriginalFilename());
		System.out.println(
				userfile2.getOriginalFilename());
		String name = userfile2.getOriginalFilename();
		//处理文件名编码问题
		name = new String(
			name.getBytes("iso8859-1"), "utf-8");
		System.out.println(name);
		//获取文件的数据
		byte[] data1 = userfile1.getBytes();
		//byte[] data2 = userfile2.getBytes();
		//InputStream in1 = userfile1.getInputStream();
		InputStream in2 = userfile2.getInputStream();
		
		//保存文件   /home/soft01/upload
		File path = new File("D:/upload");
		path.mkdir();
		//文件名解码
		String n1 = userfile1.getOriginalFilename();
		n1 = new String(n1.getBytes("iso8859-1"),"utf-8");
		//将文件保存到 upload 文件夹中
		File file1 = new File(path, n1);
		FileOutputStream out1 = 
				new FileOutputStream(file1);
		//将数据保存到流中
		out1.write(data1);//将data1中全部的数据写到文件
		out1.close();
		
		//保存第二个文件
		String n2 = userfile2.getOriginalFilename();
		n2 = new String(n2.getBytes("iso-8859-1"), "utf-8");
		File file2 = new File(path, n2);
		FileOutputStream out2 = 
				new FileOutputStream(file2);
		//读取第2个文件的全部数据写到out2中
		int b;
		while((b=in2.read())!=-1){
			out2.write(b);
		}
		in2.close();
		out2.close();
		
		//获取文件的类型 
		String type1 = userfile1.getContentType();
		String type2 = userfile2.getContentType();
		//获取表单输入input 控件的名字name
		String name1 = userfile1.getName();
		String name2 = userfile2.getName();
		//获取文件的大小
		long size1 = userfile1.getSize();
		long size2 = userfile2.getSize();
		
		return "OK";
	}
	
	
	@RequestMapping(
			produces="application/vnd.ms-excel",
			value="/excel.do")
	@ResponseBody
	public byte[] excel(HttpServletResponse res) throws Exception{
		byte[] bytes = createExcel();
		//按照HTTP协议 RFC2616 19.5.1 Content-Disposition 发送文件名
		res.addHeader("Content-Disposition",
				"attachment; filename=\"hello.xls\"");
		//Content-Disposition: attachment; filename="fname.ext"
		return bytes;
	}
	
	private byte[] createExcel() throws IOException{
		//1. 利用POI API创建Excel对象
		//创建Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = workbook.createSheet();
		//在表中创建行和列
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		//在 0,0 格子中写入 Hello World! 
		cell.setCellValue("Hello World!"); 
		//调用业务层
		//2. 将Excel对象编码为byte[]
		ByteArrayOutputStream out = 
				new ByteArrayOutputStream();
		workbook.write(out);
		out.close();
		
		//3. 返回 byte[] 
		byte[] bytes = out.toByteArray();
		return bytes;
	}
	
	@RequestMapping(
			produces="image/png",
			value="/png.do")
	@ResponseBody
	public byte[] png() 
		throws Exception{
		byte[] png = createPng();
		return png;//填充响应消息的 body
	}
	
	public byte[] createPng() throws IOException{
		//1. 创建图片对象
		BufferedImage img = new BufferedImage(
			200, 100, BufferedImage.TYPE_3BYTE_BGR);
		img.setRGB(100, 50, 0xffffff); 
		//2. 将图片编码为 png
		ByteArrayOutputStream out=
				new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		//3. 得到所有的bytes
		byte[] ary = out.toByteArray();
		return ary;
	}
}





