package CrudQuery.ControllerReq;

import org.springframework.beans.factory.annotation.Autowired;

import CrudQuery.Entity.Students;

public class ControllRequest {

	private Students student;

	public void setStudent(Students student) {
		this.student = student;
	}

	public Students getStudent() {
		// TODO Auto-generated method stub
		return student;
	}

}
