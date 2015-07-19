package jimndadai;

import org.springframework.data.mongodb.core.MongoOperations;

public class Base<T> {
	public static void drop(MongoOperations template) {
		template.dropCollection(Object.class);
	}

}
