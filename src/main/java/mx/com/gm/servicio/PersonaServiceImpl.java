
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaServicio{
@Autowired
//mwen fe yon istancia aven interface ki gen crud la
    private PersonaDao personaDao;
    @Override
   @Transactional(readOnly = true)
    public List<Persona> findPersonas() {
    return  (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void update(Persona persona) {

        }

    @Override
    @Transactional(readOnly = true)

    public Persona encontrarPersona(Persona persona) {
return personaDao.findById(persona.getId_persona()).orElse(null);
    }

    @Override
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }
    
}
