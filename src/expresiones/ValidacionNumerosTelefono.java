package expresiones;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class ValidacionNumerosTelefono {
    public static void main(String[] args) {
        
        // Crear un objeto Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Solicitar al usuario que ingrese un número de teléfono en el formato de México
        System.out.println("Ingrese un número de telefono (ejemplo: (55) 1234-5678 o (555) 123-4567):");
        String numeroTelefono = scanner.nextLine();
        scanner.close(); // Cerrar el objeto Scanner 
       
        
        // Expresión regular para validar el número
        String regex = "^\\(\\d{2,3}\\) \\d{3,4}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        // Crear un objeto Matcher para realizar coincidencias con el número de teléfono
        Matcher matcher = pattern.matcher(numeroTelefono);
        
        // if para verificar si el número de teléfono coincide con la expresión regular
        if (matcher.matches()) {       
            System.out.println("El numero de telefono es correcto en formato de Mexico");
        } else {
            System.out.println("El numero de telefono no es valido en el formato de Mexico");
        } // Cierre del bloque "else"
    }//cierre del main
}//cierre de clase principal

