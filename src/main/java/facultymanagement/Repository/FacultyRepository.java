package facultymanagement.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import facultymanagement.Pojo.FacultyPojo;
import lombok.Data;
import studentmanagement.pojo.StudentPojo;

@Repository
@Data
public class FacultyRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String sql;
	private static FacultyPojo faculty;
	public static Object id;

	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("facultyManagement");
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

	public FacultyPojo add(String name, String email, long contact, String[] job) {
		openConnection();
		transaction.begin();
		faculty = new FacultyPojo();
		faculty.setName(name);
		faculty.setEmail(email);
		faculty.setContact(contact);
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

	public FacultyPojo search(int id) {
		openConnection();
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

	public FacultyPojo updateDataForForm(int id) {
		openConnection();
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

	public List<FacultyPojo> searchAll() {
		openConnection();
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

	public FacultyPojo updateDataForDB(int id, String name, String email, long contact, String[] course) {
		openConnection();
		transaction.begin();
		FacultyPojo faculty = new FacultyPojo();
		faculty = manager.find(FacultyPojo.class, id);
		if (name != null)
			faculty.setName(name);
		if (contact != 0)
			faculty.setContact(contact);
		if (email != null)
			faculty.setEmail(email);
		String job = "";
		if (course != null) {
			for (String c : course) {
				job += c + " ";
				faculty.setJob(job);
			}
		}
		manager.persist(faculty);
		transaction.commit();
		closeConnection();
		return faculty;
	}

	public FacultyPojo remove(int id) {
		openConnection();
		transaction.begin();
		FacultyPojo faculty = new FacultyPojo();
		faculty = manager.find(FacultyPojo.class, id);
		if (faculty != null) {
			manager.remove(faculty);
			transaction.commit();
			closeConnection();
			return faculty;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public static List<FacultyPojo> getObject() {
		sql = "from FacultyPojo";
		query = manager.createQuery(sql);
		List<FacultyPojo> faculty = query.getResultList();
		return faculty;
	}

	public FacultyPojo loginfaculty(String username, String password) {
		openConnection();
		transaction.begin();

		sql = "from FacultyPojo where username = '" + username + "'and password = '" + password + "'";
		query = manager.createQuery(sql);
		List<FacultyPojo> list = query.getResultList();
		sql = "select id from FacultyPojo where username = '" + username + "'and password = '" + password + "'";
		query = manager.createQuery(sql);
		try {
			id = query.getSingleResult();
			for (FacultyPojo faculty : list) {
				transaction.commit();
				closeConnection();
				return faculty;
			}
		} catch (Exception e) {
			transaction.commit();
			closeConnection();
		}
		System.out.println(id + "+++++++++++++++++++++++");
		return null;
	}
}
