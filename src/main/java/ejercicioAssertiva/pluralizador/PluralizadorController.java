package ejercicioAssertiva.pluralizador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PluralizadorController {

    //@Autowired
    // private PluralizadorController pluralizadorController;

    @PostMapping("/pluralizar")   
    public ArrayList postPluralizarPalabras(@RequestBody Palabras body ) {
        String[] palabras = body.getPalabras();
        return PluralizadorService.pluralizador(palabras);
    }
}
