package demo1.x.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//先校验cookie的有效性  再校验登录
public class Demo1Action extends ActionSupport{

	private String gotourl;

	public String main(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("ssocookie")&&
						cookie.getValue().equals("sso")){
					String result = doget("http://check.x.com:8080/sso/checkcookie.action",
							cookie.getName(), cookie.getValue());
					if(result.equals("1")){
						return SUCCESS;
					}
				}
			}
		}
		gotourl = "http://demo1.x.com:8080/demo1/main.action";
		return "login";
	}


	public String getGotourl() {
		return gotourl;
	}
	public void setGotourl(String gotourl) {
		this.gotourl = gotourl;
	}
	
	public String doget(String url,String cname,String cval){
		HttpURLConnection httpURLConnection = null;
		StringBuffer sb = new StringBuffer();
		try{
			URL urls =new URL(url+"?cookiename="+cname+"&cookieval="+cval);
			httpURLConnection = (HttpURLConnection) urls.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();
			InputStream in  =  httpURLConnection.getInputStream();
			InputStreamReader is= new InputStreamReader(in);
			BufferedReader br = new BufferedReader(is);
			String temp = null;
			while((temp=br.readLine())!=null){
				sb.append(temp);
			}
			br.close();
			is.close();
			in.close();
			
		}catch (IOException c) {
			// TODO: handle exception
		}finally{
			if(httpURLConnection!=null){
				httpURLConnection.disconnect();
			}
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
