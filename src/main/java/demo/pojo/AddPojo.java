package demo.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "demoAdd")
public class AddPojo {
	private String name;
	private Integer age;

	public AddPojo(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "A [name=" + name + ", age=" + age + "]";
	}

}
