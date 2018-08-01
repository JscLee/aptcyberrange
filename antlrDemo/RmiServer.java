import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServer extends Remote {	
	public boolean checkFile(String path) throws RemoteException;
}
