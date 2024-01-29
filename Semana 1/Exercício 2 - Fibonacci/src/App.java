import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {        
        System.out.print("\nInforme o tamanho da sequência Fibonacci: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        generateFibonacciList(size);
        scanner.close();
    }

    public static void generateFibonacciList(int listLength){
        int aux1 = 0, aux2 = 1, number=0;
        for (int i=0; i<listLength; i++){
            if (i == 0 || i == 1){
                System.out.print(i + " ");
            }
            else {
                number = aux1 + aux2;
                System.out.print(number + " ");
                aux1 = aux2;
                aux2 = number;
            }
        }
        System.out.println("\n");
    }
}
