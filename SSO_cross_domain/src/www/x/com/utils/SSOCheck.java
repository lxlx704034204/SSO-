package www.x.com.utils;


public class SSOCheck {

	public static boolean checklogin(String username, String password) {
		if (username.equals("123") && password.equals("123")) {
			return true;
		}
		return false;
	}

	public static boolean checkcookie(String cookiename, String cookieval) {
		if (cookiename.equals("ssocookie") && cookieval.equals("sso")) {
			return true;
		}
		return false;
	}
}
