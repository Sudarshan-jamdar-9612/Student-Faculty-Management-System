package studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentmanagement.pojo.StudentPojo;
import studentmanagement.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public StudentPojo search(int id) {
		StudentPojo student = repository.search(id);
		return student;
	}
	
	public StudentPojo add(String name, String email, long contact, String username, String password, String[] course) {
		StudentPojo student = repository.add(name,email,contact,course,username,password);
		System.out.println(student);
		return student;
	}

	public StudentPojo login(String username, String password) {
		StudentPojo student = repository.login(username,password);
		return student;
	}

	public StudentPojo remove(int id) {
		StudentPojo student = repository.remove(id);
		return student;
	}

	public StudentPojo update(int id, String name, String email, long contact, String username, String password, String[] course) {
		StudentPojo student = repository.update(id,name,email,contact,username,password,course);
		return student;
	}



	public List<StudentPojo> searchAll() {
		List<StudentPojo> student = repository.searchAll();
		return student;
	}

	public StudentPojo rating(Object id) {
		StudentPojo student = repository.rating(StudentRepository.id);
		return student;
	}


}
