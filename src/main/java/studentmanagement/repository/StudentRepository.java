package studentmanagement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import studentmanagement.pojo.StudentPojo;

@Repository
public class StudentRepository {
	// Hibernate Logic
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String sql;
	public static Object id;

	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("studentManangement");
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

	public StudentPojo add(String name, String email, long contact, String[] course, String username, String password) {
		StudentPojo student = new StudentPojo();
		openConnection();
		transaction.begin();
		student.setName(name);
		student.setEmail(email);
		student.setContact(contact);
		student.setUsername(username);
		student.setPassword(password);
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

	public StudentPojo login(String username, String password) {
		openConnection();
		transaction.begin();

		sql = "from StudentPojo where username = '"+username+"'and password = '"+password+"'";
		query = manager.createQuery(sql);
		List<StudentPojo> list = query.getResultList();
		sql = "select id from StudentPojo where username = '"+username+"'and password = '"+password+"'";
		query = manager.createQuery(sql);
		try {
		id = query.getSingleResult();
		for (StudentPojo student : list) {
			transaction.commit();
			closeConnection();
			return student;
		}}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(id+"+++++++++++++++++++++++");
		return null;
	}

	public StudentPojo remove(int id) {
		openConnection();
		transaction.begin();
		StudentPojo student = new StudentPojo();
		sql = "select id from StudentPojo where id = '"+id+"'";
		query = manager.createQuery(sql);
		List<StudentPojo> list = query.getResultList();
		System.out.println(list.size());
		if(list.isEmpty()) {
			return null;
		}
		else {
		student = manager.find(StudentPojo.class,id);
		manager.remove(student);
		transaction.commit();
		closeConnection();
		return student;
		}
	}

	public StudentPojo update(int id, String name, String email, long contact, String username, String password, String[] course) {
		StudentPojo student = new StudentPojo();
		openConnection();
		transaction.begin();
		
		student = manager.find(StudentPojo.class, id);
		if(name!=null)
		student.setName(name);
		if(email!=null)
		student.setEmail(email);
		if(contact!=0)
		student.setContact(contact);
		if(password!=null)
		student.setPassword(password);
		if(username!=null)
		student.setUsername(username);
		int l = course.length;
		String c = "";
		if(course.length!=0){
			for (int i = 0; i < l; i++) {
				c += course[i] + " ";
				student.setCourse(c);
			}
		}
		transaction.commit();
		closeConnection();
		return student;
	}

	public StudentPojo search(int id) {
		openConnection();
		transaction.begin();
		StudentPojo student = new StudentPojo();
		student = manager.find(StudentPojo.class, id);
		if(student!=null) {
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return student;
	}

	public List<StudentPojo> searchAll() {
		openConnection();
		transaction.begin();
		
		sql = "from StudentPojo";
		query = manager.createQuery(sql);
		List<StudentPojo> student =  query.getResultList();
		
		transaction.commit();
		closeConnection();
		return student;
	}

	public StudentPojo rating(Object id2) {
		StudentPojo student = new StudentPojo();
		openConnection();
		transaction.begin();
		System.out.println(id2+"_______________________________________________");
		student = manager.find(StudentPojo.class, id2);
		transaction.commit();
		closeConnection();
		return student;
	}

	
}
