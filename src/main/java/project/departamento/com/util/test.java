package project.departamento.com.util;

public class test {
	public static void main(String arg[]) {
		EncryptPasswordImpl service = new EncryptPasswordImpl();
		
		String hash = "$2a$10$giN96rXkbZ/hFH6/OggRQeOeRmYExHmDqy..5ROXVIswahRpp0Fa2";
		
		String pass = "23Asdff";
		
		/*Usuario es unico*/
		
		/**/
		System.out.println(service.VerificarPassword(pass, hash));
		
	}
}
