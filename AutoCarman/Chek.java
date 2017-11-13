package AutoCarman;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chek {
	private boolean godEmail;

	public boolean getEmail(String email) {
		Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
		Matcher matcher = pattern.matcher(email);
		godEmail = matcher.matches();
		return godEmail;
	}
	public boolean getNullEmail(String email) {
		if(email.isEmpty()) {
			return false;			
		}
		return true;
	}
	public boolean getExistEmail(String email) {
		Connector con = new Connector();
		if(con.getEmail(email)==false) {
			return false;			
		}
		con.closeConnector();
		return true;
	}

	public boolean getMiniPassword(String password) {
		if(password.length()<8) {
			return false;			
		}
		return true;
	}
	public boolean getBigPassword(String password) {
		if(password.length()>18) {
			return false;			
		}
		return true;
	}
	public boolean getNullPassword(String password) {
		if(password.isEmpty()) {
			return false;			
		}
		return true;
	}
	public boolean getNullRePassword(String password) {
		if(password.isEmpty()) {
			return false;			
		}
		return true;
	}
	public boolean getNullName(String name) {
		if(name.isEmpty()) {
			return false;			
		}
		return true;
	}
	public boolean getNullSurName(String surname) {
		if(surname.isEmpty()) {
			return false;			
		}
		return true;
	}
	public boolean getNullsecondName(String name) {
		if(name.isEmpty()) {
			return false;			
		}
		return true;
	}
	

}
