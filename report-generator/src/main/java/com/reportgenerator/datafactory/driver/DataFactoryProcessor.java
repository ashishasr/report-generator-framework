package com.reportgenerator.datafactory.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reportgenerator.bean.Institute;
import com.reportgenerator.bean.Student;
import com.reportgenerator.datafactory.api.DataFactory;

@Service
@Transactional
public class DataFactoryProcessor {

	public List<Student> getStudentRecords() {
		List<Student> studentBeans = new ArrayList<Student>();
		DataFactory df = new DataFactory();
		System.out.println("Records for Student Table: \n");
		for (int i = 1; i <= 100; i++) {
			Student studentBean = new Student();
			// studentBean.setId(new Long(df.getNumberUpTo(100)));
			studentBean.setId(new Long(i));
			studentBean.setName(df.getName());
			studentBean.setAge(Integer.parseInt(df.getAge()));
			studentBean.setGender(df.getGender());
			studentBean.setPercMarks(new Double(df.getFloatNumberBetween(25, 95)));
			studentBean.setYearPassout(Integer.parseInt(df.getYearPassout()));
			studentBean.setInstId(new Long(df.getNumberUpTo(50)));
			studentBeans.add(studentBean);
			
			System.out.println(i + "," + df.getName() + "," + df.getAge() + "," + df.getGender() + ","
					+ df.getFloatNumberBetween(25, 95) + "," + df.getYearPassout() + "," + df.getNumberUpTo(50));

		}
		return studentBeans;

	}

	public List<Institute> getInstituteRecords() {

		List<Institute> instituteBeans = new ArrayList<Institute>();
		DataFactory df = new DataFactory();
		System.out.println("\nRecords for Institue Table: \n");
		for (int i = 1; i <= 100; i++) {
			Institute instituteBean = new Institute();
			instituteBean.setId(new Long(i));
			instituteBean.setInstitutename(df.getInstituteNames());
			instituteBean.setOperatingyear(df.getOperatingYear());
			instituteBean.setState(df.getState());
			instituteBeans.add(instituteBean);
			
			System.out.println(i + "," + df.getInstituteNames() + "," + df.getOperatingYear() + "," + df.getState());
		}
		return instituteBeans;

	}
}
