import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Informe um número: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number != 0){
            System.out.println(number + " é " + checkEvenOrOdd(number) + " e " + checkPositiveOrNegative(number));
        }
        else {
            System.out.println("O número é zero!");
        }
        scanner.close();
    }

    public static String checkEvenOrOdd(int number){
        if (number%2 == 0){
            return "par";
        }
        else {
            return "ímpar";
        }
    }

    public static String checkPositiveOrNegative(int number){
        String message = "";
        if (number > 0){
            message = "positivo.";
        }
        else if (number < 0){
            message = "negativo.";
        }
        return message;
    }
}
