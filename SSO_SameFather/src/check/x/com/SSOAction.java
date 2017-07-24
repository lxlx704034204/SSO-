package check.x.com;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import check.x.com.util.SSOCheck;

import com.opensymphony.xwork2.ActionSupport;

public class SSOAction extends ActionSupport {

	private String username;
	private String password;
	private String gotourl;

	private String cookiename;
	private String cookieval;

	public String dologin() {
		// 同父域下的sso
		boolean ok = SSOCheck.checklogin(username, password);
		if (ok) {
			Cookie cookie = new Cookie("ssocookie", "sso");
			cookie.setDomain("x.com");// 把cookie设置到父域
			cookie.setPath("/");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);
			return SUCCESS;
		}
		return "login";
	}

	/*public void checkcookie() throws IOException {
		boolean ok = SSOCheck.checkcookie(cookiename, cookieval);
		String result = "0";
		if(ok){
			result = "1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();
	}*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGotourl() {
		return gotourl;
	}

	public void setGotourl(String gotourl) {
		this.gotourl = gotourl;
	}

	public String getCookiename() {
		return cookiename;
	}

	public void setCookiename(String cookiename) {
		this.cookiename = cookiename;
	}

	public String getCookieval() {
		return cookieval;
	}

	public void setCookieval(String cookieval) {
		this.cookieval = cookieval;
	}

	/*public String checkcookie() throws Exception {
		return "success";
	}*/

	public String checkcookie() throws IOException {
		boolean ok = SSOCheck.checkcookie(cookiename, cookieval);
		String result = "0";
		if(ok){
			result = "1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();
		return "";
	}
}
