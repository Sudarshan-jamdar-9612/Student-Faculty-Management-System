package admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin.pojo.AdminPojo;
import admin.service.AdminService;
import facultymanagement.Pojo.FacultyPojo;
import studentmanagement.pojo.StudentPojo;

@Controller
public class AdminController {
	@Autowired
	private AdminService service;
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signupData(@RequestParam String username,@RequestParam String password,@RequestParam String email,ModelMap map) {
		System.out.println(username+"***"+password+"***"+email);
		AdminPojo admin = service.signup(username,password,email);
		if(admin!=null) {
			map.addAttribute("msg","You are Eligible to Login!");
			return "signup";
		}
		map.addAttribute("msg","Error!,while creating an Account [Already Exist]");
		return "signup";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String index(@RequestParam String username,@RequestParam String password,ModelMap map) {
		AdminPojo admin = service.login(username,password);
		if(admin!=null) {
			return "index";
		}
		map.addAttribute("msg","please check your username & password");
		return "login";
	}
	
	@GetMapping("/CRUD_on_Student/home")
	public String home() {
		return "/CRUD_on_Student/home";
	}
	
	@GetMapping("/CRUD_on_Faculty/homeFacultyForAdmin")
	public String homefaculty() {
		return "/CRUD_on_Faculty/homeFacultyForAdmin";
	}
	
	@GetMapping("/CRUD_on_Student/add")
	public String add() {
		return "/CRUD_on_Student/add";
	}
	
	@GetMapping("/CRUD_on_Faculty/addfaculty")
	public String addfaculty() {
		return "/CRUD_on_Faculty/addfaculty";
	}
	
	@PostMapping("/CRUD_on_Faculty/addfaculty")
	public String addfacultyData(@RequestParam String name,@RequestParam  String email,@RequestParam String[] job ,@RequestParam long contact,
			@RequestParam String username, @RequestParam String password,ModelMap map) {
		FacultyPojo faculty = service.addfaculty(name,email,contact,job,username,password);
		if(faculty!=null) {
			map.addAttribute("msg","Faculty Data Inserted!!!");
		}
		else {
			map.addAttribute("msg","!Unable to Insert Faculty Data[Record Already Exist]");
		}
		return "/CRUD_on_Faculty/addfaculty";
	}

	@PostMapping("/CRUD_on_Student/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String[] course, @RequestParam String username, @RequestParam String password
			,@RequestParam String java,@RequestParam String sql,@RequestParam String python,@RequestParam String web,ModelMap map) {
		StudentPojo student = service.add(name, email, contact, username, password, course,java,sql,python,web);
		System.out.println(student+"*************************************");
		if (student != null) {
			map.addAttribute("msg", "Data Inserted!!!");
		} else {
			map.addAttribute("msg", "Unable, to insert Data[Student Record Exist]");
		}
		return "/CRUD_on_Student/add";
	}
	
	@GetMapping("/CRUD_on_Student/search")
	public String search() {
		return "/CRUD_on_Student/search";
	}

	@PostMapping("/CRUD_on_Student/search")
	public String searchData(@RequestParam int id, ModelMap map) {
		StudentPojo student = service.search(id);
		if (student != null) {
			map.addAttribute("student", student);
			return "/CRUD_on_Student/search";
		} else {
			map.addAttribute("msg", "Data doesn't exist!!");
			return "/CRUD_on_Student/search";
		}
	}
	
	@GetMapping("/CRUD_on_Faculty/searchfaculty")
	public String searchfaculty() {
		return "/CRUD_on_Faculty/searchfaculty";	
	}
	
	@PostMapping("/CRUD_on_Faculty/searchfaculty")
	public String searchfacultyData(@RequestParam int id,ModelMap map) {
		FacultyPojo faculty = service.searchfaculty(id);
		map.addAttribute("faculty", faculty);
		if (faculty!=null) {
			map.addAttribute("faculty", faculty);
			return "/CRUD_on_Faculty/searchfaculty";
		}
		map.addAttribute("msg", "Record Not Found");
		return "/CRUD_on_Faculty/searchfaculty";
	}
	
	@GetMapping("/CRUD_on_Student/update")
	public String update(ModelMap map) {
		List<StudentPojo> student = service.searchAll();
		if(student!=null) {
			map.addAttribute("student", student);
			return "/CRUD_on_Student/update";
		}
		map.addAttribute("msg", "Record Not Found");
		return "/CRUD_on_Student/update";
	}
	
	@PostMapping("/CRUD_on_Student/update")
	public String updateform(@RequestParam int id,ModelMap map) {
		StudentPojo student = service.search(id);
		List<StudentPojo> students = service.searchAll();
		map.addAttribute("student", students);
		if(student!=null) {
			map.addAttribute("stud", student);
			return "/CRUD_on_Student/updateForm";
		}
		map.addAttribute("msg", "Record Not Found");
		return "/CRUD_on_Student/update";
	}

	@PostMapping("/CRUD_on_Student/updateForm")
	public String updateData(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long contact, @RequestParam String[] course, @RequestParam String username,
			@RequestParam String password,@RequestParam String java,@RequestParam String sql,@RequestParam String python,@RequestParam String web, ModelMap map) {
		StudentPojo student = service.update(id, name, email, contact, username, password, course,java,sql,python,web);
		List<StudentPojo> students = service.searchAll();
		map.addAttribute("student", students);
		map.addAttribute("msg", "Record Updated Successfully!!");
		return "/CRUD_on_Student/update";
	}
	
	@GetMapping("/CRUD_on_Faculty/updatefaculty")
	public String updatefaculty(ModelMap map) {
		List<FacultyPojo> facultyList = service.searchAllfaculty();
		if (facultyList!=null) {
			map.addAttribute("list", facultyList);
			return "/CRUD_on_Faculty/updatefaculty";
		}
		return "/CRUD_on_Faculty/updatefaculty";
	}
	
	@PostMapping("/CRUD_on_Faculty/updatefaculty")
	public String updateData(@RequestParam int id,ModelMap map) {
		FacultyPojo faculty = service.updateDataForFaulty(id);
		List<FacultyPojo> facultyList = service.searchAllfaculty();
		if(faculty!=null) {
			map.addAttribute("faculty", faculty);
			return "/CRUD_on_Faculty/updateFacultyForm";
		}
		map.addAttribute("msg", "Record Not Found");
		return "/CRUD_on_Faculty/updatefaculty";
	}
	
	@PostMapping("/CRUD_on_Faculty/updateFacultyForm")
	public String UpdateDataVaiForm(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long contact, @RequestParam String[] job,@RequestParam String username,@RequestParam String password, ModelMap map) {
		FacultyPojo faculty = service.updateDataForFaulty(id,name,email,contact,job,username,password);
		List<FacultyPojo> facultyList = service.searchAllfaculty();
		map.addAttribute("list", facultyList);
		if(faculty!=null) {
			map.addAttribute("msg", "Record Updated");
			return "/CRUD_on_Faculty/updatefaculty";
		}
		map.addAttribute("msg", "Record Not Updated");
		return "/CRUD_on_Faculty/updatefaculty";
	}
	
	@GetMapping("/CRUD_on_Student/remove")
	public String remove(ModelMap map) {
		List<StudentPojo> student = service.searchAll();
		if(student!=null) {
			map.addAttribute("students", student);
			return "/CRUD_on_Student/remove";
		}
		map.addAttribute("msg", "Record Not Found");
		return "/CRUD_on_Student/remove";
	}

	@PostMapping("/CRUD_on_Student/remove")
	public String removeData(@RequestParam int id, ModelMap map) {
		StudentPojo student = service.remove(id);
		List<StudentPojo> students = service.searchAll();
		map.addAttribute("students", students);
		if (student != null) {
			map.addAttribute("remove", "Record Deleted Successfully");
		} else {
			map.addAttribute("remove", "Can't Delete,Record not Present[OUT OF RANGE]");
		}
		return "/CRUD_on_Student/remove";
	}
	
	@GetMapping("/CRUD_on_Faculty/removeFaculty")
	public String removefaculty(ModelMap map) {
		List<FacultyPojo> facultyList = service.searchAllfaculty();
		if (facultyList!=null) {
			map.addAttribute("list", facultyList);
			return "/CRUD_on_Faculty/removeFaculty";
		}
		map.addAttribute("msg", "Record Not Found");
		return "/CRUD_on_Faculty/removeFaculty";
	}
	
	@PostMapping("/CRUD_on_Faculty/removeFaculty")
	public String removeDate(@RequestParam int id,ModelMap map) {
		FacultyPojo faculty = service.removefaculty(id);
		List<FacultyPojo> facultyList = service.searchAllfaculty();
		map.addAttribute("list", facultyList);
		if(faculty!=null) {
			map.addAttribute("remove", "Record Deleted Successfully");
			return "/CRUD_on_Faculty/removeFaculty";
		}
		else {
			map.addAttribute("remove", "Can't Delete,Record not Present[OUT OF RANGE]");
		}
		return "/CRUD_on_Faculty/removeFaculty";
	}
	
}
