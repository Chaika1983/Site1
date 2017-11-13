package AutoCarman;

public class Validator {
	private int id;
	private String email;
	private String password;
	private String rePassword;
	private String name;
	private String surname;
	private String secondname;
	private boolean success;
	private boolean reg;
	
	private String errorEmail;
	private String errorPassword;
	private String errorRepassword;
	private String errorName;
	private String errorSurname;
	private String errorSecondname;
	public Chek chek = new Chek();
	public Connector con = new Connector();
	
	public Validator(){}
	
	public Validator(String email, String password) {
		this.email = email;
		this.password = password;
	}	
	

	public Validator(String email, String password, String rePassword, String name, String surname,
			String secondname) {
		this.email = email;
		this.password = password;
		this.rePassword = rePassword;
		this.name = name;
		this.surname = surname;
		this.secondname = secondname;
	}
	

	public int getId() {
		if(getAutorization() || getRegistration()) {
			id = con.getNum();
		}
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

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
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

	public String getErrorEmail() {
		errorEmail="";
		if(!chek.getExistEmail(getEmail())) {
			errorEmail="This email is exist!";
		}
		if(!chek.getEmail(getEmail())) {
			errorEmail="This email is not corect!";
		}
		if(!chek.getNullEmail(getEmail())) {
			errorEmail="Email can not be empty!";
		}
		return errorEmail;
	}

	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}

	public String getErrorPassword() {
		errorPassword = "";
		if(!chek.getNullPassword(getPassword())) {
			errorPassword = "Password can not be empty!";
		}
		if(!chek.getBigPassword(getPassword())){
			errorPassword = "Password can not be longer than 18 characters!";
		}
		if(!chek.getMiniPassword(getPassword())) {
			errorPassword = "Password can not be less than 8 characters!";
		}else {
			errorPassword="ok";
		}
		return errorPassword;
	}

	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}

	public String getErrorRepassword() {
		errorRepassword = "";
		if(!password.equals(getRePassword())) {
			errorRepassword = "Password does not match!";
		}
		if(!chek.getNullRePassword(getRePassword())) {
			errorRepassword = "Repassword can not be empty!!";
		}
		return errorRepassword;
	}

	public void setErrorRepassword(String errorRepassword) {
		this.errorRepassword = errorRepassword;
	}

	public String getErrorName() {
		errorName = "";
		if(!chek.getNullName(getName())) {
			errorName = "Name can not be empty!";
		}
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public String getErrorSurname() {
		errorSurname = "";
		if(!chek.getNullSurName(getSurname())) {
			errorSurname = "Surname can not be empty!";
		}
		return errorSurname;
	}

	public void setErrorSurname(String errorSurname) {
		this.errorSurname = errorSurname;
	}

	public String getErrorSecondname() {
		errorSecondname = "";
		if(!chek.getNullsecondName(getSecondname())) {
			errorSecondname ="Secondname can not be empty!";
		}
		return errorSecondname;
	}

	public void setErrorSecondname(String errorSecondname) {
		this.errorSecondname = errorSecondname;
	}

	public boolean getAutorization() {
		success = con.getLogin(email, password);
		return success;
	}

	public boolean getRegistration() {
		if(chek.getEmail(getEmail()) && chek.getExistEmail(getEmail()) && chek.getNullEmail(getEmail()) && 
				chek.getNullPassword(getPassword()) && chek.getBigPassword(getPassword()) && 
				chek.getMiniPassword(getPassword()) && chek.getNullName(getName()) && chek.getNullSurName(getSurname())
				&& chek.getNullsecondName(getSecondname())) {
			reg = con.getRegistration(getEmail(), getPassword(), getName(), getSurname(), getSecondname());
		}
		
		return reg;

	}
}
