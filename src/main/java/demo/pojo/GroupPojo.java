package demo.pojo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "groupPojo")
public class GroupPojo {
	private String field1;
	private String field2;
	private String field3;

	
	
	private List<SubGroupPojo> subGroup;

	// 用户统计条数
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

	public List<SubGroupPojo> getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(List<SubGroupPojo> subGroup) {
		this.subGroup = subGroup;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public GroupPojo(String field1, String field2, String field3,
			List<SubGroupPojo> subGroup, int num) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.subGroup = subGroup;
		this.num = num;
	}

	public GroupPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GroupPojo [field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + ", subGroup=" + subGroup + ", num="
				+ num + "]";
	}

}
