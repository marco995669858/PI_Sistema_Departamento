package project.departamento.com.util;

public interface EncryptPassword {
	
	String Encriptar(String Password);
	
	boolean VerificarPassword(String OriginalPassword, String HashPassword);
}
