package facultymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import facultymanagement.Pojo.FacultyPojo;
import facultymanagement.Repository.FacultyRepository;
import studentmanagement.pojo.StudentPojo;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository repository;
	public FacultyPojo add(String name, String email, long contact, String[] job) {
		FacultyPojo faculty = repository.add(name,email,contact,job);
		return faculty;
	}
	public FacultyPojo search(int id) {
		FacultyPojo faculty = repository.search(id);
		return faculty;
	}
	public FacultyPojo updateDataForForm(int id) {
		FacultyPojo faculty = repository.updateDataForForm(id);
		return faculty;
	}
	public List<FacultyPojo> searchAll() {
		List<FacultyPojo> facultyList = repository.searchAll();
		return facultyList;
	}
	public FacultyPojo updateDataForDB(int id, String name, String email, long contact, String[] course) {
		FacultyPojo faculty = repository.updateDataForDB(id,name,email,contact,course);
		return faculty;
	}
	public FacultyPojo remove(int id) {
		FacultyPojo faculty = repository.remove(id);
		return faculty;
	}
	public FacultyPojo loginfaculty(String username, String password) {
		FacultyPojo faculty = repository.loginfaculty(username,password);
		return faculty;
	}

}
