package AutoCarman;

import org.springframework.stereotype.Component;

@Component
public class User {
	private int id;
	private String email;
	private String password;
	private String name;
	private String surname;
	private String secondname;

	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String email, String password, String name, String surname, String secondname) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.secondname = secondname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", secondname=" + secondname + "]";
	}

}
