package com.example.project_111.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstname;
 private String lastname;
 private String email;
 private String password;
 private String phone;

 @ManyToOne
 @JoinColumn(name = "course_id")
 private Course course;

 @ManyToOne
 @JoinColumn(name = "teacher_id")
 private Teacher teacher;

 private String timing;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}

public Teacher getTeacher() {
	return teacher;
}

public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}

public String getTiming() {
	return timing;
}

public void setTiming(String timing) {
	this.timing = timing;
}

}