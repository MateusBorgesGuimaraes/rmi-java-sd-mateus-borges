import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	public static void main(String[] args) {
		try {
		
			Registry registry = LocateRegistry.getRegistry("localhost");

			Hello stub= (Hello) registry.lookup("Servidor");
	
            try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Digite o valor de a: ");
				double a = scanner.nextDouble();

				System.out.print("Digite o valor de b: ");
				double b = scanner.nextDouble();

				System.out.print("Digite o valor de c: ");
				double c = scanner.nextDouble();

				System.out.println("Enviando valores para o servidor...");
				double delta = stub.calcularDelta(a, b, c);
				System.out.println("Delta calculado pelo servidor: " + delta);
			}
            
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}