package Domain;

public class Usuario {

	private int id;
	private String userName;
	private String userPass;
	
	
	public Usuario() {
		
	}
	
	public Usuario(int id,String userName, String userPass) {
		
		this.id = id;
        this.userName = userName;
        this.userPass = userPass;
      
    }
	
	
	
  //Getters i Setters
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass= userPass;
	}
	
	
	
	@Override
	public String toString() {
		return "Usuario id:" + id + ", nombre:" + userName + ", password:" + userPass;
	}
}
