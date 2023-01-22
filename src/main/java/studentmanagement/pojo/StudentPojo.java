package studentmanagement.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;

import lombok.Data;
@Entity
@Data
@Table(name = "StudentDetails",
				uniqueConstraints = {
						@UniqueConstraint(name = "uniqueness",columnNames = "StudentEmailID")
						})
public class StudentPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "StudentName")
	private String name;
	@Email
	@Column(name = "StudentEmailID")
	private String email;
	@Column(name = "StudentContact")
	private long contact;
	@Column(name = "StudentUsername")
	private String username;
	@Column(name = "StudentPassword")
	private String password;
	@Column(name="Course")
	private String course;
	@Column(name = "JavaRating")
	private String java;
	@Column(name = "SQLRating")
	private String sql;
	@Column(name = "Web_TechRating")
	private String web;
	@Column(name = "PythonRating")
	private String python;
}
