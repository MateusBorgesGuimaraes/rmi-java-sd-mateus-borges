import java.rmi.*;
 
public interface Hello extends Remote {
   public String hello() throws RemoteException;
   public double calcularDelta(double a, double b, double c) throws RemoteException;
}