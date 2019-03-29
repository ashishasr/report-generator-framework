package com.reportgenerator.repository;

import org.springframework.data.repository.CrudRepository;

import com.reportgenerator.bean.Student;
public interface StudentRepository extends CrudRepository<Student, Long>
{
	

}
