package demo.pojo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "distinctPojo2")
public class DistinctPojo2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1830419892538978502L;
	private String field1;
	private String field2;
	private String field3;

	private ReportSubject subject;

	public DistinctPojo2(String field1, String field2, String field3,
			ReportSubject subject) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.subject = subject;
	}

	public ReportSubject getSubject() {
		return subject;
	}

	public void setSubject(ReportSubject subject) {
		this.subject = subject;
	}

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

	public DistinctPojo2(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public DistinctPojo2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DistinctPojo [field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + "]";
	}

}
