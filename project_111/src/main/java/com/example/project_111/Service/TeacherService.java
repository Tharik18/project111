package com.example.project_111.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project_111.Entity.Teacher;
import com.example.project_111.Repository.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<String> findAllCourses() {
        return teacherRepository.findAllCourses();
    }

    public List<Teacher> findTeachersByCourse(String course) {
        return teacherRepository.findTeachersByCourse(course);
    }

    public List<String> getTeacherAvailability(Long teacherId) {
        return teacherRepository.getTeacherAvailability(teacherId);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
