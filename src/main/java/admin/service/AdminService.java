package admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.pojo.AdminPojo;
import admin.repository.AdminRepository;
import facultymanagement.Pojo.FacultyPojo;
import studentmanagement.pojo.StudentPojo;

@Service
public class AdminService {
	@Autowired
	private AdminRepository repository;

	public AdminPojo signup(String username, String password, String email) {
		AdminPojo admin = repository.signup(username,password,email);
		return admin;
	}

	public AdminPojo login(String username, String password) {
		AdminPojo admin = repository.login(username,password);
		return admin;
	}

	public StudentPojo add(String name, String email, long contact, String username, String password, String[] course, String java, String sql, String python, String web) {
		StudentPojo student = repository.add(name,email,contact,course,username,password,java,sql,python,web);
		return student;
	}

	public StudentPojo search(int id) {
		StudentPojo student = repository.search(id);
		return student;
	}

	public List<StudentPojo> searchAll() {
		List<StudentPojo> student = repository.searchAll();
		return student;
	}

	public StudentPojo update(int id, String name, String email, long contact, String username, String password,
			String[] course, String java, String sql, String python, String web) {
		StudentPojo student = repository.update(id,name,email,contact,username,password,course,java,sql,python,web);
		return student;
	}

	public StudentPojo remove(int id) {
		StudentPojo student = repository.remove(id);
		return student;
	}

	public FacultyPojo addfaculty(String name, String email, long contact, String[] job, String username,
			String password) {
		FacultyPojo faculty = repository.addfaculty(name,email,contact,job,username,password);
		return faculty;
	}

	public FacultyPojo searchfaculty(int id) {
		FacultyPojo faculty = repository.searchfaculty(id);
		return faculty;
	}

	public List<FacultyPojo> searchAllfaculty() {
		List<FacultyPojo> facultyList = repository.searchAllfaculty();
		return facultyList;
	}

	public FacultyPojo updateDataForFaulty(int id) {
		FacultyPojo faculty = repository.updateDataForFaulty(id);
		return faculty;
	}

	public FacultyPojo updateDataForFaulty(int id, String name, String email, long contact, String[] job, String username, String password) {
		FacultyPojo faculty = repository.updateDataForDB(id,name,email,contact,job,username,password);
		return faculty;
	}

	public FacultyPojo removefaculty(int id) {
		FacultyPojo faculty = repository.removefaculty(id);
		return faculty;
	}
}
