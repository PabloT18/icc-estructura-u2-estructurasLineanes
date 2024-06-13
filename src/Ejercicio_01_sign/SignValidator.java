package Ejercicio_01_sign;

import Materia.Pilas.StackGeneric;

/**
 * Clase SignValidator
 * 
 * Este ejercicio consiste en implementar un algoritmo para determinar si un
 * string que
 * contiene solo los caracteres '(', ')', '{', '}', '[' y ']' es válido.
 * Un string es considerado válido si:
 * - Los paréntesis de apertura se cierran en el orden correcto.
 * 
 * Ejemplo de uso:
 * SignValidator validParenthesis = new SignValidator();
 * boolean resultado = validParenthesis.isValid("([]){}"); // True
 */
public class SignValidator {
    /**
     * Método isValid
     * 
     * Verifica si un string de paréntesis es válido.
     * 
     * @param s el string que contiene los paréntesis a validar
     * @return true si el string es válido, false en caso contrario
     */
    public boolean isValid(String s) {
        StackGeneric<Character> stack = new StackGeneric<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(getOpposite(c));
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * Método getOpposite
     * 
     * Devuelve el paréntesis de cierre correspondiente a un paréntesis de apertura
     * dado.
     * 
     * @param c el paréntesis de apertura
     * @return el paréntesis de cierre correspondiente, o '0' si no es un paréntesis
     *         de apertura válido
     */
    private char getOpposite(char c) {
        if (c == '(') {
            return ')';
        }
        if (c == '{') {
            return '}';
        }
        if (c == '[') {
            return ']';
        }

        return '0';
    }

}
