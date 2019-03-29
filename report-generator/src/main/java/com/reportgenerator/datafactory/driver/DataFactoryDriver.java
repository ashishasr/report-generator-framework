package com.reportgenerator.datafactory.driver;


import java.util.List;

import com.reportgenerator.bean.Institute;
import com.reportgenerator.bean.Student;

public class DataFactoryDriver {

	private static DataFactoryProcessor dataFactoryProcessor;
	
	public static void main(String[] args) {

		//Path path = Paths.get("D:/Analytics/data-io/usecase-data/student.csv");
		//System.out.println(path.getFileName());
		List<Student> studentRecords = null;
		List<Institute> instituteRecords = null;		
		dataFactoryProcessor = new DataFactoryProcessor();
		studentRecords = dataFactoryProcessor.getStudentRecords();
		instituteRecords  = dataFactoryProcessor.getInstituteRecords();
		
		

	}
}
