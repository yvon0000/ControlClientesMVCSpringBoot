
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Persona;


public interface PersonaServicio {
    //metodo para crud 
    
   public List<Persona> findPersonas();
   
    
    public void guardar(Persona persona);
    
        public void eliminar(Persona persona);

    
    public void update(Persona persona);
    
    
    public Persona encontrarPersona(Persona persona);
   
}
