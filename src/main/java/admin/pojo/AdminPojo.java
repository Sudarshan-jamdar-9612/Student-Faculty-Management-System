package admin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;

import lombok.Data;

@Data
@Entity
@Table(name = "Admin",uniqueConstraints = @UniqueConstraint (name = "ukemail",columnNames = {"email"}))
public class AdminPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	@Email
	private String email;
}
