package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilder {
	public Map<String, String> postRequestBody() {
		Map<String, String> body = new HashMap<String, String>();
		body.put("id", "19");
		body.put("first_name", "Name19");
		body.put("subjectId", "1");
		return body;

	}

}
