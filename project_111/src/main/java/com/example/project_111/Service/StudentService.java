package com.example.project_111.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project_111.Entity.Student;
import com.example.project_111.Repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public void updateStudentTiming(Long studentId, String newTiming) throws Exception {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new Exception("Student not found"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime currentTiming = LocalDateTime.parse(student.getTiming(), formatter);
        LocalDateTime newTimingDate = LocalDateTime.parse(newTiming, formatter);
        LocalDateTime now = LocalDateTime.now();

        if (currentTiming.minusHours(12).isAfter(now)) {
            student.setTiming(newTiming);
            studentRepository.save(student);
        } else {
            throw new Exception("Cannot update timing within 12 hours of the current timing");
        }
    }
}