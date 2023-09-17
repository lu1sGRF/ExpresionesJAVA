package expresiones;
import java.util.*;

class Nodo {

    int operando;
    int esOperando;
    char opr;

    Nodo izquierdo;
    Nodo derecho;

    Nodo(int operando, char opr, int esOperando) {
        this.operando = operando;
        this.esOperando = esOperando;
        this.izquierdo = null;
        this.derecho = null;
        this.opr = opr;
    }//ciere del nodo constructor
}

public class EvaluarExpresiones {

    public static Nodo crearNodo(int operando, char opr, int esOperando) {
        return new Nodo(operando, opr, esOperando);
    }//cierre de crearNodo

    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }//cierre del metodo esOperando

    public static int precedencia(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '^') {
            return 3;
        }
        return 0;
    }//fin del precedencia

    public static String infijoAposfijo(String infix) {
        StringBuilder posfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String[] tokens = infix.split("\\s+");
        for (String token : tokens) {
            char c = token.charAt(0);
            if (c == 'x' || c == 'y' || Character.isDigit(c)) {
                if (Character.isDigit(c)) {
                    posfix.append(token).append(" ");
                } else {
                    System.out.println("Escribe el digito para x/y:");
                    Scanner consola = new Scanner(System.in);
                    var lectura = consola.nextLine();
                    posfix.append(lectura).append(" ");
                }}
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        posfix.append(stack.pop()).append(" ");
                    }//fin del while
                    stack.pop();
                } else if (esOperador(c)) {
                    while (!stack.isEmpty() && precedencia(c) <= precedencia(stack.peek())) {
                        posfix.append(stack.pop()).append(" ");
                    }//cierre de while
                    stack.push(c);
                }//cierre else if
            }//cierre for
            while (!stack.isEmpty()) {
                posfix.append(stack.pop()).append(" ");
            }//cierre while
            return posfix.toString();
        }//cierre de infijoAposfijo

    

    

    public static Nodo construirArbolExpresiones(String posfij) {
        Stack<Nodo> stack = new Stack<>();
        String[] tokens = posfij.split("\\s+");
        for (String token : tokens) {
            char c = token.charAt(0);
            if (Character.isDigit(c)) {
                int aux = Integer.parseInt(token);
                stack.push(crearNodo(aux, '#', 1));
            } else if (esOperador(c)) {
                Nodo nuevoNodo = crearNodo(-1, c, 0);
                nuevoNodo.derecho = stack.pop();
                nuevoNodo.izquierdo = stack.pop();
                stack.push(nuevoNodo);
            }//fin del else if
        }//cierre del for
        return stack.pop();
    }//cierre construirArbol

    public static int evaluarArborlExpresiones(Nodo node) {
        if (node.esOperando == 1) {
            return node.operando;
        }

        int izqVal = evaluarArborlExpresiones(node.izquierdo);
        int derVal = evaluarArborlExpresiones(node.derecho);

        switch (node.opr) {
            case '+':
                return izqVal + derVal;
            case '-':
                return izqVal - derVal;
            case '*':
                return izqVal * derVal;
            case '/':
                if (derVal == 0) {
                    throw new ArithmeticException("No se puede dividir entre cero");
                }
                return izqVal / derVal;
            case '^':
                double cuadrado = Math.pow(izqVal, derVal);
                return (int) cuadrado;
            default:
                return 0;

        }//cierre del switch

    }//Cierre del metodo evaluarExpresion

    public static void main(String[] args) {
        String expresion = "4 ^ 2 / ( y + 6 ) * 2";
        String posfixExpresion = infijoAposfijo(expresion);
        System.out.println("La expresion infijo a posfijo es: " + posfixExpresion);
        Nodo expressionTree = construirArbolExpresiones(posfixExpresion);
        int result = evaluarArborlExpresiones(expressionTree);
        System.out.println("Resultado de expresion: " + result);
    }//fin del public static

}//cierre de la clase principal EvaluarExpresiones
