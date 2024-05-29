package com.example.project_111.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.project_111.Entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT DISTINCT t.courses FROM Teacher t")
    List<String> findAllCourses();

    @Query("SELECT t FROM Teacher t WHERE :course MEMBER OF t.courses")
    List<Teacher> findTeachersByCourse(String course);

    @Query("SELECT t.availability FROM Teacher t WHERE t.id = :teacherId")
    List<String> getTeacherAvailability(Long teacherId);
}
