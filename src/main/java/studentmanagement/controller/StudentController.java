package studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import studentmanagement.pojo.StudentPojo;
import studentmanagement.repository.StudentRepository;
import studentmanagement.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/studentviews/home")
	public String home() {
		return "/studentviews/home";
	}

	@GetMapping("/studentviews/login")
	public String login() {
		return "/studentviews/login";
	}

	@PostMapping("/studentviews/login")
	public String loginValid(@RequestParam String username, @RequestParam String password, ModelMap map) {
		StudentPojo student = service.login(username, password);
		if (student != null) {
			return "/studentviews/home";
		}
		map.addAttribute("msg", "Invalid username or Password");
		return "/studentviews/login";
	}

	@GetMapping("/studentviews/mockrating")
	public String mockview(ModelMap map) {
		StudentPojo student = service.rating(StudentRepository.id);
		map.addAttribute("student", student);
		if (student != null) {
			return "/studentviews/mockrating";
		}
		map.addAttribute("msg", "Record not Present[OUT OF RANGE]");
		return "/studentviews/mockrating";
	}

}
