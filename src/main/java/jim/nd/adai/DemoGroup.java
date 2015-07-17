package jim.nd.adai;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import demo.pojo.GroupPojo;

public class DemoGroup {
	public static void main(String[] args) throws UnknownHostException {
		MongoOperations template = new MongoTemplate(new Mongo(), "database");
		template.insert(new GroupPojo("f","f","f",1));
		
		template.dropCollection("groupPojo");
	}
}
