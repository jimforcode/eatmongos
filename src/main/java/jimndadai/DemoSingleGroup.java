package jimndadai;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;

import com.mongodb.DBObject;
import com.mongodb.Mongo;

import demo.pojo.Color;
import demo.pojo.SingleGroupPojo;

public class DemoSingleGroup {
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
						GroupBy.key("field2", "color")
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

		System.out.println("serverUsed:" + results.getServerUsed());
		System.out.println("rawResults" + results.getRawResults());
		System.out.println("rawResults" + results.getRawResults().keySet());
		System.out
				.println("rawResults" + results.getRawResults().get("retval"));
		template.dropCollection("singleGroupPojo");
		System.out.println("----------------------------------------");

		Object obj = results.getRawResults().get("retval");

		System.out.println(obj);

	}
}
