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

public class DemoDistinct {
	public static void main(String[] args) throws UnknownHostException {

		MongoOperations template = new MongoTemplate(new Mongo(), "database");
		template.insert(new DistinctPojo("f1", "f2", "f3"));
		template.insert(new DistinctPojo("f1", "f2", "f3"));
		template.insert(new DistinctPojo("f1", "f2", "f3"));
		template.insert(new DistinctPojo("f1", "f2", "f3"));
		template.insert(new DistinctPojo("f2", null, "f3"));
		// 1. 加条件
		List result = template.getCollection("distinctPojo").distinct("field1",
				query(where("field2").ne(null)).getQueryObject());
		System.out.println(result);

		// 2,所有的
		List result2 = template.getCollection("distinctPojo").distinct(
				"field1", new BasicDBObject());
		System.out.println(result2);
		template.dropCollection("distinctPojo");
	}
}
