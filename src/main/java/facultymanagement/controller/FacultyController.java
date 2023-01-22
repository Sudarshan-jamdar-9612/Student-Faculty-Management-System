package facultymanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import facultymanagement.Pojo.FacultyPojo;
import facultymanagement.service.FacultyService;

@Controller
public class FacultyController {
	@Autowired
	private FacultyService service;

	@GetMapping("/facultyviews/homeFaculty")
	public String home() {
		return "/facultyviews/homeFaculty";
	}
	
	@GetMapping("/facultyviews/login")
	public String login() {
		return "/facultyviews/login";
	}
	
	@PostMapping("/facultyviews/login")
	public String loginValid(@RequestParam String username, @RequestParam String password, ModelMap map) {
		FacultyPojo faculty = service.loginfaculty(username, password);
		if (faculty != null) {
			return "/facultyviews/homeFaculty";
		}
		map.addAttribute("msg", "Invalid username or Password");
		return "/facultyviews/login";
	} 
	@GetMapping("/facultyviews/batchdetails")
	public String batchDetails() {
		return "/facultyviews/batchdetails";
	}
}
