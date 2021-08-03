package mx.com.gm.web;

import java.util.ArrayList;
import java.util.Arrays;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import lombok.*;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
public class ControllerInicio {
 @Autowired  
 //mwen fe yvon istancia avek interface ki gen implemete save delete listar
private PersonaServicio personaServicio;
    @GetMapping("/")
    
    public String inicio(Model model , @AuthenticationPrincipal User user) {
 var personas= personaServicio.findPersonas();
       // var personas = new ArrayList<>();
        //var personas= Arrays.asList(persona,persona2);
        model.addAttribute("personas", personas);
        return "index";
    }

    /**
     *
     * @param persona
     * @return
     */
    @GetMapping("/agregar")
    public String agregar(Persona persona){
    
        return "modificar";
    }
    
    //recuperar las personas que quieremos guardar
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona,Errors errores){
        if(errores.hasErrors()){   
          return "modificar";  
        }
        personaServicio.guardar(persona);
      return "redirect:/"; 
    }
    @GetMapping("/editar/{id_persona}")
    public String editar( Persona persona, Model model){
    persona=  personaServicio.encontrarPersona(persona);
       model.addAttribute("persona", persona);
       return "modificar";
    }

     @GetMapping("/eliminar/{id_persona}")
    public String eliminar( Persona persona){
    personaServicio.eliminar(persona);
       return "redirect:/";
    }
}
