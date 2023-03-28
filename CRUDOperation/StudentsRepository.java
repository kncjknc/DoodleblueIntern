package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Students;

public interface StudentsRepositary extends JpaRepository<Students, Integer> {

	Students findByName(String name);

}
