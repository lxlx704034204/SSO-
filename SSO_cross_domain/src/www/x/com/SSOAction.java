package www.x.com;

import www.x.com.utils.SSOCheck;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SSOAction extends ActionSupport {

	private String username;
	private String password;
	private String gotourl;

	private String cookiename;
	private String cookieval;

	/*public void dologin() throws IOException {
		boolean ok = SSOCheck.checklogin(username, password);
		String result="0";
		if (ok) {
			result="1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();
	}*/

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

	public String checkcookie() throws IOException {
		boolean ok = SSOCheck.checkcookie(cookiename, cookieval);
		String result = "0";
		// 存储cookie 跨域的话，就不能在此处setCookie了！！！：因为在此处设置的cookie是属于.x.com域的cookie，没有意义！
		//so，只能在各自的子action中设置各自的cookie！！！：相当于a、b两人在街上逛街，a突然看到个很喜欢的东西想买，但下一刻发现没带钱和银行卡，但b也只有银行卡，此时b不可能把卡和卡的密码都给a！a可以请b帮忙付钱！
		if(ok){
			result = "1";
		}	//服务器间通信以IO的形式返回(只提供功能，不提供页面)，没有return!!!
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();
		return "success";
	}

	public String dologin() throws IOException {
		boolean ok = SSOCheck.checklogin(username, password);
		String result="0";
		if (ok) {
			result="1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();
		return "success";
	}
}
