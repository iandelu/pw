package model.data;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Email implements Serializable{

	private String email;

	public Email(String email) throws Exception {
		this.comprobarValidezEmail(email);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void comprobarValidezEmail(String email) throws Exception
    {
		
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";                            
        Pattern patronEmail = Pattern.compile(emailRegex);
        if (email == null)
            throw new Exception();
         if(!patronEmail.matcher(email).matches())throw new Exception();
        
    }
	
}
