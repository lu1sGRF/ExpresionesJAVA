package expresiones;


public class Token {
    
    private String valor;
    private Tipos tipo;
    
    
    
    enum Tipos{
        NUMERO ("\\b[0-9]+\\b"),
        OPERADOR ("[*|/|+|-]"),
        VARIABLE ("[w|x|y|z]"),
        CONSTANTE ("\\b(pi|e)\\b"),
        DESCONOCIDO("");

        
        public final String patron;
        
        Tipos(String s){
            this.patron=s;
        }//cierre constructor tipos

    
    }//cierre enum

    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public Tipos getTipo() {
        return tipo;
    }
    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }
}
