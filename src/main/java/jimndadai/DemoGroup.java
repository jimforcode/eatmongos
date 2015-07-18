package jimndadai;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import demo.pojo.GroupPojo;

/*
 *
 @see http://docs.spring.io/spring-data/data-mongo/docs/1.8.0.M1/reference/html/#mongo.group
 * 
 */
public class DemoGroup {
	public static void main(String[] args) throws UnknownHostException {
		MongoOperations template = new MongoTemplate(new Mongo(), "database");
		template.insert(new GroupPojo("f1", "f2", "f3", 1));
		template.insert(new GroupPojo("f1", "f22", "f33", 1));
		template.insert(new GroupPojo("f1", "f22", "f3", 1));
		template.insert(new GroupPojo("f1", "f2", "f3", 1));
		template.insert(new GroupPojo("f1", "f2", "f3", 1));

		template.dropCollection("groupPojo");
	}
}
