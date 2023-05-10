package Studens.Course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Studens.Course.entity.Course;

public interface CourseRepo extends JpaRepository<Course,Integer> {

}
