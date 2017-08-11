package pink.dcc.ufla.br.wiplayer.utils;

/**
 * Created by aluno on 11/08/17.
 */

public class StringUtils {

    /**
     * Faz o padding de zeros à esquerda de um número e o retorna como string.
     * @param number numero a ser convertido
     * @param digits número de digitos que o resultado final deve conter
     * @return string contendo o padding de zeros caso o número não tenha digitos o suficiente.
     */
    public static String padNumber(int number, int digits) {
        String inputAsString = Integer.toString(number);
        int inputNumberDigits = inputAsString.length();
        int remainingDigits = digits - inputNumberDigits;
        if (remainingDigits == 0) {
            return inputAsString;
        }
        String padding = String.format("%0" + remainingDigits + "d", 0);

        return padding + inputAsString;
    }

}
