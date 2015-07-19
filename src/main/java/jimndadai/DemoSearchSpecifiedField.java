package jimndadai;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.Bytes;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import demo.pojo.SearchSpecifiedFieldPojo;

public class DemoSearchSpecifiedField extends Base<SearchSpecifiedFieldPojo> {
	public static void main(String[] args) throws UnknownHostException,
			InstantiationException, IllegalAccessException {

		MongoOperations template = new MongoTemplate(new Mongo(), "database");

		template.insert(new SearchSpecifiedFieldPojo("f1", "f2"));
		template.insert(new SearchSpecifiedFieldPojo("f1", "f2"));
		template.insert(new SearchSpecifiedFieldPojo("f11", "f22"));
		template.insert(new SearchSpecifiedFieldPojo("f111", "f222"));

		BasicDBObject keys = new BasicDBObject();
		keys.put("field1", 1);
		DBCursor cursor = template.getCollection("searchSpecifiedField")
				.find(query(where("field1").is("f1")).getQueryObject(), keys)
				.addOption(Bytes.QUERYOPTION_NOTIMEOUT);

		System.out.println(cursor);
		System.out.println(cursor.toArray());
		List<DBObject> r = cursor.toArray();

		for (DBObject o : r) {
			System.out.println(o.get("field1"));
		}
		template.dropCollection(SearchSpecifiedFieldPojo.class);

	}

}
