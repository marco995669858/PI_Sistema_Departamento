package project.departamento.com.util;

import java.util.Date;

public class test {
	public static void main(String arg[]) {
		EncryptPasswordImpl service = new EncryptPasswordImpl();
		
		String hash = "$2a$10$ljH85k2alh0gIFj9qAcnC.H8sczhH2.7e4dP..5lpYJe9K/dvEoIu";
		
		String pass = "5895Asdf";
		
		/*Usuario es unico*/
		
		/**/
		System.out.println(service.VerificarPassword(pass,hash));
		
	}
}
