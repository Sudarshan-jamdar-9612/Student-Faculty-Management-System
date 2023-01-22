package admin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import admin.pojo.AdminPojo;
import facultymanagement.Pojo.FacultyPojo;
import studentmanagement.pojo.StudentPojo;

@Repository
public class AdminRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String sql;
	private static FacultyPojo faculty;

	public static void openStudentConnection() {
		factory = Persistence.createEntityManagerFactory("studentManangement");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	public static void openFacultyConnection() {
		factory = Persistence.createEntityManagerFactory("facultyManagement");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("adminManager");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	public static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public AdminPojo signup(String username, String password, String email) {
		openConnection();
		transaction.begin();
		AdminPojo admin = new AdminPojo();

		admin.setUsername(username);
		admin.setPassword(password);
		admin.setEmail(email);
		try {
			manager.persist(admin);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			closeConnection();
			return null;
		}
		closeConnection();
		return admin;
	}

	public AdminPojo login(String username, String password) {
		openConnection();
		transaction.begin();

		sql = "from AdminPojo where username = '" + username + "' and password = '" + password + "'";
		query = manager.createQuery(sql);
		List<AdminPojo> list = query.getResultList();
		for (AdminPojo admin : list) {
			transaction.commit();
			closeConnection();
			return admin;
		}
		return null;
	}

	public StudentPojo add(String name, String email, long contact, String[] course, String username, String password,
			String java, String sql2, String python, String web) {
		StudentPojo student = new StudentPojo();
		openStudentConnection();
		transaction.begin();
		System.out.println(name + email + java + sql2 + python);
		student.setName(name);
		student.setEmail(email);
		student.setContact(contact);
		student.setUsername(username);
		student.setPassword(password);
		student.setJava(java);
		student.setSql(sql2);
		student.setWeb(web);
		student.setPython(python);
		int l = course.length;
		String c = "";
		if (l != 0) {
			for (int i = 0; i < l; i++) {
				c += course[i] + " ";
				student.setCourse(c);
			}
		}
		try {
			manager.persist(student);
			transaction.commit();
			System.out.println(student);
		} catch (Exception e) {
			student = null;
			return student;
		} finally {
			closeConnection();
		}
		return student;
	}

	public StudentPojo search(int id) {
		openStudentConnection();
		transaction.begin();
		StudentPojo student = new StudentPojo();
		student = manager.find(StudentPojo.class, id);
		if (student != null) {
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return student;
	}

	public List<StudentPojo> searchAll() {
		openStudentConnection();
		transaction.begin();

		sql = "from StudentPojo";
		query = manager.createQuery(sql);
		List<StudentPojo> student = query.getResultList();

		transaction.commit();
		closeConnection();
		return student;
	}

	public StudentPojo update(int id, String name, String email, long contact, String username, String password,
			String[] course, String java, String sql2, String python, String web) {
		StudentPojo student = new StudentPojo();
		openStudentConnection();
		transaction.begin();

		student = manager.find(StudentPojo.class, id);
		if (name != null)
			student.setName(name);
		if (email != null)
			student.setEmail(email);
		if (contact != 0)
			student.setContact(contact);
		if (password != null)
			student.setPassword(password);
		if (username != null)
			student.setUsername(username);
		if (java != null)
			student.setJava(java);
		if (sql2 != null)
			student.setSql(sql2);
		if (python != null)
			student.setPython(python);
		if (web != null)
			student.setWeb(web);
		int l = course.length;
		String c = "";
		if (course.length != 0) {
			for (int i = 0; i < l; i++) {
				c += course[i] + " ";
				student.setCourse(c);
			}
		}
		transaction.commit();
		closeConnection();
		return student;
	}

	public StudentPojo remove(int id) {
		openStudentConnection();
		transaction.begin();
		StudentPojo student = new StudentPojo();
		sql = "select id from StudentPojo where id = '" + id + "'";
		query = manager.createQuery(sql);
		List<StudentPojo> list = query.getResultList();
		System.out.println(list.size());
		if (list.isEmpty()) {
			return null;
		} else {
			student = manager.find(StudentPojo.class, id);
			manager.remove(student);
			transaction.commit();
			closeConnection();
			return student;
		}
	}

	public FacultyPojo addfaculty(String name, String email, long contact, String[] job, String username,
			String password) {
		openFacultyConnection();
		transaction.begin();
		faculty = new FacultyPojo();
		faculty.setName(name);
		faculty.setEmail(email);
		faculty.setContact(contact);
		faculty.setPassword(password);
		faculty.setUsername(username);
		String course = "";
		int l = job.length;
		if (l != 0) {
			for (int i = 0; i < l; i++) {
				course += job[i] + " ";
				faculty.setJob(course);
			}
		}
		try {
			manager.persist(faculty);
			transaction.commit();
		} catch (Exception e) {
			faculty = null;
			return faculty;
		}
		closeConnection();
		return faculty;
	}

	public FacultyPojo searchfaculty(int id) {
		openFacultyConnection();
		FacultyPojo faculty = new FacultyPojo();
		transaction.begin();
		faculty = manager.find(FacultyPojo.class, id);

		if (faculty != null) {
			transaction.commit();
			closeConnection();
			return faculty;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public List<FacultyPojo> searchAllfaculty() {
		openFacultyConnection();
		transaction.begin();
		FacultyPojo faculty = new FacultyPojo();

		sql = "from FacultyPojo";
		query = manager.createQuery(sql);
		List<FacultyPojo> facultyList = query.getResultList();
		if (facultyList != null) {
			transaction.commit();
			closeConnection();
			return facultyList;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public FacultyPojo updateDataForFaulty(int id) {
		openFacultyConnection();
		transaction.begin();
		FacultyPojo faculty = new FacultyPojo();
		faculty = manager.find(FacultyPojo.class, id);
		if (faculty != null) {
			transaction.commit();
			closeConnection();
			return faculty;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public FacultyPojo updateDataForDB(int id, String name, String email, long contact, String[] job, String username, String password) {
		FacultyPojo faculty = new FacultyPojo();
		openFacultyConnection();
		transaction.begin();
		faculty = manager.find(FacultyPojo.class, id);
		if(name!=null)
		faculty.setName(name);
		if(contact!=0)
		faculty.setContact(contact);
		if(email!=null)
		faculty.setEmail(email);
		if (username!=null) 
			faculty.setUsername(username);
		if(password!=null)
			faculty.setPassword(password);
		String course="";
		if(job!=null)
		{
			for(String c :job) {
				course += c+" ";
				faculty.setJob(course);
			}
		}
		manager.persist(faculty);
		transaction.commit();
		closeConnection();
		return faculty;
	}

	public FacultyPojo removefaculty(int id) {
		openFacultyConnection();
		transaction.begin();
		FacultyPojo faculty = new FacultyPojo();
		faculty = manager.find(FacultyPojo.class, id);
		if(faculty!=null) {
			manager.remove(faculty);
			transaction.commit();
			closeConnection();
			return faculty;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

}
