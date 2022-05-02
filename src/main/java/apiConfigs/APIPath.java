package apiConfigs;

public class APIPath {
	
	public static final class apiPath {
		// GET
		public static final String GET_LIST_OF_POSTS = "posts";
		public static final String GET_SINGLE_OF_POST = "posts/1";
		
		// POST
//		public static final String CREATE_POST = "posts";
		public static final String CREATE_POST = "users";
		
		//DELETE
		public static final String DELETE_POST="posts";
		
		// USERS // for localhost - json-server no users available 
		// so using posts
//		public static final String GET_LIST_OF_USERS = "users";
		public static final String GET_LIST_OF_USERS = "posts";
		public static final String GET_SINGLE_OF_USER = "users/1";
		
		
		// 
	}
	

}
