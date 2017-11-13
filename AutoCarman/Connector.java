package AutoCarman;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connector {
	private int num = 0;
	private MessageDigest md5 = null;
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private List<Products> products;
	private List<Category> categories;
	private String url = "jdbc:mysql://localhost/autocarman";

	public Connector() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, "root", "");
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String toMD5(String password) {
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return new BigInteger(1, md5.digest()).toString(16);
	}

	public boolean getLogin(String email, String password) {
		try {
			ps = conn.prepareStatement("SELECT id,email,password FROM users WHERE email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, toMD5(password));
			rs = ps.executeQuery();
			if (rs.next()) {
				num = rs.getInt("id");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getUser(int id) {
		User user = null;
		try {
			ps = conn.prepareStatement("SELECT*FROM users WHERE id='" + id + "'");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("name"),
						rs.getString("surname"), rs.getString("secondname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean getEmail(String email) {
		try {
			ps = conn.prepareStatement("SELECT email FROM users WHERE email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (!rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getRegistration(String email, String password, String name, String surname, String secondname) {
		try {
			ps = conn.prepareStatement("SELECT email FROM users WHERE email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (!rs.next()) {
				ps = conn.prepareStatement(
						"INSERT INTO users (email,password,name,surname,secondname) VALUES(?,?,?,?,?)");
				ps.setString(1, email);
				ps.setString(2, toMD5(password));
				ps.setString(3, name);
				ps.setString(4, surname);
				ps.setString(5, secondname);
				ps.execute();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean getProfile(String rename, String resurname, String resecondname,int id) {
		try {
			ps = conn.prepareStatement("UPDATE users SET name =?, surname =?, secondname =? WHERE id=?");
			ps.setString(1, rename);
			ps.setString(2, resurname);
			ps.setString(3, resecondname);
			ps.setInt(4, id);
			ps.execute();
			if (ps.execute()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Category> getCategory() {
		try {
			ps = conn.prepareStatement("SELECT * FROM category");
			rs = ps.executeQuery();
			categories = new ArrayList<Category>();
			while (rs.next()) {
				categories.add(new Category(rs.getInt("id"), rs.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	public List<Products> getProducts(String id) {
		try {
			ps = conn.prepareStatement("SELECT id, name, price FROM products WHERE categoryId=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			products = new ArrayList<Products>();

			while (rs.next()) {
				products.add(new Products(rs.getInt("id"), rs.getString("name"), rs.getInt("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void closeConnector() {
		try {
			conn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
