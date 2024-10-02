import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer implements Hello {
	public HelloServer() {} 

	public static void main(String[] args) {
		try {
			HelloServer server = new HelloServer();
	
			Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
			
			Registry registry = LocateRegistry.getRegistry();
	
			registry.bind("Servidor", stub);
			
			System.out.println("Servidor inicializado com sucesso.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
	
    public String hello() throws RemoteException {
        System.out.println("Executando método neste host");
        return "Ola!!!! Consegui executar o método remoto!!!";
    }

    public double calcularDelta(double a, double b, double c) throws RemoteException {
        return (b * b) - (4 * a * c);
    }
}