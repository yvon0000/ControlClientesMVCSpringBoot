
package mx.com.gm.util;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncriptarPassword {
    public static void main(String args[]){
        var password="123";  
        System.out.println("passwor :" + password);
        System.out.println("passwor encorder :" + encriptarPassword (password));
    }
      public  static String encriptarPassword(String password ){
          BCryptPasswordEncoder encoder= new  BCryptPasswordEncoder();
            return encoder.encode(password);
            
        }
}
