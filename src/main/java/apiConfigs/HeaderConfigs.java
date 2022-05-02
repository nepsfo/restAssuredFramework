package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {
	@SuppressWarnings("serial")
	public Map<String,String> defaultHeaders() {
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		
		/*
		 * new HashMap<String, String>(){{ put("Content-Type", "application/json"); }};
		 */
		/*
		 * return new HashMap<String, String>(){{ put("Content-Type",
		 * "application/json"); }};
		 */ 
		return defaultHeaders;
	}

	
	public Map<String, String> headersWithToken(){
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Access_Token", "adjkljsdfaljslakdfjlk");
		defaultHeaders.put("jwt_token", "asjdflkajsfdljlajkljklj");
		defaultHeaders.put("Tenet_user", "test");
		return defaultHeaders;
	}
	
	
}
