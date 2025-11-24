import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        int numberInput;
        double resultFactorial=1;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число больше 1 и меньше 14:   ");
        numberInput = scan.nextInt();

        if (numberInput>1 & numberInput<14) {

            for (int i = 1; i <= numberInput; i++) {
                resultFactorial *= i;
            }
            System.out.println("Факториал числа " + numberInput + " равен " + resultFactorial);
        } else System.out.println("Вы ввели некорректное число");

    }
}
