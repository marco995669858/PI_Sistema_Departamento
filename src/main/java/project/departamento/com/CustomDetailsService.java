//package project.departamento.com;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import project.departamento.com.entity.Usuario;
//import project.departamento.com.repository.LoginRepository;
//import project.departamento.com.service.LoginService;
//
//
//@Service
//public class CustomDetailsService implements UserDetailsService{
//
//	@Autowired
//	private LoginService service; 
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario user = service.buscarUsuario(username);
//		System.out.println(username);
//		if(user == null) {
//			throw new UsernameNotFoundException("No existe el Usuario");
//		}
//		System.out.println(user.getNomUsuario());
//		 System.out.println(user.getRol());
//		return new CustomDetailsServiceImpl(user);
//	}
//
//}
