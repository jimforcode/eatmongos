package demo.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "regexPojo")
public class RegexPojo {

	private String filed1;
	private Integer field2;

	public String getFiled1() {
		return filed1;
	}

	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}

	public Integer getField2() {
		return field2;
	}

	public void setField2(Integer field2) {
		this.field2 = field2;
	}

	public RegexPojo(String filed1, Integer field2) {
		super();
		this.filed1 = filed1;
		this.field2 = field2;
	}

	public RegexPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegexPojo [filed1=" + filed1 + ", field2=" + field2 + "]";
	}

	
}
