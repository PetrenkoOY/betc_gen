package betc_generator.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import betc_generator.utill.Utill;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private Date created;

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date(System.currentTimeMillis());
	}
	public static User getRandomUser() {
		String firstName = Utill.nextRandomString(Utill.getRandomIntInRange(4, 10));
				String lastName = Utill.nextRandomString(Utill.getRandomIntInRange(4, 10));
		return new User(firstName, lastName);
	}
}
