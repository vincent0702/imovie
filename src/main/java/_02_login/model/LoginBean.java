package _02_login.model;



public class LoginBean {
	String userId; 
	String password;
	String invalidCredentials;
	boolean rememberMe;
	
	public LoginBean() {
	}
	
	public LoginBean(String userId, String password, boolean rememberMe) {
		this.userId = userId;
		this.password = password;
		this.rememberMe = rememberMe;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getInvalidCredentials() {
		return invalidCredentials;
	}

	public void setInvalidCredentials(String invalidCredentials) {
		this.invalidCredentials = invalidCredentials;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginBean [userId=");
		builder.append(userId);
		builder.append(", password=");
		builder.append(password);
		builder.append(", rememberMe=");
		builder.append(rememberMe);
		builder.append("]");
		return builder.toString();
	}
	
	
}
