package utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class PracParse {
	public static void parseObject(JSONObject json, String key) {
		System.out.println(key+ " : "+ json.has(key));
		System.out.println("Print Value: "+ json.get(key));
	}
	
	public static void getKey(JSONObject json, String key) {
		// check exist
		Boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;
		
		if(!exists) {
			keys=json.keys();
			while(keys.hasNext()) {
				nextKeys = (String) keys.next();
				
				try {
					if(json.get(nextKeys) instanceof JSONObject) {
						if(exists == false) {
							System.out.println(key+ " :$ "+ json.has(key));
							System.out.println("Print Value: "+ json.get(key));
							getKey(json.getJSONObject(nextKeys), key);
						}
					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonArray = json.getJSONArray(nextKeys);
						for (int i=0; i < jsonArray.length(); i++) {
							String jsonArrayString = jsonArray.get(i).toString();
							JSONObject innerJSON = new JSONObject(jsonArrayString);
							if( exists == false ) {
								getKey(innerJSON, key);
							}
						}
						
					} 
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
		} else {
			parseObject(json, key);
		}
		
	}
		
		
	public static void main(String[] args) {

			String inputJson = "{\n" + 
					"  \"myObjects\": [\n" + 
					"    {\n" + 
					"      \"code\": \"PQ\",\n" + 
					"      \"another_objects\": [\n" + 
					"        {\n" + 
					"          \"attr1\": \"value1\",\n" + 
					"          \"attr2\": \"value2\",\n" + 
					"          \"attrN\": \"valueN\"\n" + 
					"        },\n" + 
					"        {\n" + 
					"          \"attr1\": \"value1\",\n" + 
					"          \"attr2\": \"value2\",\n" + 
					"          \"attrN\": \"valueN\"\n" + 
					"        },\n" + 
					"        {\n" + 
					"          \"attr1\": \"value1\",\n" + 
					"          \"attr2\": \"value2\",\n" + 
					"          \"attrN\": \"valueN\",\n" + 
					"          \"attrXX\": \"valueXX\"\n" + 

					"        }\n" + 
					
					"      ]\n" + 
					"    }\n" + 
					"  ]\n" + 
					"}";
			JSONObject inputJSONOBject = new JSONObject(inputJson);

			System.out.println("JSON Input: "+inputJSONOBject.toString(4));
			
			getKey(inputJSONOBject, "attr1");
			getKey(inputJSONOBject, "myObjects");
			
			getKey(inputJSONOBject, "attrN");
			getKey(inputJSONOBject, "attrXX");
			getKey(inputJSONOBject, "attrYX");



		}
	
	

}
