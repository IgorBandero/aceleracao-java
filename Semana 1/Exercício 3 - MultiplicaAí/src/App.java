import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.print("\nInforme um número para gerar a tabela: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        System.out.println("\nTabela de multiplicação por " + number + "\n");
        for (int i=1; i<=10; i++){
            System.out.println(number + " * " + i + " = " + (number*i));
        }
    }
}
