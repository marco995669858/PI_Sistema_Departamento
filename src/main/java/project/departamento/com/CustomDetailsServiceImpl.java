//package project.departamento.com;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import project.departamento.com.entity.Usuario;
//
// 
//public class CustomDetailsServiceImpl implements UserDetails{
//
// 
//	private Usuario user;
//	
//	public CustomDetailsServiceImpl(Usuario user) {
//		super();
//		this.user = user;
// 
//	}
//	
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//	 
//		return Collections.singleton(new SimpleGrantedAuthority(user.getRol().getDescripcion()));
//		
//		
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return user.getPasswordUsuario();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return user.getCuentaUsuario();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
