package com.wangbin.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

// 导出数据到excel
public class ExportExcel{

	/**
	 * 将数据以excel形式输出到指定IO设备上
	 * @param <T>
	 * @param title 表格标题名
	 * @param headers 表格属性列名数组
	 * @param dataset 数据集合
	 * @param out 与输出设备关联的流对象
	 * @param pattern 时间格式
	 */
	public static <T> void exportExcel(String title,String[] headers,Collection<T> dataset,OutputStream out,String pattern){
		
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet  sheet = workbook.createSheet(title);
		//设置表格默认列宽度为15字节
		sheet.setDefaultColumnWidth(15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		//设置样式
		style.setFillBackgroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		//font.setFontHeight((short)1200);
		font.setBold(true);
		//把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		//style.setFillBackgroundColor(HSSFColor.SKY_BLUE.index);
		//style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setBorderBottom(BorderStyle.THIN);
		style2.setBorderLeft(BorderStyle.THIN);
		style2.setBorderTop(BorderStyle.THIN);
		style2.setBorderRight(BorderStyle.THIN);
		style2.setAlignment(HorizontalAlignment.CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBold(true);
		// 把字体应用到当前样式
		style2.setFont(font2);
		
		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置
		HSSFComment comment= patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short)4, 2, (short)6, 5));
		// 设置注释的内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释"));
		// 设置注释作者，当鼠标移动到单元格上可以在状态栏中看到该内容
		comment.setAuthor("wangbin");
		
		// 表格标题行
		HSSFRow row = sheet.createRow(0);
		for(short i=0;i<headers.length;i++){
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		// 遍历集合数据，填充数据行
		Iterator<T> it =  dataset.iterator();
		int index = 0;
		while(it.hasNext()){
			index++;
			row = sheet.createRow(index);
			T t = (T)it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用get方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for(int i=0;i<fields.length;i++){
				HSSFCell cell =row.createCell(i);
				cell.setCellStyle(style2);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				try{
					Class tCls = t.getClass();
				    Method getMethod=tCls.getMethod(getMethodName, new Class[]{});
				    Object vlaue = getMethod.invoke(t, new Object[]{});
				    //判断值的类型后进行强制类型转换
				    String textValue = null;
				    if(vlaue instanceof Boolean){
				    	boolean bValue = (Boolean)vlaue;
				    	textValue = "男";
				    	if(!bValue){
				    		textValue = "女";
				    	}
				    }else if(vlaue instanceof Date){
				    	Date date = (Date)vlaue;
				    	SimpleDateFormat sdf= new SimpleDateFormat(pattern);
				    	textValue = sdf.format(date);
				    }else{
				    	// 其他数据类型都当做字符串简单处理
				    	textValue = vlaue.toString();
				    }
				    cell.setCellValue(textValue);
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					//clear
				}
			}
		}
		
		try {
			workbook.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
