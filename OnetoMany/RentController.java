
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import CrudQuery.ControllerReq.ControllRequest;
import CrudQuery.Entity.LibraryBook;
import CrudQuery.Entity.Students;
import CrudQuery.Repository.LibraryBookRepository;
import CrudQuery.Repository.StudentsRepository;

@RestController
public class RentController {

	@Autowired
	private StudentsRepository studentsRepository;

	@Autowired
	private LibraryBookRepository libraryBookRepository;

	@PostMapping("/requestRentStuDeatil")
	public Students saveRentStuDeatil(@RequestBody ControllRequest request) {
		return studentsRepository.save(request.getStudent());
	}

	@GetMapping("/getAllStudents")
	public List<Students> getAllStudent() {
		return studentsRepository.findAll();
	}
	
	@PostMapping("/requestRentBooksDeatail")
	public LibraryBook saveRentBookDeatil(@RequestBody LibraryBook libraryBook) {
		return libraryBookRepository.save(libraryBook);
	}
	
	

}
