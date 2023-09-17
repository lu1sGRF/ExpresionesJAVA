package expresiones;
import java.util.ArrayList;
import java.util.regex.*;

public class ValidacionDireccionesPaginasWeb {
    
    public static void main(String[] args) {
        
        // Definir un texto de ejemplo que contiene direcciones de páginas web
        String texto = "Este es un texto de ejemplo que contiene algunas direcciones de paginas web.\n"
                + "Puedes encontrar URLs como https://www.ejemplo.com, http://www.otra-url.com,\n"
                + "\n"
                + "o incluso www.sitio-web.org. Asegurate de buscar www.google.com todas las URLs, independientemente\n"
                + "de si comienzan con ”https://”, ”http://”, o simplemente ”www.”.";
        
        // Llamar a la función obtenerURL para extraer las URLs del texto
        ArrayList<String> urls = obtenerURL(texto);
        
        // Imprimir las URLs encontradas
        System.out.println("URLs encontradas:");
        for (String url : urls) {
            System.out.println(url);
        }//cierre del for
    }//cierre del main
    
    public static ArrayList<String> obtenerURL(String texto) {
        // Expresión regular para buscar URLs en el texto
        String regex = "(https?://)?(www\\.)?[a-zA-Z0-9\\-]+(\\.[a-zA-Z]+)+(/[a-zA-Z0-9\\-._~:/?#\\[\\]@!$&'()*+,;=]*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        ArrayList<String> urls = new ArrayList<>();
        
        // Buscar coincidencias en el texto y agregarlas a la lista de URLs
        while (matcher.find()) {
            String url = matcher.group();
            urls.add(url);
        }//cierre del while
        
        return urls;
    }//cierre de obtenerURL
}//cierre de la clase principal

