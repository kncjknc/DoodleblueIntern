package Studens.Course.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Course_TB")
public class Course {

	@Id
	@GeneratedValue
	private int cid;
	private String coursename;
	private int fee;
	
	@ManyToMany(mappedBy = "course",fetch=FetchType.LAZY)
	@JsonBackReference
	private Set<Students> students;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Set<Students> getStudents() {
		return students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	public Course(int cid, String coursename, int fee, Set<Students> students) {
		super();
		this.cid = cid;
		this.coursename = coursename;
		this.fee = fee;
		this.students = students;
	}

	public Course() {
		super();
	}

	
}
