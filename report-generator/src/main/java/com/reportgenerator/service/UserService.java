package com.reportgenerator.service;

import java.util.List;

import com.reportgenerator.bean.Institute;
import com.reportgenerator.bean.Student;

public interface UserService {
	public void createStudent(List<Student> students);
	public List<Student> getStudent();
	public Student findById(long id);
	public Student update(Student student, long l);
	public void deleteStudentById(long id);
	public Student updatePartially(Student student, long id);
	public void createInstitute(List<Institute> institutes);
	public List<Institute> getInstitute();
}
