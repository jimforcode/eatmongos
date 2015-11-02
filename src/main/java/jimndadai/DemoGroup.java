package jimndadai;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;

import com.mongodb.Mongo;

import demo.pojo.GroupPojo;
import demo.pojo.SubGroupPojo;

/*
 *
 @see http://docs.spring.io/spring-data/data-mongo/docs/1.8.0.M1/reference/html/#mongo.group
 * 
 */
public class DemoGroup {
	public static void main(String[] args) throws UnknownHostException {
		MongoOperations template = new MongoTemplate(new Mongo(), "database");

		List<SubGroupPojo> subGroup1 = new ArrayList<SubGroupPojo>();
		subGroup1.add(new SubGroupPojo("s1", 1));
		subGroup1.add(new SubGroupPojo("s2", 1));
		List<SubGroupPojo> subGroup2 = new ArrayList<SubGroupPojo>();
		subGroup2.add(new SubGroupPojo("s11", 1));
		subGroup2.add(new SubGroupPojo("s22", 1));
		List<SubGroupPojo> subGroup3 = new ArrayList<SubGroupPojo>();
		subGroup3.add(new SubGroupPojo("s111", 1));
		subGroup3.add(new SubGroupPojo("s222", 1));
		List<SubGroupPojo> subGroup4 = new ArrayList<SubGroupPojo>();
		subGroup4.add(new SubGroupPojo("s1111", 1));
		subGroup4.add(new SubGroupPojo("s2222", 1));
		List<SubGroupPojo> subGroup5 = new ArrayList<SubGroupPojo>();
		subGroup5.add(new SubGroupPojo("s1111", 1));
		subGroup5.add(new SubGroupPojo("s22222", 1));

		template.insert(new GroupPojo("f1", "f2", "f3", subGroup1, 1));
		template.insert(new GroupPojo("f1", "f22", "f33", subGroup2, 1));
		template.insert(new GroupPojo("f1", "f22", "f3", subGroup3, 1));
		template.insert(new GroupPojo("f1", "f2", "f3", subGroup4, 1));
		template.insert(new GroupPojo("f1", "f2", "f3", subGroup5, 1));

		GroupByResults<GroupPojo> results = template
				.group(where("field1").is("f1"),
						"groupPojo",
						GroupBy.key("field1", "field2")
								.initialDocument("{ num: 0 }")
								.reduceFunction(
										"function(doc, prev) { prev.num += 1 }"),
						GroupPojo.class);

		// 符合分组的数目
		System.out.println(results.getKeys());
		// 记录总数
		System.out.println(results.getCount());
		Iterator<GroupPojo> ite = results.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.println("serverUsed:" + results.getServerUsed());
		System.out.println("rawResults" + results.getRawResults());
		System.out.println("rawResults" + results.getRawResults().keySet());
		System.out
				.println("rawResults" + results.getRawResults().get("retval"));
		template.dropCollection("groupPojo");
	}


}
