import java.util.InputMismatchException;
import java.util.Scanner;
public class Calc_Kata {
    static Scanner in = new Scanner(System.in);
    static char operation;
    static int number1, number2, result;
    public static void main(String[] args) {
        System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
        String inputData = in.nextLine(); //считывание строки
        char[] sym = new char[10]; //создание символьного массива для посимвольного считывния введеной строки
        for (int i = 0; i < inputData.length(); i++) {
            sym[i] = inputData.charAt(i);
            if (sym[i] == '+') {
                operation = '+';
            }
            if (sym[i] == '-') {
                operation = '-';
            }
            if (sym[i] == '*') {
                operation = '*';
            }
            if (sym[i] == '/') {
                operation = '/';
            }
        }
        String symString = String.valueOf(sym);
        String[] terms = symString.split("[+-/*]");
        String summand1 = terms[0];
        String summand2WithNull = terms[1];
        String summand2 = summand2WithNull.trim();
        number1 = romanToNumber(summand1);
        number2 = romanToNumber(summand2);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);
            String resultRoman = convertNumToRoman(result);
            System.out.println(summand1 + " " + operation + " " + summand2 + " = " + resultRoman);
        }
        number1 = Integer.parseInt(summand1);
        number2 = Integer.parseInt(summand2);
        result = calculated(number1, number2, operation);
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

}