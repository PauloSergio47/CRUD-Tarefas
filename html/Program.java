import java.util.Scanner;

public class Program {

public static void main(String[] args) {
   
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite um valor: ");
    double A = sc.nextDouble();

    double por = A += 0.5;

    System.out.println("Porcentagem: "+por);

    sc.close();

    }
}