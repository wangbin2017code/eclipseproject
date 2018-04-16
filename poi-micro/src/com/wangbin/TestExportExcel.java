package com.wangbin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.wangbin.model.Student;
import com.wangbin.util.ExportExcel;

public class TestExportExcel {

	public static void main(String[] args) {
		
		// 测试学生
		//标题
		String[] headers = {"学号","姓名","年龄","性别","出生日期"};
		List<Student> dataset = new ArrayList<Student>();
		dataset.add(new Student(10000001, "张三", 20, true, new Date()));
		dataset.add(new Student(20000002, "李四", 24, false, new Date()));
		dataset.add(new Student(30000003, "王五", 22, true, new Date()));
		
		try {
			OutputStream outputStream = new FileOutputStream("E://learningProject//eclipseWorkspace//poi-micro//WebContent//excel//student.xls");
			ExportExcel.exportExcel("学生个人信息登记", headers, dataset, outputStream, "yy/MM/dd");
			JOptionPane.showMessageDialog(null, "导出成功!");
			System.out.println("excel导出成功!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
