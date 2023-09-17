package expresiones;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionCorreoElectronico {
    public static void main(String[] args) {
       
        // Crear un objeto Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario que ingrese una direccion de correo electrónico
        System.out.println("Ingresa el correo electronico: ");
        String correo = scanner.nextLine();
        scanner.close(); // Cerrar el objeto Scanner

        // Expresión regular para verificar la validez de la dirección de correo electronico
        String regex = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.-]?[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}$";

        // Compilar la expresión regular en un objeto Pattern
        Pattern pattern = Pattern.compile(regex);
        // Crear un objeto Matcher para realizar coincidencias con la cadena de correo electrónico
        Matcher matcher = pattern.matcher(correo);

        if (matcher.matches()) {          
            System.out.println("El correo es correcto");
        } else {           
            System.out.println("El correo no es valido");
            
        } // Cierre del bloque "else"
    } // Cierre del método "main"
} // Cierre de la clase principal

