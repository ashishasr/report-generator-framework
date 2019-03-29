package com.reportgenerator.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.reportgenerator.bean.Institute;
import com.reportgenerator.bean.Student;
import com.reportgenerator.datafactory.driver.DataFactoryProcessor;
import com.reportgenerator.service.UserService;

@RestController
@RequestMapping(value={"/user"})
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	DataFactoryProcessor dataFactoryProcessor;
	
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getUserById(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Student user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(user, HttpStatus.OK);
    }
    
    @GetMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createUser(){
	     System.out.println("Creating User ");
	     
	     List<Student> students = dataFactoryProcessor.getStudentRecords();
	     List<Institute> institutes = dataFactoryProcessor.getInstituteRecords();
	     userService.createStudent(students);
	     userService.createInstitute(institutes);
	     //HttpHeaders headers = new HttpHeaders();
	     //headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	     return new ResponseEntity<Void>(HttpStatus.CREATED);
	 }

	 @GetMapping(value="/getStudent", headers="Accept=application/json")
	 public List<Student> getAllUser() {	 
	  List<Student> tasks=userService.getStudent();
	  return tasks;
	
	 }
	 
	 @GetMapping(value="/getInstitute", headers="Accept=application/json")
	 public List<Institute> getAllInstitute() {	 
	  List<Institute> tasks=userService.getInstitute();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody Student currentUser)
	{
		System.out.println("sd");
	Student user = userService.findById(currentUser.getId());
	if (user==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	userService.update(currentUser, currentUser.getId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Student> deleteUser(@PathVariable("id") long id){
		Student user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		userService.deleteStudentById(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
}
