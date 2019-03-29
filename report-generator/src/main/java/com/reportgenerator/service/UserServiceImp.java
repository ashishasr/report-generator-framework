package com.reportgenerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reportgenerator.bean.Institute;
import com.reportgenerator.bean.Student;
import com.reportgenerator.repository.InstituteRepository;
import com.reportgenerator.repository.StudentRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	StudentRepository userRepository;
	
	@Autowired
	InstituteRepository instituteRepository;

	public void createStudent(List<Student> student) {
		// TODO Auto-generated method stub
		//userRepository.save(student);
		student.forEach(e ->{
			System.out.println(e.getId() + "," +e.getName());
			userRepository.save(e);} );
	}

	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return (List<Student>) userRepository.findAll();
	}

	public Student findById(long id) {
		return null;
		// TODO Auto-generated method stub
		//return userRepository.findOne(id);
	}

	public Student update(Student student, long l) {
		// TODO Auto-generated method stub
		return userRepository.save(student);
	}

	public void deleteStudentById(long id) {
		// TODO Auto-generated method stub
		//userRepository.delete(id);
	}

	public Student updatePartially(Student user, long id) {
		// TODO Auto-generated method stub
		Student usr = findById(id);
		usr.setName(user.getName());
		return userRepository.save(usr);
	}

	@Override
	public void createInstitute(List<Institute> institute) {
		// TODO Auto-generated method stub
		//instituteRepository.save(institute);
		institute.forEach(e -> instituteRepository.save(e));
		
	}

	@Override
	public List<Institute> getInstitute() {
		// TODO Auto-generated method stub
		return (List<Institute>) instituteRepository.findAll();
	}



}
