package demo.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "groupPojo")
public class GroupPojo {
	private String field1;
	private String field2;
	private String field3;
	// �û�ͳ������
	private int num;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public GroupPojo() {
		// TODO Auto-generated constructor stub
	}

	public GroupPojo(String field1, String field2, String field3, int num) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.num = num;
	}

	@Override
	public String toString() {
		return "GroupPojo [field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + ", num=" + num + "]";
	}

}
