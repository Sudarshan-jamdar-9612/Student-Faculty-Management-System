package facultymanagement.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
@Table(name = "FacultyDetails",
		uniqueConstraints = @UniqueConstraint(name = "Uniquemail" ,columnNames = "Facuty_Email")
		)
public class FacultyPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "Faculty_Name")
	private String name;
	@Column(name = "Facuty_Email")
	private String email;
	@Column(name = "Faculty_Contact")
	private long contact;
	@Column(name = "Faculty_Subject")
	private String job;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
}
