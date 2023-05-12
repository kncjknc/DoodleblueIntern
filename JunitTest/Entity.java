package com.example.demo.entity;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students_tb")

public class Students {

	@Id
	@GeneratedValue
	private int id;
	@Column(length=40,nullable=false)
	@Length(min=5,max=40)
	private String name;
	@Column(length=50,nullable=false)
	@Length(min=5,max=50)
	private String std;
	@Column(length=40,nullable=false)
	@Length(min=5,max=40)
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}

