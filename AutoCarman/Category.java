package AutoCarman;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Category {
	private int id;
	private String name;
	private List<String> list;

	public Category() {
	}

	public Category(int id) {
		this.id = id;
	}

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Category(List<String> list) {
		this.list = list;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", list=" + list + "]";
	}

}
