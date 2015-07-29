package demo.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subGroupPojo")
public class SubGroupPojo {

	private String name;
	private int totalSub;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSub() {
		return totalSub;
	}

	public void setTotalSub(int totalSub) {
		this.totalSub = totalSub;
	}

	public SubGroupPojo(String name, int totalSub) {
		super();
		this.name = name;
		this.totalSub = totalSub;
	}

	public SubGroupPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SubGroupPojo [name=" + name + ", totalSub=" + totalSub + "]";
	}

}
