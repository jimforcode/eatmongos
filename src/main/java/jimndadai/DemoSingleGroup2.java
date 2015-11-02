package jimndadai;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;

import com.mongodb.Mongo;

import demo.pojo.Color;
import demo.pojo.SingleGroupPojo;

public class DemoSingleGroup2 {
	public static void main(String[] args) throws UnknownHostException {
		MongoOperations template = new MongoTemplate(new Mongo(), "database");

		template.insert(new SingleGroupPojo("1", "f1", "f2", "f3", Color.RED));
		template.insert(new SingleGroupPojo("1", "f1", "f2", "f3", Color.YELLOW));
		template.insert(new SingleGroupPojo("1", "f1", "f2", "f3", Color.YELLOW));
		template.insert(new SingleGroupPojo("1", "f1", "f2", "f3", Color.YELLOW));
		template.insert(new SingleGroupPojo("1", "f2", "f2", "f3", Color.YELLOW));
		template.insert(new SingleGroupPojo("1", "f2", "f2", "f3", Color.RED));
		template.insert(new SingleGroupPojo("1", "f2", "f2", "f3", Color.RED));
		template.insert(new SingleGroupPojo("1", "f2", "f2", "f3", Color.RED));
		template.insert(new SingleGroupPojo("1", "f2", "f2", "f3", Color.GREEN));
		template.insert(new SingleGroupPojo("1", "f2", "f2", "f3", Color.WHITE));

		GroupByResults<SingleGroupPojo> results = template
				.group(null,
						"singleGroupPojo",
						GroupBy.key("field2")
								.initialDocument("{ num: 0 }")
								.reduceFunction(
										"function(doc, prev) { prev.num += 1 }"),
						SingleGroupPojo.class);

		// 符合分组的数目
		System.out.println(results.getKeys());
		// 记录总数
		System.out.println(results.getCount());
		Iterator<SingleGroupPojo> ite = results.iterator();
		while (ite.hasNext()) {

			System.out.println(ite.next());
		}

		Object obj = results.getRawResults().get("retval");

		System.out.println(obj);
		JSONArray jsonArray = JSONArray.fromObject(obj.toString());
		Object[] objArr = jsonArray.toArray();
		List<Pojo> list = new ArrayList<Pojo>();
		for (int i = 0; i < objArr.length; i++) {
			JSONObject j = (JSONObject) objArr[i];
			Pojo p = new Pojo();
			p.setField2(j.getString("field2"));
			p.setNum(j.getString("num"));

			System.out.println(p);
			// onlineSchoolList.add(online);
		}

	}

	static class Pojo {

		private String field2;
		private String color;
		private String num;

		public Pojo() {
			super();
		}

		public String getField2() {
			return field2;
		}

		public void setField2(String field2) {
			this.field2 = field2;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getNum() {
			return num;
		}

		public void setNum(String num) {
			this.num = num;
		}

		@Override
		public String toString() {
			return "Pojo [field2=" + field2 + ", color=" + color + ", num="
					+ num + "]";
		}

	}

}
