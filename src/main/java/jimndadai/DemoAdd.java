package jimndadai;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import demo.pojo.AddPojo;

public class DemoAdd {

	public static void main(String[] args) throws UnknownHostException {
		MongoOperations template = new MongoTemplate(new Mongo(), "database");
		template.insert(new AddPojo("jim", 25));
		AddPojo a = template.findOne(query(where("name").is("jim")),
				AddPojo.class);
		System.out.println(a);
		template.dropCollection("demoAdd");
	}
}
