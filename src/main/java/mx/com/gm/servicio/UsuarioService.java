
package mx.com.gm.servicio;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import lombok.*;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Usuario;
import mx.com.gm.domain.rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("userDetailsService")
public class UsuarioService  implements  UserDetailsService{
    @Autowired
 private UsuarioDao usuarioDao;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario usuario=usuarioDao.findByUsername(username);
      
       if(usuario == null){
           throw new UsernameNotFoundException(username);
       } 
           var Roles= new ArrayList<GrantedAuthority>();
           for (rol Rol: usuario.getRoles()){
            
           Roles.add( new SimpleGrantedAuthority(Rol.getNombre()));  
           }
       return new User(usuario.getUsername(),usuario.getPassword(),Roles);
    }
    
}
