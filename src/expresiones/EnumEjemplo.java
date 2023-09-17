package expresiones;

public class EnumEjemplo { 

    // Declaración de la enumeración CategoriaLibro
    public enum CategoriaPelicula { 
        CIENCIA_FICCION,
        FANTASIA,
        COMEDIA,
        TERROR
        
    }
// Declaración de la clase estática 
    public static class Pelicula { 
        private String titulo; 
        private String autor; 
        private CategoriaPelicula categoria; 

        // Declaración del constructor de la clase Pelicula
        public Pelicula(String titulo, String autor, CategoriaPelicula categoria) { 
            // Inicialización de los atributo titulo, autor y categoria
            this.titulo = titulo; 
            this.autor = autor; 
            this.categoria = categoria; 
        }

        @Override
        // Declaración del método toString() para la clase Pelicula
        public String toString() { 
            return "Titulo: " + titulo + ", Autor: " + autor + ", Categoria: " + categoria;
        }
    }

    public static void main(String[] args) { // Declaración del método main
        
        // Creación de un objeto Pelicula (Pelicula1,Pelicula2 y Pelicula3 ) y asignación de valores
        Pelicula Pelicula1 = new Pelicula("Harry Potter", " J. K. Rowling", CategoriaPelicula.FANTASIA); 
        Pelicula Pelicula2 = new Pelicula("La monja 2", "Gary Dauberman", CategoriaPelicula.TERROR);
        Pelicula Pelicula3 = new Pelicula("La ultima Ola", "Ron Jones", CategoriaPelicula.CIENCIA_FICCION);
        Pelicula Pelicula4 = new Pelicula("Somos como niños", "Dennis Dugan", CategoriaPelicula.COMEDIA);

// Impresión del libro1 llamando a su método 
        System.out.println(Pelicula1); 
        System.out.println(Pelicula2); 
        System.out.println(Pelicula3); 
        System.out.println(Pelicula4); 
    }
}

