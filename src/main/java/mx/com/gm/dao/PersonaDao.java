
package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

//este interface se encarga para el crud automatica
public interface PersonaDao extends CrudRepository <Persona,Long>{
    
}
