package jimndadai;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import demo.pojo.AddPojo;

public class DemoAdd {

	public static void main(String[] args) throws UnknownHostException {
		MongoOperations template = new MongoTemplate(new Mongo(), "database");
		template.insert(new AddPojo("jim", 25));
		template.insert(new AddPojo("jim", 25));
		AddPojo a = template.findOne(query(where("name").is("jim")),
				AddPojo.class);
		System.out.println(a);

		List<AddPojo> b = template.find(query(where("name").is("jm")),
				AddPojo.class);
		System.out.println(b);

		for (AddPojo add : b) {
			System.out.println(add.getName());
		}

		template.dropCollection("demoAdd");

		AddPojo exist = template.findOne(query(where("name").is("j")),
				AddPojo.class);
		System.out.println(exist == null);

	}
}
