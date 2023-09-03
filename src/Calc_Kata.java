import java.util.Scanner;
public class Calc_Kata {
    static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
        String inputData = read.nextLine();
        System.out.print(inputData);

    }
}