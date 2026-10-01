public class Loginvalidation {
	static void validatelogin(String username, String password) {
		if(!username.equals("admin")|| !password.equals("1234")) {
			throw new SecurityException("invalid username");
		}else {
			System.out.println("login successfull");
		}
	}
	public static void main(String[] arsg) {
		validatelogin("admin","1111");
//		validatelogin("admin","1234");
	}
}
