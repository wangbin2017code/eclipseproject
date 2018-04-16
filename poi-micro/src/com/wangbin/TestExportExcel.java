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
		
		// ����ѧ��
		//����
		String[] headers = {"ѧ��","����","����","�Ա�","��������"};
		List<Student> dataset = new ArrayList<Student>();
		dataset.add(new Student(10000001, "����", 20, true, new Date()));
		dataset.add(new Student(20000002, "����", 24, false, new Date()));
		dataset.add(new Student(30000003, "����", 22, true, new Date()));
		
		try {
			OutputStream outputStream = new FileOutputStream("E://learningProject//eclipseWorkspace//poi-micro//WebContent//excel//student.xls");
			ExportExcel.exportExcel("ѧ��������Ϣ�Ǽ�", headers, dataset, outputStream, "yy/MM/dd");
			JOptionPane.showMessageDialog(null, "�����ɹ�!");
			System.out.println("excel�����ɹ�!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
