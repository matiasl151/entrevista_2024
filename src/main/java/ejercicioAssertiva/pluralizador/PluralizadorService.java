package ejercicioAssertiva.pluralizador;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class PluralizadorService {
    
    public static ArrayList pluralizador(String[] palabras) {
        String[] plurales = new String[palabras.length];

        for (String palabra : palabras) {
            if (noAplicable(palabra)) {
                System.err.println("Error: No puede contener un numero o caracter especial - " + palabra);
                System.exit(1); // Exit with an error code
            }
        }

        int[] cantidadesPorRegla = new int[4];
        

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i].toLowerCase(); // Convertir a minúsculas
            int reglaAplicada = aplicarRegla(palabra);
            cantidadesPorRegla[reglaAplicada]++;

            switch (reglaAplicada) {
                case 0:
                    plurales[i] = palabra + "s";
                    break;
                case 2:
                    plurales[i] = palabra.substring(0, palabra.length() - 1) + "ces";
                    break;
                case 3:
                    plurales[i] = palabra + "es";
                    break;
                default:
                    plurales[i] = palabra; // Regla 1 y 2: no hay cambio en la palabra
            }
        }
        
        ArrayList resultado = new ArrayList();
        resultado.add(plurales);
        resultado.add(cantidadesPorRegla);

        return resultado;
    }
    public static int aplicarRegla(String palabra) {
        char ultimaLetra = palabra.charAt(palabra.length() - 1);

        if (esVocal(ultimaLetra)) {
            return 0;
        } else if (ultimaLetra == 's' || ultimaLetra == 'x') {
            return 1;
        } else if (ultimaLetra == 'z') {
            return 2;
        } else {
            return 3;
        }
    }

    public static boolean esVocal(char letra) {
        return "aeiou".indexOf(letra) != -1;
    }

    public static boolean noAplicable(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
    
}
