import java.util.Scanner;
public class Calc_Kata {
    static Scanner in = new Scanner(System.in);
    static char operation;
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
    }
}