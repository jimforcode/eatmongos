package jimndadai;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;

import demo.pojo.DistinctPojo;
import demo.pojo.DistinctPojo2;
import demo.pojo.ReportSubject;

public class DemoDistinct {
	public static void main(String[] args) throws UnknownHostException {

		MongoOperations template = new MongoTemplate(new Mongo(), "database");
		ReportSubject subject = ReportSubject.PROPOSAL;
		template.insert(new DistinctPojo2("f1", "f2", "f3", subject));
		template.insert(new DistinctPojo2("f11", "f2", "f3", subject));
		template.insert(new DistinctPojo2("f111", "f2", "f3", subject));
		template.insert(new DistinctPojo2("f1", "f2", "f3", subject));
		template.insert(new DistinctPojo2("f2", null, "f3", subject));
		// 1. 加条件
		List<String> result = template.getCollection("distinctPojo2").distinct(
				"field1",
				query(where("field2").ne(null).and("subject").is(subject))
						.getQueryObject());
		System.out.println(result);

		// 2,所有的
		List result2 = template.getCollection("distinctPojo2").distinct(
				"field1", new BasicDBObject());
		System.out.println(result2);
		template.dropCollection("distinctPojo2");
	}
}
