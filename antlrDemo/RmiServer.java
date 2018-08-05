import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServer extends Remote {
	public Integer checkFile(String path) throws RemoteException;
}
