package jimndadai;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.net.UnknownHostException;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import demo.pojo.RegexPojo;

public class DemoRegex {

	public static void main(String[] args) throws UnknownHostException {

		MongoOperations template = new MongoTemplate(new Mongo(), "database");
		// /.*m.*/
		template.insert(new RegexPojo("an", 1));
		template.insert(new RegexPojo("nab", 1));
		template.insert(new RegexPojo("nba", 1));
		template.insert(new RegexPojo("banb", 1));

		// Pattern pattern = Pattern.compile("^.*\\" + "a" + ".*$",
		// Pattern.CASE_INSENSITIVE);

		Pattern pattern = Pattern.compile("^.*" + "n" + ".*$",
				Pattern.CASE_INSENSITIVE);

		List<RegexPojo> rex = template.find(query(where("filed1")
				.regex(pattern)), RegexPojo.class);

		System.out.println(rex);
		template.dropCollection("regexPojo");

	}

}
