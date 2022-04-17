package project.departamento.com.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptPasswordImpl implements EncryptPassword{
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public String Encriptar(String Password) {
	
		String p ="";
		return encoder.encode(Password);
	}

	@Override
	public boolean VerificarPassword(String PassRaw, String HashPassword) {
		
		return encoder.matches(PassRaw, HashPassword);
	}
 
}
