import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("\nInforme um número de para gerar a pirâmide: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        System.out.println("\n");
        for (int i=1; i<=number; i++){
            for (int j=i; j>0; j--){
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }
}
